package ab.selector;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import spfworld.spfworld.R;


/**
 * 相册列表Adapter
 * @author zhouyou
 */
public class ImageBucketAdapter extends BaseAdapter {

	private List<ImageBucket> mDataList;
	private Activity mActivity;
	private BitmapCache mCache;
	
	BitmapCache.ImageCallback callback = new BitmapCache.ImageCallback() {
		public void imageLoad(ImageView imageView, Bitmap bitmap,Object... params) {
			if (imageView != null && bitmap != null) {
				String url = (String) params[0];
				if (url != null && url.equals((String) imageView.getTag())) {
					((ImageView) imageView).setImageBitmap(bitmap);
				} else {
				}
			} else {
			}
		}
	};

	public ImageBucketAdapter(Activity act, List<ImageBucket> list) {
		this.mActivity = act;
		mDataList = list;
		mCache = new BitmapCache();
	}

	public int getCount() {
		int count = 0;
		if (mDataList != null) {
			count = mDataList.size();
		}
		return count;
	}

	public Object getItem(int arg0) {
		return null;
	}

	public long getItemId(int arg0) {
		return arg0;
	}

	class Holder {
		private ImageView iv;
		private ImageView selected;
		private TextView name;
		private TextView count;
	}

	public View getView(int arg0, View arg1, ViewGroup arg2) {
		Holder holder;
		if (arg1 == null) {
			holder = new Holder();
			arg1 = View.inflate(mActivity, R.layout.item_image_bucket, null);
			holder.iv = (ImageView) arg1.findViewById(R.id.image);
			holder.selected = (ImageView) arg1.findViewById(R.id.isselected);
			holder.name = (TextView) arg1.findViewById(R.id.name);
			holder.count = (TextView) arg1.findViewById(R.id.count);
			arg1.setTag(holder);
		} else {
			holder = (Holder) arg1.getTag();
		}
		ImageBucket item = mDataList.get(arg0);
		holder.count.setText("" + item.count);
		holder.name.setText(item.bucketName);
		holder.selected.setVisibility(View.GONE);
		if (item.imageList != null && item.imageList.size() > 0) {
			String thumbPath = item.imageList.get(0).thumbnailPath;
			String sourcePath = item.imageList.get(0).imagePath;
			holder.iv.setTag(sourcePath);
			mCache.displayBmp(holder.iv, thumbPath, sourcePath, callback);
		} else {
			holder.iv.setImageBitmap(null);
		}
		return arg1;
	}
}
