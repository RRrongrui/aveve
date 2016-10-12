package spfworld.spfworld.adapter.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.entity.User.UserOrder;
import spfworld.spfworld.utils.Contants;

/**
 * Created by Administrator on 2016/9/28.
 */
public class UserOrderAdapter extends BaseAdapter {
    private List<UserOrder.DataBean> userData;
    private Context context;
    private LayoutInflater layoutInflater;
    public UserOrderAdapter(Context context, List<UserOrder.DataBean> userData){
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
            convertView = layoutInflater.inflate(R.layout.user_order_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        intiuserorder((UserOrder.DataBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void intiuserorder(UserOrder.DataBean userData, ViewHolder holder) {
        ImageLoader.getInstance().displayImage(Contants.IMAGE_BASE_URL+userData.getContent(),holder.ivpicture);
        if (userData.getOrder_id()!=null){
            holder.tvnubur.setText(userData.getOrder_num().toString());
            holder.tvlefttime.setText(userData.getJoindate().toString());
            holder.tvordertilte.setText(userData.getAct_theme().toString());
            holder.tvmiddleright.setText(userData.getAct_address().toString());
            holder.tvdownright.setText(userData.getNum().toString());
            holder.tvprice.setText(userData.getTotal_price().toString());
        }

    }


protected class ViewHolder {
        private ImageView ivpicture;//图片
        private TextView tvlefttime;//活动时间
        private TextView tvordertilte;//活动名称
        private TextView tvmiddleright;//活动地址
        private TextView tvdownright;//数量
        private TextView tvprice;//价格
        private TextView tvnubur;//订单号


        public ViewHolder(View view) {
            ivpicture = (ImageView) view.findViewById(R.id.iv_picture);
            tvnubur = (TextView) view.findViewById(R.id.tv_left_two);
            tvordertilte = (TextView) view.findViewById(R.id.tv_ordertilte);
            tvmiddleright= (TextView) view.findViewById(R.id.tv_middle_right);
            tvdownright = (TextView) view.findViewById(R.id.tv_down_right);
            tvprice = (TextView) view.findViewById(R.id.tv_price);
            tvlefttime = (TextView) view.findViewById(R.id.tv_up_right);

        }
    }
}

