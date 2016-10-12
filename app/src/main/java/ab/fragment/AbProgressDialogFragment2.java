package ab.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

/**
 * © 2012 amsoft.cn 名称：AbLoadDialogFragment.java 描述：弹出的进度框
 * 
 * @author 还如一梦中
 * @version v1.0
 * @date：2014-07-29 上午9:00:52
 */
public class AbProgressDialogFragment2 extends DialogFragment {

	int mIndeterminateDrawable;
	String mMessage;
	static View mContentView;

	/**
	 * Create a new instance of AbProgressDialogFragment.
	 */
	public static AbProgressDialogFragment2 newInstance(
			int indeterminateDrawable, String message) {
		AbProgressDialogFragment2 f = new AbProgressDialogFragment2();
		Bundle args = new Bundle();
		args.putInt("indeterminateDrawable", indeterminateDrawable);
		args.putString("message", message);
		f.setArguments(args);

		return f;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mIndeterminateDrawable = getArguments().getInt("indeterminateDrawable");
		mMessage = getArguments().getString("message");

		ProgressDialog mProgressDialog = new ProgressDialog(getActivity(),
				AlertDialog.THEME_HOLO_LIGHT);
		if (mIndeterminateDrawable > 0) {
			mProgressDialog.setIndeterminateDrawable(getActivity()
					.getResources().getDrawable(mIndeterminateDrawable));
		}

		if (mMessage != null) {
			mProgressDialog.setMessage(mMessage);
		}
		// 点击外面不会消失
		mProgressDialog.setCanceledOnTouchOutside(false);
		// 扑捉Back
//		mProgressDialog.setOnKeyListener(new OnKeyListener() {
//            
//            @Override
//            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
//                // TODO Auto-generated method stub
//
//                return true;
//            }
//        });

		return mProgressDialog;
	}
	

}
