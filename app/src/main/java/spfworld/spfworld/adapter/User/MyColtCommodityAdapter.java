package spfworld.spfworld.adapter.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.entity.User.ColtComm;
import spfworld.spfworld.utils.ImageLoad;

/**
 * Created by Administrator on 2016/9/29.
 */
public class MyColtCommodityAdapter extends BaseAdapter {
    private List<ColtComm.DataBean> objects;
    private Context context;
    private LayoutInflater layoutInflater;

    public MyColtCommodityAdapter(Context context, List<ColtComm.DataBean> objects) {
        this.context = context;
        this.objects=objects;
        this.layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.collont_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((ColtComm.DataBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }
    private void initializeViews(ColtComm.DataBean object , ViewHolder holder) {
        ImageLoad imageLoad=new ImageLoad();
        imageLoad.HttpImage("http://m.yundiaoke.cn"+object.getImages_url(),holder.iv_img_tt);
        holder.textView_up.setText(object.getName());
        holder.textView_down.setText(object.getPrice());
//        holder.tv_shuliang.setText(object.getAddress());
    }
    protected class ViewHolder {
        private ImageView iv_img_tt;
        private TextView textView_up;
        private TextView textView_down;
//        private TextView tv_shuliang;

        public ViewHolder(View view) {
            iv_img_tt = (ImageView) view.findViewById(R.id.iv_img_tt);
            textView_up = (TextView) view.findViewById(R.id.textView_up);
            textView_down = (TextView) view.findViewById(R.id.textView_down);
//            tv_shuliang = (TextView) view.findViewById(R.id.tv_shuliang);
        }
    }
    }
