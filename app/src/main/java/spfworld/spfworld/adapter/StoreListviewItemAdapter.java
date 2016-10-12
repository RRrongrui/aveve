package spfworld.spfworld.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import spfworld.spfworld.R;
import spfworld.spfworld.entity.StoreList;
import spfworld.spfworld.utils.ImageLoad;

public class StoreListviewItemAdapter extends BaseAdapter {

    private List<StoreList.DataBean> objects;

    private Context context;
    private LayoutInflater layoutInflater;

    public StoreListviewItemAdapter(Context context,List<StoreList.DataBean> objects) {
        this.context = context;
        this.objects=objects;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public StoreList.DataBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.store_listview_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((StoreList.DataBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(StoreList.DataBean object, ViewHolder holder) {
        ImageLoad imageLoad=new ImageLoad();
        imageLoad.HttpListImage("http://"+object.getImages_url(),holder.storeListImg);
        holder.storeListName.setText(object.getName());
        holder.storeListMony.setText("￥"+object.getPrice());
        switch (object.getIs_top()){
            case "0":
                holder.storeListXin.setVisibility(View.INVISIBLE);
                break;
            case "1":
                holder.storeListXin.setText("新品");
                break;
            case "2":
                holder.storeListXin.setText("一周特价推荐");
                break;
            case "3":
                holder.storeListXin.setText("好物推荐");
                break;
        }
    }

    protected class ViewHolder {
        private ImageView storeListImg;
    private TextView storeListName;
    private TextView storeListMony;
    private TextView storeListXin;

        public ViewHolder(View view) {
            storeListImg = (ImageView) view.findViewById(R.id.store_list_img);
            storeListName = (TextView) view.findViewById(R.id.store_list_name);
            storeListMony = (TextView) view.findViewById(R.id.store_list_mony);
            storeListXin = (TextView) view.findViewById(R.id.store_list_xin);
        }
    }
}
