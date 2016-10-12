package spfworld.spfworld.adapter.Tribune;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.entity.Tribune.TribuneComment;
import spfworld.spfworld.utils.ImageLoad;
import spfworld.spfworld.widget.percent.view.CircleImageView;

/**
 * Created by Administrator on 2016/9/26.
 */
public class TribuneCommentAdapter extends BaseAdapter{
        private List<TribuneComment.DataBean>datalist = new ArrayList<TribuneComment.DataBean>();

        private Context context;
        private LayoutInflater layoutInflater;

        public TribuneCommentAdapter(Context context, List<TribuneComment.DataBean> objects) {
            this.context = context;
            this.datalist=datalist;
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return datalist.size();
        }

        @Override
        public TribuneComment.DataBean getItem(int position) {
            return datalist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.item_comment_layout, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initData((TribuneComment.DataBean)getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initData(TribuneComment.DataBean datalist, ViewHolder holder) {
            ImageLoad imageLoad=new ImageLoad();
            imageLoad.HttpImage("http://m.yundiaoke.cn"+ datalist.getHeadpic(),holder.userPic);
            holder.userName.setText(datalist.getUsername());
            holder.tvDate.setText(datalist.getReplys());
            holder.tvReply.setText(datalist.getR_id());
            holder.tvTime.setText(datalist.getCreated_at());
            holder.btComent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        protected class ViewHolder {
            private CircleImageView userPic ;
            private TextView userName;
            private TextView tvDate;
            private TextView tvReply;
            private TextView tvTime;

            private ImageView btComent;

            public ViewHolder(View view) {
                userPic = (CircleImageView) view.findViewById(R.id.iv);
                userName = (TextView) view.findViewById(R.id.tv_title);
                tvDate = (TextView) view.findViewById(R.id.tv_date);
                tvReply= (TextView) view.findViewById(R.id.tv_floor2_two);
                tvTime= (TextView) view.findViewById(R.id.tv_date_two);
                btComent = (ImageView) view.findViewById(R.id.bt_topic_coment);
            }
        }
    }


