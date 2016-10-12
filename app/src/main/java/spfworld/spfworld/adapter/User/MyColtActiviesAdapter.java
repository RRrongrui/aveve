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
import spfworld.spfworld.entity.User.ColtActis;
import spfworld.spfworld.utils.ImageLoad;

/**
 * Created by Administrator on 2016/9/29.
 */
public class MyColtActiviesAdapter extends BaseAdapter {
    private List<ColtActis.DataBean> objects;
    private Context context;
    private LayoutInflater layoutInflater;

    public MyColtActiviesAdapter(Context context, List<ColtActis.DataBean> objects) {
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
        return  objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.collont_item_activies, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((ColtActis.DataBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }
    private void initializeViews(ColtActis.DataBean object , ViewHolder holder) {
        ImageLoad imageLoad=new ImageLoad();
        imageLoad.HttpImage("http://m.yundiaoke.cn"+object.getContent(),holder.iv_img_acti);
        holder.textView_up.setText(object.getTheme());
        holder.tv_time_acti.setText(object.getBegin_time());
        holder.tv_arss.setText(object.getAddress());
    }
    protected class ViewHolder {
        private ImageView iv_img_acti;
        private TextView textView_up;
        private TextView tv_time_acti;
        private TextView tv_arss;

        public ViewHolder(View view) {
            iv_img_acti = (ImageView) view.findViewById(R.id.iv_img_acti);
            textView_up = (TextView) view.findViewById(R.id.textView_up);
            tv_time_acti = (TextView) view.findViewById(R.id.tv_time_acti);
            tv_arss = (TextView) view.findViewById(R.id.tv_arss);
        }
    }
}
