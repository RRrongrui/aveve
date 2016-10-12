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
import spfworld.spfworld.entity.User.ColtFond;
import spfworld.spfworld.utils.ImageLoad;

/**
 * Created by Administrator on 2016/9/29.
 */
public class MyColtFondAdapter extends BaseAdapter {
    private List<ColtFond.DataBean> objects;
    private Context context;
    private LayoutInflater layoutInflater;

    public MyColtFondAdapter(Context context, List<ColtFond.DataBean> objects) {
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
            convertView = layoutInflater.inflate(R.layout.colt_fond, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((ColtFond.DataBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(ColtFond.DataBean object , ViewHolder holder) {
        //添加数据
        ImageLoad imageLoad=new ImageLoad();
        imageLoad.HttpImage("http://m.yundiaoke.cn"+object.getContent(),holder.colt_pond_pic);
//        ImageLoad imageLoad=new ImageLoad();
//        imageLoad.HttpImage("http://"+object.getContent(),holder.colt_pond_pic);
        holder.colt_pond_name_img.setText(object.getTheme());
        holder.colt_pond_mony.setText(object.getPrice());
        holder.colt_assed.setText(object.getAddress());
    }

    protected class ViewHolder {
        private ImageView colt_pond_pic;
        private TextView colt_pond_name_img;
        private TextView colt_pond_mony;
        private TextView colt_assed;

        public ViewHolder(View view) {
            colt_pond_pic = (ImageView) view.findViewById(R.id.colt_pond_pic);
            colt_pond_name_img = (TextView) view.findViewById(R.id.colt_pond_name_img);
            colt_pond_mony = (TextView) view.findViewById(R.id.colt_pond_mony);
            colt_assed = (TextView) view.findViewById(R.id.colt_assed);
        }
    }
}
