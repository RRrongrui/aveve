package spfworld.spfworld.widget.percent.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;


public class MyGridView2 extends GridView{
	public MyGridView2(Context context) {
		super(context);
	}
	public MyGridView2(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public MyGridView2(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int mExpandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);  
        super.onMeasure(widthMeasureSpec, mExpandSpec);

	}
}
