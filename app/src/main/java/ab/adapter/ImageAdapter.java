package ab.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import ab.bean.ImageFloder;
import spfworld.spfworld.R;


public class ImageAdapter extends CommonAdapter<ImageFloder> {

    public ImageAdapter(Context context, List<ImageFloder> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, ImageFloder t, int position) {
        TextView id_dir_item_name = holder.getView(R.id.id_dir_item_name);
        ImageView id_dir_item_image = holder.getView(R.id.id_dir_item_image);
        TextView id_dir_item_count = holder.getView(R.id.id_dir_item_count);
        id_dir_item_name.setText(t.getName());
        id_dir_item_count.setText(t.getCount() + "张");
        ImageLoader.getInstance().displayImage("file://" + t.getFirstImagePath(),id_dir_item_image);

    }

}
