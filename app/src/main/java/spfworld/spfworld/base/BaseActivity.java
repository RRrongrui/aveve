package spfworld.spfworld.base;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import spfworld.spfworld.R;


public abstract class BaseActivity extends FragmentActivity {

	protected Context context;
	private TextView titleView;
	private TextView leftView;
	private TextView rightView;
	private ImageButton rightImageView;
	private ImageButton leftImageView;

	private OnClickListener clickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (v == leftView) {
				onLeftClick(v);
			} else if (v == rightView) {
				onRightClick(v);
			} else if (v == rightImageView) {
				onRightImageViewClick(v);
			} else if (v == leftImageView) {
				onLeftImageViewClick(v);
			}
		}
	};

	public void setTitle(String title) {
		titleView = (TextView) findViewById(R.id.title);
		titleView.setText(title);
		titleView.setVisibility(View.VISIBLE);
	}

	public void setTitle(String title, int color) {
		titleView = (TextView) findViewById(R.id.title);
		titleView.setText(title);
		titleView.setTextColor(color);
		titleView.setVisibility(View.VISIBLE);
	}

	public void setTitleLeftText(String value) {
		leftView = (TextView) findViewById(R.id.title_left_text);
		leftView.setText(value);
		leftView.setVisibility(View.VISIBLE);
		leftView.setOnClickListener(clickListener);
	}

	public void setTitleLeftText(String value, int resid) {
		leftView = (TextView) findViewById(R.id.title_left_text);
		leftView.setText(value);
		leftView.setBackgroundResource(resid);
		leftView.setVisibility(View.VISIBLE);
		leftView.setOnClickListener(clickListener);
	}

	public void setTitleLeftImg(int resid) {
		leftImageView = (ImageButton) findViewById(R.id.title_left_img);
		leftImageView.setImageResource(resid);
		leftImageView.setVisibility(View.VISIBLE);
		leftImageView.setOnClickListener(clickListener);
	}

	public void setTitleRightText(String value, int color) {
		rightView = (TextView) findViewById(R.id.title_right_text);
		rightView.setText(value);
		rightView.setVisibility(View.VISIBLE);
		rightView.setTextColor(color);
		rightView.setOnClickListener(clickListener);
	}

	public void setTitleRightText(String value) {
		rightView = (TextView) findViewById(R.id.title_right_text);
		rightView.setText(value);
		rightView.setVisibility(View.VISIBLE);
		rightView.setOnClickListener(clickListener);
	}

	public void setTitleRightImg(int resid) {
		rightImageView = (ImageButton) findViewById(R.id.title_right_img);
		rightImageView.setImageResource(resid);
		rightImageView.setVisibility(View.VISIBLE);
		rightImageView.setOnClickListener(clickListener);
	}

	public TextView getLeftView() {
		return leftView;
	}

	public TextView getRightView() {
		return rightView;
	}

	public ImageButton getRightImageView() {
		return rightImageView;
	}

	public ImageButton getLeftImageView() {
		return leftImageView;
	}

	protected void onLeftClick(View view) {

	}

	protected void onRightClick(View view) {

	}

	protected void onRightImageViewClick(View view) {

	}

	protected void onLeftImageViewClick(View view) {
		finish();
	}
}
