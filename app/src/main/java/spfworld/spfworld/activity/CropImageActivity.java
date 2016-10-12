package spfworld.spfworld.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

import ab.ProgressWheel;
import ab.util.AbFileUtil;
import ab.util.AbImageUtil;
import ab.view.cropimage.CropImage;
import ab.view.cropimage.CropImageView;
import spfworld.spfworld.R;

public class CropImageActivity extends Activity implements OnClickListener {
	private CropImageView mImageView;
	private Bitmap mBitmap;

	private CropImage mCrop;

	private Button mSave;
	private Button mCancel, rotateLeft, rotateRight;
	private String mPath = "CropImageActivity";
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
//				Toast.makeText(CropImageActivity.this, getResources().getString(R.string.no_findimg), 0).show();
				finish();
			} else {
				resetImageView(mBitmap);
			}
		} catch (Exception e) {
//			Toast.makeText(CropImageActivity.this, getResources().getString(R.string.no_findimg), 0).show();
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
//			if(!TextUtils.isEmpty(getIntent().getStringExtra("type"))){
				Intent intent = new Intent();
				intent.putExtra("PATH", path);
				setResult(RESULT_OK, intent);
				finish();
				return;
//			}
			
			/**
			 * 个人修改头像
			 */
//			uploadPortrait(path);
//			break;
//		case R.id.rotateLeft:
////			mCrop.startRotate(270.f);
//			break;
//		case R.id.rotateRight:
////			mCrop.startRotate(90.f);
//			break;

		}
	}
	/**
	 * 上传头像
	 * @param path
	 */
//	private Dialog dialog;
////	private User user;
//	private void uploadPortrait(final String path) {
////		user=UserDao.getInstance(CropImageActivity.this).getUser();
//		dialog=createLoadingDialog(this, getResources().getString(R.string.updateing));
//		dialog.setCancelable(false);
//		dialog.show();
//			@Override
//			public void handleResponse(UpdatePortraitResponse response) {
//				if(CropImageActivity.this!=null){
//					if(dialog!=null&&dialog.isShowing()){
//						dialog.dismiss();
//						if(user!=null){
//
//							AbToastUtil.showCustomerToast(CropImageActivity.this,getResources().getString(R.string.update_success));
//							Intent intent = new Intent();
//							intent.putExtra("PATH", path);
//							setResult(RESULT_OK, intent);
//							finish();
//						}
//					}
//				}
//			}
//			@Override
//			public void handleError(String errorCode, String errorMessage) {
//				if(CropImageActivity.this!=null){
//					if(dialog!=null&&dialog.isShowing()){
//						dialog.dismiss();
//					}
//					AbToastUtil.showCustomerToast(CropImageActivity.this, getResources().getString(R.string.update_failure));
//				}
//			}
//		});
//	}
	/** 
     * 得到自定义的progressDialog 
     * @param context 
     * @param msg 
     * @return 
     */  
    public  Dialog createLoadingDialog(Context context, String msg) {  
        LayoutInflater inflater = LayoutInflater.from(context);  
        View v = inflater.inflate(R.layout.herily_alertex_dialog_custom_frame_layout, null);// 得到加载view  
        ProgressWheel spaceshipImage = (ProgressWheel) v.findViewById(R.id.customFrameLoadImg);  
        spaceshipImage.stopSpinning();
        spaceshipImage.startSpinning();
        TextView tipTextView = (TextView) v.findViewById(R.id.customFrameMsg);// 提示文字  
        tipTextView.setText(msg);// 设置加载信息  
        Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog  
        loadingDialog.setCancelable(false);// 不可以用“返回键”取消  
        loadingDialog.setContentView(v, new LinearLayout.LayoutParams(  
                LinearLayout.LayoutParams.FILL_PARENT,  
                LinearLayout.LayoutParams.FILL_PARENT));// 设置布局  
        return loadingDialog;  
    }  
}

