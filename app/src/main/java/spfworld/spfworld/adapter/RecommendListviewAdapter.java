package spfworld.spfworld.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import spfworld.spfworld.R;
import spfworld.spfworld.activity.EventDetailActivity;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.entity.EventRecommend;
import spfworld.spfworld.utils.ImageLoad;

public class RecommendListviewAdapter extends BaseAdapter {

    private List<List<EventRecommend.DataBean>> objects;

    private Context context;
    private LayoutInflater layoutInflater;

    public RecommendListviewAdapter(Context context,List<List<EventRecommend.DataBean>> objects) {
        this.context = context;
        this.objects=objects;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public List<EventRecommend.DataBean> getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.recommend_listview, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((List<EventRecommend.DataBean>)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(final List<EventRecommend.DataBean> object, ViewHolder holder) {
        ImageLoad imageLoad=new ImageLoad();
        for (int i=0;i<object.size();i++){
            switch (i) {
                case 0:
                    imageLoad.HttpImage("http://" + object.get(i).getContent(), holder.recommendImgLeft);
                    holder.recommendListviewLeftName.setText(object.get(i).getTheme());
                    holder.recommendListviewLeftMtime.setText("活动时间:" + object.get(i).getBegin_time());
                    holder.recommendListviewLeftTime.setText("报名截止:" + object.get(i).getEnd_time());
                    holder.recommend_LeftRL.setOnClickListener(new View.OnClickListener() {//item内控件点击事件
                        @Override
                        public void onClick(View v) {
                            Content.act_id = object.get(0).getAct_id();
                            Intent intent = new Intent(context, EventDetailActivity.class);
                            context.startActivity(intent);
                        }
                    });
                    break;
                case 1:
                    imageLoad.HttpImage("http://" + object.get(i).getContent(), holder.recommendListviewRightSImg);
                    holder.recommendListviewRightSLeft.setText("活动时间:" + object.get(i).getBegin_time());
                    holder.recommendListviewRightSRight.setText("报名截止:" + object.get(i).getEnd_time());
                    holder.recommendListviewRightSName.setText(object.get(i).getTheme());
                    holder.recommend_SRL.setOnClickListener(new View.OnClickListener() {//item内控件点击事件
                        @Override
                        public void onClick(View v) {
                            Content.act_id = object.get(1).getAct_id();
                            Intent intent = new Intent(context, EventDetailActivity.class);
                            context.startActivity(intent);
                        }
                    });
                    break;
                case 2:
                    imageLoad.HttpImage("http://" + object.get(i).getContent(), holder.recommendListviewRightXImg);
                    holder.recommendListviewRightXLeft.setText("活动时间:" + object.get(i).getBegin_time());
                    holder.recommendListviewRightXRight.setText("报名截止:" + object.get(i).getEnd_time());
                    holder.recommendListviewRightXName.setText(object.get(i).getTheme());
                    holder.recommend_XRL.setOnClickListener(new View.OnClickListener() {//item内控件点击事件
                        @Override
                        public void onClick(View v) {
                            Content.act_id = object.get(2).getAct_id();
                            Intent intent = new Intent(context, EventDetailActivity.class);
                            context.startActivity(intent);
                        }
                    });
                    break;
            }
        }
    }

    protected class ViewHolder {
        private ImageView recommendImgLeft;
    private TextView recommendListviewLeftName;
    private TextView recommendListviewLeftMtime;
    private TextView recommendListviewLeftTime;
    private ImageView recommendListviewRightSImg;
    private TextView recommendListviewRightSName;
    private TextView recommendListviewRightSLeft;
    private TextView recommendListviewRightSRight;
    private ImageView recommendListviewRightXImg;
    private TextView recommendListviewRightXName;
    private TextView recommendListviewRightXLeft;
    private TextView recommendListviewRightXRight;
        private RelativeLayout recommend_LeftRL;
        private RelativeLayout recommend_SRL;
        private RelativeLayout recommend_XRL;

        public ViewHolder(View view) {
            recommendImgLeft = (ImageView) view.findViewById(R.id.recommend_img_left);
            recommendListviewLeftName = (TextView) view.findViewById(R.id.recommend_listview_left_name);
            recommendListviewLeftMtime = (TextView) view.findViewById(R.id.recommend_listview_left_mtime);
            recommendListviewLeftTime = (TextView) view.findViewById(R.id.recommend_listview_left_time);
            recommendListviewRightSImg = (ImageView) view.findViewById(R.id.recommend_listview_right_s_img);
            recommendListviewRightSName = (TextView) view.findViewById(R.id.recommend_listview_right_s_name);
            recommendListviewRightSLeft = (TextView) view.findViewById(R.id.recommend_listview_right_s_left);
            recommendListviewRightSRight = (TextView) view.findViewById(R.id.recommend_listview_right_s_right);
            recommendListviewRightXImg = (ImageView) view.findViewById(R.id.recommend_listview_right_x_img);
            recommendListviewRightXName = (TextView) view.findViewById(R.id.recommend_listview_right_x_name);
            recommendListviewRightXLeft = (TextView) view.findViewById(R.id.recommend_listview_right_x_left);
            recommendListviewRightXRight = (TextView) view.findViewById(R.id.recommend_listview_right_x_right);
            recommend_LeftRL= (RelativeLayout) view.findViewById(R.id.recommend_left_RL);
            recommend_SRL= (RelativeLayout) view.findViewById(R.id.recommend_s_RL);
            recommend_XRL= (RelativeLayout) view.findViewById(R.id.recommend_x_RL);
        }
    }
}
