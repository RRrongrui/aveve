package spfworld.spfworld.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;

import spfworld.spfworld.R;


/**
 * PopupWindow类
 * @author zhouyou
 */
public class MyPopupWindow implements OnClickListener{
	
	private static PopupWindow mPopupWindow;
	private static ListView mListViwe;
	private static String mItemStr;
	private Context mContext;
	private LinearLayout mPopupView;
	
	public MyPopupWindow(Context context) {
		this.mContext = context;
	}

	/**
	 * 显示从底部弹出的PopupWindow
	 * @param
	 * @param arrays 字符串数组
	 * @return 用户点击的条目
	 */
	public String showPopupWindowForFoot(final String[] arrays, final Callback callback) {
		// 加载PopupWindow布局
		View contentView = LayoutInflater.from(mContext).inflate(R.layout.item_popupwindow, null);
		
		// 创建PopupWindow对象
		mPopupWindow = new PopupWindow(contentView, LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT, true);
		
		// 设置点击事件
		contentView.findViewById(R.id.pw_rootView).setOnClickListener(this);;
		contentView.findViewById(R.id.item_popupwindows_cancel).setOnClickListener(this);;	
		
		// 设置动画
		contentView.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim_alpha));
		mPopupView = (LinearLayout) contentView.findViewById(R.id.ll_popup);
		mPopupView.startAnimation(AnimationUtils.loadAnimation(mContext,R.anim.anim_translate_popup));
		
		// 设置数据适配器
		class MyAdapter extends BaseAdapter{
			@Override
			public int getCount() {
				return arrays.length;
			}
			@Override
			public Object getItem(int position) {
				return arrays[position];
			}
			@Override
			public long getItemId(int position) {
				return position;
			}
			@Override
			public View getView(final int position, View convertView, ViewGroup parent) {
				ViewHolder holder;
				if(convertView == null){
					holder = new ViewHolder();
					convertView = View.inflate(mContext, R.layout.item_list_popupwindow, null);
					holder.btn_item = (Button) convertView.findViewById(R.id.btn_item);
					convertView.setTag(holder);
					
				}else {
					holder = (ViewHolder) convertView.getTag();
				}
				holder.btn_item.setText(arrays[position]);
				holder.btn_item.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						mItemStr = arrays[position];
						callback.callback(mItemStr,position);
						mPopupWindow.dismiss();
					}
				});
				return convertView;
			}
			class ViewHolder{
				Button btn_item;
			}
		}
		mListViwe = (ListView) contentView.findViewById(R.id.listview);
		mListViwe.setAdapter(new MyAdapter());
		
		// 显示PopupWindow
		View rootview = LayoutInflater.from(mContext).inflate(R.layout.activity_main, null);
		mPopupWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
		return mItemStr;
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.pw_rootView:
			onDismiss();
			break;
		case R.id.item_popupwindows_cancel:
			onDismiss();
			break;
		}
	}
	
	/** 隐藏PopupWindow */
	public void onDismiss(){
		if (mPopupWindow != null) {
			mPopupWindow.dismiss();
		}
	}

	public interface Callback{
		public void callback(String text, int position);
	}
}
