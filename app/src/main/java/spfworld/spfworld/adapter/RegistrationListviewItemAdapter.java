package spfworld.spfworld.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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

public class RegistrationListviewItemAdapter extends BaseAdapter  {

    private List<List<EventRecommend.DataBean>> objects;
    private Context context;
    private LayoutInflater layoutInflater;

    public RegistrationListviewItemAdapter(Context context,List<List<EventRecommend.DataBean>> objects) {
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
            convertView = layoutInflater.inflate(R.layout.registration_listview_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((List<EventRecommend.DataBean>)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(final List<EventRecommend.DataBean> object, ViewHolder holder) {
        ImageLoad imageLoad=new ImageLoad();
        for (int i=0;i<object.size();i++){
            switch (i){
                case 0:
                    imageLoad.HttpImage("http://"+object.get(i).getContent(),holder.registrationSImg);
                    holder.registrationSName.setText(object.get(i).getTheme());
                    holder.registrationSMtime.setText("活动时间:"+object.get(i).getBegin_time());
                    holder.registrationSTime.setText("报名截止:"+object.get(i).getEnd_time());
                    holder.regtstrationSRL.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.e("444444444","点击事件发生");
                            Content.act_id=object.get(0).getAct_id();
                            Intent intent=new Intent(context, EventDetailActivity.class);
                            context.startActivity(intent);
                        }
                    });
                    break;
                case 1:
                    imageLoad.HttpImage("http://"+object.get(i).getContent(),holder.registrationLeftImg);
                    holder.registrationLeftName.setText(object.get(i).getTheme());
                    holder.registrationLeftMtime.setText("活动时间:"+object.get(i).getBegin_time());
                    holder.registrationLeftTime.setText("报名截止:"+object.get(i).getEnd_time());
                    holder.regtstrationLeftRL.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Content.act_id=object.get(1).getAct_id();
                            Intent intent=new Intent(context, EventDetailActivity.class);
                            context.startActivity(intent);
                        }
                    });
                    break;
                case 2:
                    imageLoad.HttpImage("http://"+object.get(i).getContent(),holder.registrationRightImg);
                    holder.registrationRightName.setText(object.get(i).getTheme());
                    holder.registrationRightMtime.setText("活动时间:"+object.get(i).getBegin_time());
                    holder.registrationRightTime.setText("报名截止:"+object.get(i).getEnd_time());
                    holder.regtstrationRightRL.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Content.act_id=object.get(2).getAct_id();
                            Intent intent=new Intent(context, EventDetailActivity.class);
                            context.startActivity(intent);
                        }
                    });
                    break;
            }
        }
    }



    protected class ViewHolder {
        private ImageView registrationSImg;
    private TextView registrationSName;
    private TextView registrationSMtime;
    private TextView registrationSTime;
    private ImageView registrationLeftImg;
    private TextView registrationLeftName;
    private TextView registrationLeftMtime;
    private TextView registrationLeftTime;
    private ImageView registrationRightImg;
    private TextView registrationRightName;
    private TextView registrationRightMtime;
    private TextView registrationRightTime;
        private RelativeLayout regtstrationSRL;
        private RelativeLayout regtstrationLeftRL;
        private RelativeLayout regtstrationRightRL;

        public ViewHolder(View view) {
            registrationSImg = (ImageView) view.findViewById(R.id.registration_s_img);
            registrationSName = (TextView) view.findViewById(R.id.registration_s_name);
            registrationSMtime = (TextView) view.findViewById(R.id.registration_s_mtime);
            registrationSTime = (TextView) view.findViewById(R.id.registration_s_time);
            registrationLeftImg = (ImageView) view.findViewById(R.id.registration_left_img);
            registrationLeftName = (TextView) view.findViewById(R.id.registration_left_name);
            registrationLeftMtime = (TextView) view.findViewById(R.id.registration_left_mtime);
            registrationLeftTime = (TextView) view.findViewById(R.id.registration_left_time);
            registrationRightImg = (ImageView) view.findViewById(R.id.registration_right_img);
            registrationRightName = (TextView) view.findViewById(R.id.registration_right_name);
            registrationRightMtime = (TextView) view.findViewById(R.id.registration_right_mtime);
            registrationRightTime = (TextView) view.findViewById(R.id.registration_right_time);
            regtstrationSRL= (RelativeLayout) view.findViewById(R.id.registration_s_RL);
            regtstrationLeftRL= (RelativeLayout) view.findViewById(R.id.registration_left_RL);
            regtstrationRightRL= (RelativeLayout) view.findViewById(R.id.registration_right_RL);
        }
    }
}
