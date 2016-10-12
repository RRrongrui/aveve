package spfworld.spfworld.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.ListView;

/**
 * Created by guozhengke on 2016/9/13.
 */
public  class EventScorllView extends GridView {



    public EventScorllView(Context context) {
        super(context);
    }

    public EventScorllView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EventScorllView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
