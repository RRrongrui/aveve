package spfworld.spfworld.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import spfworld.spfworld.R;
import spfworld.spfworld.entity.Pond;
import spfworld.spfworld.utils.ImageLoad;

public class PondItemAdapter extends BaseAdapter {

    private List<Pond.DataBean> objects;
    private Context context;
    private LayoutInflater layoutInflater;

    public PondItemAdapter(Context context, List<Pond.DataBean> objects) {
        this.context = context;
        this.objects=objects;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Pond.DataBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.pond_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((Pond.DataBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(Pond.DataBean object, ViewHolder holder) {
        ImageLoad imageLoad=new ImageLoad();
        if (!object.getBig_img().equals("")){
            imageLoad.HttpImage("http://m.yundiaoke.cn"+object.getBig_img(),holder.pondImg);
        }else {
            holder.pondImg.setImageResource(R.mipmap.bottom);
        }

        holder.pondMony.setText(object.getPrice());

        holder.pondName.setText(object.getTheme());
        if (object.getJuli()<1){
            holder.pondLong.setText("距您"+(object.getJuli()*1000)+"米");
        }else {
            holder.pondLong.setText("距您"+object.getJuli()+"公里");
        }
        switch (object.getStatus()){
            case "0":
                holder.fish_one.setImageResource(R.mipmap.pond_star_f);
                holder.fish_two.setImageResource(R.mipmap.pond_star_f);
                holder.fish_th.setImageResource(R.mipmap.pond_star_f);
                holder.fish_fo.setImageResource(R.mipmap.pond_star_f);
                holder.fish_five.setImageResource(R.mipmap.pond_star_f);
                break;
            case "1":
                holder.fish_one.setImageResource(R.mipmap.pond_star);
                holder.fish_two.setImageResource(R.mipmap.pond_star_f);
                holder.fish_th.setImageResource(R.mipmap.pond_star_f);
                holder.fish_fo.setImageResource(R.mipmap.pond_star_f);
                holder.fish_five.setImageResource(R.mipmap.pond_star_f);
                break;
            case "2":
                holder.fish_one.setImageResource(R.mipmap.pond_star);
                holder.fish_two.setImageResource(R.mipmap.pond_star);
                holder.fish_th.setImageResource(R.mipmap.pond_star_f);
                holder.fish_fo.setImageResource(R.mipmap.pond_star_f);
                holder.fish_five.setImageResource(R.mipmap.pond_star_f);
                break;
            case "3":
                holder.fish_one.setImageResource(R.mipmap.pond_star);
                holder.fish_two.setImageResource(R.mipmap.pond_star);
                holder.fish_th.setImageResource(R.mipmap.pond_star);
                holder.fish_fo.setImageResource(R.mipmap.pond_star_f);
                holder.fish_five.setImageResource(R.mipmap.pond_star_f);
                break;
            case "4":
                holder.fish_one.setImageResource(R.mipmap.pond_star);
                holder.fish_two.setImageResource(R.mipmap.pond_star);
                holder.fish_th.setImageResource(R.mipmap.pond_star);
                holder.fish_fo.setImageResource(R.mipmap.pond_star);
                holder.fish_five.setImageResource(R.mipmap.pond_star_f);
                break;
            case "5":
                holder.fish_one.setImageResource(R.mipmap.pond_star);
                holder.fish_two.setImageResource(R.mipmap.pond_star);
                holder.fish_th.setImageResource(R.mipmap.pond_star);
                holder.fish_fo.setImageResource(R.mipmap.pond_star);
                holder.fish_five.setImageResource(R.mipmap.pond_star);
                break;
        }

    }

    protected class ViewHolder {
        private ImageView pondImg;
        private TextView pondName;
        private TextView pondLong;
        private TextView pondMony;
        private TextView pondFish;
        private ImageView fish_one;
        private ImageView fish_two;
        private ImageView fish_th;
        private ImageView fish_fo;
        private ImageView fish_five;

        public ViewHolder(View view) {
            pondImg = (ImageView) view.findViewById(R.id.pond_img);
            pondName = (TextView) view.findViewById(R.id.pond_name);
            pondLong = (TextView) view.findViewById(R.id.pond_long);
            pondMony= (TextView) view.findViewById(R.id.pond_mony);
            fish_one = (ImageView) view.findViewById(R.id.pond_fish_one);
            fish_two = (ImageView) view.findViewById(R.id.pond_fish_two);
            fish_th = (ImageView) view.findViewById(R.id.pond_fish_th);
            fish_fo = (ImageView) view.findViewById(R.id.pond_fish_fo);
            fish_five = (ImageView) view.findViewById(R.id.pond_fish_five);
        }
    }
}
