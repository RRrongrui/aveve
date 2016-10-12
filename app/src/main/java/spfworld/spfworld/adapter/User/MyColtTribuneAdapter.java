package spfworld.spfworld.adapter.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.entity.User.ColtTribune;

/**
 * Created by Administrator on 2016/9/29.
 */
public class MyColtTribuneAdapter extends BaseAdapter {
    private List<ColtTribune.DataBean> objects;
    private Context context;
    private LayoutInflater layoutInflater;

    public MyColtTribuneAdapter(Context context, List<ColtTribune.DataBean> objects) {
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
            convertView = layoutInflater.inflate(R.layout.colt_tribune, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((ColtTribune.DataBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }
    private void initializeViews(ColtTribune.DataBean object , ViewHolder holder) {

        holder.tv_content.setText(object.getUsername());
        holder.tv_title.setText(object.getTitle());
        holder.tv_item_shuliang.setText(object.getCount());
    }
    protected class ViewHolder {

        private TextView tv_content;
        private TextView tv_title;
        private TextView tv_item_shuliang;

        public ViewHolder(View view) {
            tv_content = (TextView) view.findViewById(R.id.tv_content);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
            tv_item_shuliang = (TextView) view.findViewById(R.id.tv_item_shuliang);
        }
    }
}
