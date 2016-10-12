package spfworld.spfworld.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import spfworld.spfworld.R;
import spfworld.spfworld.entity.Event;
import spfworld.spfworld.utils.ImageLoad;

public class EventRecommendGridviewAdapter extends BaseAdapter {

    private List<Event.DataBean> objects ;
    private Context context;
    private LayoutInflater layoutInflater;

    public EventRecommendGridviewAdapter(Context context,List<Event.DataBean> objects) {
        this.context = context;
        this.objects=objects;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Event.DataBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.event_recommend_gridview, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((Event.DataBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(Event.DataBean object, ViewHolder holder) {
        //添加数据
        ImageLoad imageLoad=new ImageLoad();
        imageLoad.HttpImage("http://"+object.getContent(),holder.recommendImg);
        holder.recommendName.setText(object.getTheme());
        holder.recommendMtime.setText("活动事件:"+object.getBegin_time());
        holder.recommendTime.setText("报名截止:"+object.getDead_time());
    }
    protected class ViewHolder {
    private ImageView recommendImg;
    private TextView recommendName;
    private TextView recommendMtime;
    private TextView recommendTime;

        public ViewHolder(View view) {
            recommendImg = (ImageView) view.findViewById(R.id.recommend_img);
            recommendName = (TextView) view.findViewById(R.id.recommend_name);
            recommendMtime = (TextView) view.findViewById(R.id.recommend_mtime);
            recommendTime = (TextView) view.findViewById(R.id.recommend_time);
        }
    }
}
