package ab.selector;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.activity.Tribune.PostTribuneDateActivity;


/**
 * 图片展示页
 * @author zhouyou
 */
public class PhotoActivity extends Activity {
	
	public List<Bitmap> mBmp = new ArrayList<Bitmap>();
	public List<String> mDrr = new ArrayList<String>();
	public List<String> mDel = new ArrayList<String>();
	
	private RelativeLayout mPhotoRelativeLayout;
	private ArrayList<View> mListViews = null;
	private MyPageAdapter mAdapter;
	private ViewPager mPager;
	private int mCount;
	public int mMax;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo);

		mPhotoRelativeLayout = (RelativeLayout) findViewById(R.id.photo_relativeLayout);
		mPhotoRelativeLayout.setBackgroundColor(0x70000000);

		for (int i = 0; i < Bimp.mBmps.size(); i++) {
			mBmp.add(Bimp.mBmps.get(i));
		}
		for (int i = 0; i < Bimp.mDrr.size(); i++) {
			mDrr.add(Bimp.mDrr.get(i));
		}
		mMax = Bimp.mMax;

		Button photo_bt_exit = (Button) findViewById(R.id.photo_bt_exit);
		photo_bt_exit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		
		Button photo_bt_del = (Button) findViewById(R.id.photo_bt_del);
		photo_bt_del.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (mListViews.size() == 1) {
					Bimp.mBmps.clear();
					Bimp.mDrr.clear();
					Bimp.mMax = 0;
					FileUtils.deleteDir();
					PostTribuneDateActivity.mImagePath = "";
					finish();
				} else {
					String newStr = mDrr.get(mCount).substring(mDrr.get(mCount).lastIndexOf("/") + 1, mDrr.get(mCount).lastIndexOf("."));
					mBmp.remove(mCount);
					mDrr.remove(mCount);
					mDel.add(newStr);
					mMax--;
					mPager.removeAllViews();
					mListViews.remove(mCount);
					mAdapter.setListViews(mListViews);
					mAdapter.notifyDataSetChanged();
				}
			}
		});
		Button photo_bt_enter = (Button) findViewById(R.id.photo_bt_enter);
		photo_bt_enter.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Bimp.mBmps = mBmp;
				Bimp.mDrr = mDrr;
				Bimp.mMax = mMax;
				for(int i=0;i<mDel.size();i++){				
					FileUtils.delFile(mDel.get(i)+".JPEG"); 
				}
				finish();
			}
		});

		mPager = (ViewPager) findViewById(R.id.viewpager);
		mPager.addOnPageChangeListener(pageChangeListener);
		for (int i = 0; i < mBmp.size(); i++) {
			initListViews(mBmp.get(i));//
		}

		mAdapter = new MyPageAdapter(mListViews);// 构造adapter
		mPager.setAdapter(mAdapter);// 设置适配器
		Intent intent = getIntent();
		int id = intent.getIntExtra("ID", 0);
		mPager.setCurrentItem(id);
	}

	private void initListViews(Bitmap bm) {
		if (mListViews == null)
			mListViews = new ArrayList<View>();
		ImageView img = new ImageView(this);// 构造textView对象
		img.setBackgroundColor(0xff000000);
		img.setImageBitmap(bm);
		img.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		mListViews.add(img);// 添加view
	}

	private OnPageChangeListener pageChangeListener = new OnPageChangeListener() {

		public void onPageSelected(int arg0) {// 页面选择响应函数
			mCount = arg0;
		}
		public void onPageScrolled(int arg0, float arg1, int arg2) {// 滑动中
		}

		public void onPageScrollStateChanged(int arg0) {// 滑动状态改变
		}
	};

	class MyPageAdapter extends PagerAdapter {

		private ArrayList<View> listViews;// content
		private int size;// 页数

		public MyPageAdapter(ArrayList<View> listViews) {// 初始化viewpager的时候给的一个页面
			this.listViews = listViews;
			size = listViews == null ? 0 : listViews.size();
		}

		public void setListViews(ArrayList<View> listViews) {// 自己写的一个方法用来添加数据
			this.listViews = listViews;
			size = listViews == null ? 0 : listViews.size();
		}

		public int getCount() {// 返回数量
			return size;
		}

		public int getItemPosition(Object object) {
			return POSITION_NONE;
		}

		public void destroyItem(View arg0, int arg1, Object arg2) {// 销毁view对象
			((ViewPager) arg0).removeView(listViews.get(arg1 % size));
		}

		public void finishUpdate(View arg0) {}

		public Object instantiateItem(View arg0, int arg1) {// 返回view对象
			try {
				((ViewPager) arg0).addView(listViews.get(arg1 % size), 0);

			} catch (Exception e) {
			}
			return listViews.get(arg1 % size);
		}

		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}
	}
}
