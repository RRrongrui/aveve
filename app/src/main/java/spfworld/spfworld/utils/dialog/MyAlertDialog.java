package spfworld.spfworld.utils.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import spfworld.spfworld.R;


/**
 * Created by guozhengke on 2016-09-13.
 */

/**
 * 自定义弹出框
 */
public class MyAlertDialog {
    private String Title=null;
    private String Message=null;
    private AlertDialog.Builder builder;
    TextView AlertDialogTitle,AlertDialogMsg;
    Button AlertDialogBut1,AlertDialogBut2;
    AlertDialog alert;
LinearLayout linearLayout;
    public void  SetView(View v){
        AlertDialogMsg.setVisibility(View.GONE);
        linearLayout.addView(v);
    }
    public LinearLayout getContextview(){
        return linearLayout;
    }
    public void setbuilderview(View v){
        builder.setView(v);
        builder.setCancelable(true);
        alert=builder.create();
    }
    public MyAlertDialog(Context context){
        builder =new AlertDialog.Builder(context);
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View v=layoutInflater.inflate(R.layout.lertialogview,null);
        linearLayout= (LinearLayout) v.findViewById(R.id.ViewContext);
        AlertDialogTitle= (TextView) v.findViewById(R.id.AlertDialogTitle);
        AlertDialogMsg= (TextView) v.findViewById(R.id.AlertDialogMsg);
        AlertDialogBut1= (Button) v.findViewById(R.id.AlertDialogBut1);
        AlertDialogBut2= (Button) v.findViewById(R.id.AlertDialogBut2);
        builder.setView(v);
        builder.setCancelable(true);
        alert=builder.create();
    }
    public void SetDetermineButton(String ButMsg,View.OnClickListener onClickListener){
        AlertDialogBut1.setText(ButMsg);
        AlertDialogBut1.setOnClickListener(onClickListener);
    }
    public void SetCancelButton(String ButMsg,View.OnClickListener onClickListener){
        AlertDialogBut2.setText(ButMsg);
        AlertDialogBut2.setOnClickListener(onClickListener);
    }
    public void Show(){
        alert.show();
    }
    public void Dismiss(){
        alert.dismiss();
    }
    public String getMessage() {
        return Message;
    }

    public String getTitle() {
        return Title;
    }
    public void setMessage(String message) {
        Message = message;
        AlertDialogMsg.setText(message);
    }

    public void setTitle(String title) {
        Title = title;
        AlertDialogTitle.setText(title);
    }
}
