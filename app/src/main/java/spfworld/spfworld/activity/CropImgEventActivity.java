package spfworld.spfworld.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.io.File;

import ab.util.AbFileUtil;
import ab.util.AbImageUtil;
import ab.view.cropimage.CropImage;
import ab.view.cropimage.CropImageView;
import spfworld.spfworld.R;


public class CropImgEventActivity extends Activity implements OnClickListener {
	private CropImageView mImageView;
	private Bitmap mBitmap;

	private CropImage mCrop;

	private Button mSave;
	private Button mCancel, rotateLeft, rotateRight;
	private String mPath = "CropImgEventActivity";
	public int screenWidth = 0;
	public int screenHeight = 0;

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {

			switch (msg.what) {
			case 1:
				break;

			}

		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.crop_image);
		init();
	}

	@Override
	protected void onStop() {
		super.onStop();
		if (mBitmap != null) {
			mBitmap = null;
		}
	}

	private void init() {
		getWindowWH();
		mPath = getIntent().getStringExtra("PATH");

		mImageView = (CropImageView) findViewById(R.id.crop_image);
		mSave = (Button) this.findViewById(R.id.okBtn);
		mCancel = (Button) this.findViewById(R.id.cancelBtn);
//		rotateLeft = (Button) this.findViewById(R.id.rotateLeft);
//		rotateRight = (Button) this.findViewById(R.id.rotateRight);
		mSave.setOnClickListener(this);
		mCancel.setOnClickListener(this);
//		rotateLeft.setOnClickListener(this);
//		rotateRight.setOnClickListener(this);
		
		// 相册中原来的图片
		File mFile = new File(mPath);
		
		try {
			mBitmap = AbFileUtil.getBitmapFromSD(mFile, AbImageUtil.SCALEIMG,
					500, 500);
			if (mBitmap == null) {
				finish();
			} else {
				resetImageView(mBitmap);
			}
		} catch (Exception e) {
			finish();
		}
	}

	/**
	 * 获取屏幕的高和宽
	 */
	private void getWindowWH() {
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		screenWidth = dm.widthPixels;
		screenHeight = dm.heightPixels;
	}

	private void resetImageView(Bitmap b) {
		mImageView.clear();
		mImageView.setImageBitmap(b);
		mImageView.setImageBitmapResetBase(b, true);
		mCrop = new CropImage(this, mImageView, mHandler);
		mCrop.crop(b);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.cancelBtn:
			finish();
			break;
		case R.id.okBtn:
			Bitmap cropBitmap= mCrop.cropAndSave();
			String path = mCrop.saveToLocal(cropBitmap);
			if(!TextUtils.isEmpty(getIntent().getStringExtra("type"))){
				Intent intent = new Intent();
				intent.putExtra("PATH", path);
				setResult(RESULT_OK, intent);
				finish();
				return;
			}
			Intent intent = new Intent();
			intent.putExtra("PATH", path);
			setResult(RESULT_OK, intent);
			finish();
			
			break;
//		case R.id.rotateLeft:
//			mCrop.startRotate(270.f);
//			break;
//		case R.id.rotateRight:
//			mCrop.startRotate(90.f);
//			break;

		}
	}
	
	
}

