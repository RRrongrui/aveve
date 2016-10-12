package spfworld.spfworld.fragment.find.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import spfworld.spfworld.MainActivity;
import spfworld.spfworld.R;
import spfworld.spfworld.activity.LoginActivity;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.entity.Login;
import spfworld.spfworld.utils.SharedHelper;
import spfworld.spfworld.utils.XutilsClass;
import spfworld.spfworld.utils.dialog.MyAlertDialog;

/**
 * Created by guozhengke on 2016/9/8.
 * 登录页fragment
 */
public class LoginFragment extends Fragment {
    @ViewInject(R.id.login_register)
    private TextView tv_register;
    @ViewInject(R.id.btn_login)
    private  TextView btn_login;
    @ViewInject(R.id.id_frag_regis_name)
    private EditText et_phone;
    @ViewInject(R.id.id_frag_regis_pwd)
    private EditText et_pwd;
    @ViewInject(R.id.login_back)
    private ImageView login_back;
    @ViewInject(R.id.login_reset)
    private TextView login_reset;

    private Handler handler;
    private SharedHelper sharedHelper;//登录轻量级缓存
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.activity_login_lanyout,container,false);
        x.view().inject(this,view);
        //跳转进入注册页
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity loginActivity= (LoginActivity) getActivity();
                handler=loginActivity.handler;
                Message message=new Message();
                message.what=1;
                handler.sendMessage(message);
            }
        });
        //登录按钮点击事件
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetLogin();
            }
        });
        //返回跳转页面
        login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        //重置
        login_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MyAlertDialog dialog=new MyAlertDialog(getActivity());
                dialog.setTitle("系统提示");
                dialog.setMessage("确认要退出吗？");
                dialog.SetDetermineButton("确认", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(),"queren", Toast.LENGTH_SHORT).show();
                        dialog.Dismiss();
                    }
                });
                dialog.SetCancelButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.Dismiss();
                    }
                });
                dialog.Show();
            }
        });
        return view;
    }
    //网络请求
    public void GetLogin(){
        final String setPhone=et_phone.getText().toString();
        final String setPassword=et_pwd.getText().toString();
        XutilsClass.getInstance().getLogin(setPhone, setPassword, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("GetLogin++++++",s);
                Gson gson=new Gson();
                Login login=gson.fromJson(s,Login.class);
                if (login.getStatus()==200){
                    sharedHelper=new SharedHelper(getActivity());
                    sharedHelper.PutData("String","mobile",setPhone);
                    sharedHelper.PutData("String","password",setPassword);
                    sharedHelper.PutData("String","Userid",login.getData().getUserid());
                    sharedHelper.PutData("String","user_key",login.getData().getToken());
                    Log.e("GetLogin++++++",Content.phone+setPassword+login.getData().getToken());
                    Intent intent=new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(),"欢迎您！", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getActivity(),"登录失败,"+login.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(Throwable throwable, boolean b) {
            }
            @Override
            public void onCancelled(CancelledException e) {
            }
            @Override
            public void onFinished() {
            }
        });
    }
}
