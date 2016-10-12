package spfworld.spfworld.adapter.Tribune;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import spfworld.spfworld.R;

/**
 * Created by Administrator on 2016/9/27.
 */
public class GridAdapter3 extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<String> photo;

    public GridAdapter3(Context context, List<String> pic) {
        this.context = context;
        this.photo=photo;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return photo.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_grid3_tribunedatail, parent, false);
            holder.imageView = (ImageView) convertView.findViewById(R.id.iv_tribune_data3);

            convertView.setTag(holder);
        } else {
            holder= (ViewHolder) convertView.getTag();
        }

//        ImageLoad imageLoad=new ImageLoad();
//        imageLoad.HttpImage(Contants.IMAGE_BASE_URL+pic.get(position),holder.imageView);
//        AbLogUtil.i("oye","image == "+Contants.IMAGE_BASE_URL+pic.get(position));
        return convertView;
    }
    static class ViewHolder {
        ImageView imageView;
    }
}
