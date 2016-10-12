package spfworld.spfworld.widget.percent.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;

import spfworld.spfworld.R;

/**
 * Created by Administrator on 2016/8/31.
 */
public class MyGridView extends GridView {
    private Context context;

    public MyGridView(Context context) {
        super(context);
        this.context=context;
    }

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }

    private void init() {
        View view= LayoutInflater.from(context).inflate(R.layout.item_grid_tribune,null);
    }
}
