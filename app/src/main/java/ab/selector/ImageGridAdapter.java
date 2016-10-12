package ab.selector;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spfworld.spfworld.R;


public class ImageGridAdapter extends BaseAdapter {

	public Map<String, String> mMap = new HashMap<String, String>();
	private TextCallback mTextcallback = null;
	private List<ImageItem> mDataList;
	private Activity mActivity;
	private BitmapCache mCache;
	private Handler mHandler;
	private int mSelectTotal = 0;
	
	BitmapCache.ImageCallback callback = new BitmapCache.ImageCallback() {
		public void imageLoad(ImageView imageView, Bitmap bitmap, Object... params) {
			if (imageView != null && bitmap != null) {
				String url = (String) params[0];
				if (url != null && url.equals((String) imageView.getTag())) {
					((ImageView) imageView).setImageBitmap(bitmap);
				}
			}
		}
	};

	public static interface TextCallback {
		public void onListen(int count);
	}

	public void setTextCallback(TextCallback listener) {
		mTextcallback = listener;
	}

	public ImageGridAdapter(Activity act, List<ImageItem> list, Handler mHandler) {
		this.mActivity = act;
		mDataList = list;
		mCache = new BitmapCache();
		this.mHandler = mHandler;
	}

	public int getCount() {
		int count = 0;
		if (mDataList != null) {
			count = mDataList.size();
		}
		return count;
	}
	
	public Object getItem(int position) {
		return null;
	}
	
	public long getItemId(int position) {
		return position;
	}

	class Holder {
		private ImageView iv;
		private ImageView selected;
		private TextView text;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		final Holder holder;
		if (convertView == null) {
			holder = new Holder();
			convertView = View.inflate(mActivity, R.layout.item_image_grid, null);
			holder.iv = (ImageView) convertView.findViewById(R.id.image);
			holder.selected = (ImageView) convertView.findViewById(R.id.isselected);
			holder.text = (TextView) convertView.findViewById(R.id.item_image_grid_text);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		final ImageItem item = mDataList.get(position);

		holder.iv.setTag(item.imagePath);
		mCache.displayBmp(holder.iv, item.thumbnailPath, item.imagePath,callback);
		if (item.isSelected) {
			holder.selected.setImageResource(R.mipmap.icon_data_select);
			holder.text.setBackgroundResource(R.drawable.bgd_relatly_line);
		} else {
			holder.selected.setImageResource(-1);
			holder.text.setBackgroundColor(0x00000000);
		}
		holder.iv.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String path = mDataList.get(position).imagePath;
				if ((Bimp.mDrr.size() + mSelectTotal) < 9) {
					item.isSelected = !item.isSelected;
					if (item.isSelected) {
						holder.selected.setImageResource(R.mipmap.icon_data_select);
						holder.text.setBackgroundResource(R.drawable.bgd_relatly_line);
						mSelectTotal++;
						if (mTextcallback != null)
							mTextcallback.onListen(mSelectTotal);
						mMap.put(path, path);
					} else if (!item.isSelected) {
						holder.selected.setImageResource(-1);
						holder.text.setBackgroundColor(0x00000000);
						mSelectTotal--;
						if (mTextcallback != null)
							mTextcallback.onListen(mSelectTotal);
						mMap.remove(path);
					}
				} else if ((Bimp.mDrr.size() + mSelectTotal) >= 9) {
					if (item.isSelected == true) {
						item.isSelected = !item.isSelected;
						holder.selected.setImageResource(-1);
						mSelectTotal--;
						mMap.remove(path);
					} else {
						Message message = Message.obtain(mHandler, 0);
						message.sendToTarget();
					}
				}
			}
		});
		return convertView;
	}
}
