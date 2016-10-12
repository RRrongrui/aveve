package spfworld.spfworld.adapter.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.adapter.Tribune.GridAdapter;
import spfworld.spfworld.entity.User.UserMyTribune;

/**
 * Created by Administrator on 2016/10/10.
 */
public class UserMyTribuneAdapter extends BaseAdapter {
    private List<UserMyTribune.DataBean> userData;
    private Context context;
    private LayoutInflater layoutInflater;
    public UserMyTribuneAdapter(Context context, List<UserMyTribune.DataBean> userData){
        this.context = context;
        this.userData=userData;
        this.layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return userData.size();
    }

    @Override
    public Object getItem(int position) {
        return userData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.user_tribune_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        intiuserorder((UserMyTribune.DataBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }
    private void intiuserorder(UserMyTribune.DataBean userData, ViewHolder holder) {
        if (userData.getC_id()!=null){
//            holder.tv_day.setText(userData.getOrder_num().toString());
//            holder.tv_title.setText(userData.getJoindate().toString());
            holder.tv_content.setText(userData.getTitle().toString());
            holder.tv_info.setText(userData.getComment().toString());
            holder.tv_minute.setText(userData.getCreated_at().toString());
            holder.tv_love.setText(userData.getZan().toString());
            holder.tv_comment.setText(userData.getReplycount().toString());
            if (userData.getPic()!=null&&userData.getPic().size()>0){
                holder.mGrid.setAdapter(new GridAdapter(context, userData.getPic()));
            }

        }
    }
    protected class ViewHolder {
        private TextView tv_day;//日期
        private TextView tv_title;//月份
        private TextView tv_content;//标题
        private TextView tv_info;//内容
        private TextView tv_minute;//时间
        private TextView tv_love;//点赞数
        private TextView tv_comment;//品论数
        private GridView mGrid;


        public ViewHolder(View view) {
            tv_day = (TextView) view.findViewById(R.id.tv_day);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
            tv_content= (TextView) view.findViewById(R.id.tv_content);
            tv_info = (TextView) view.findViewById(R.id.tv_info);
            tv_minute = (TextView) view.findViewById(R.id.tv_minute);
            tv_love = (TextView) view.findViewById(R.id.tv_love);
            tv_comment = (TextView) view.findViewById(R.id.tv_comment);
            mGrid = (GridView) view.findViewById(R.id.mGrid);
        }
    }

}
