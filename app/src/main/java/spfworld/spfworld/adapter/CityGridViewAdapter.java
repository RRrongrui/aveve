package spfworld.spfworld.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.xutils.view.annotation.ViewInject;

import spfworld.spfworld.R;

/**
 * Created by guozhengke on 2016/9/5.
 */
public class CityGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mcitys={"北京","三亚","西安","武汉","上海","深圳","宁波","南京","温州"};

    public CityGridViewAdapter(Context context){
        this.mContext=context;
    }
    @Override
    public int getCount() {
        return mcitys.length;
    }

    @Override
    public Object getItem(int position) {
        return mcitys[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
