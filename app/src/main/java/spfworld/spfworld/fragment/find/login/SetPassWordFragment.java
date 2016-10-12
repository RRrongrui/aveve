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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import spfworld.spfworld.MainActivity;
import spfworld.spfworld.R;
import spfworld.spfworld.activity.LoginActivity;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.entity.Login;
import spfworld.spfworld.entity.SetPassWord;
import spfworld.spfworld.utils.SharedHelper;
import spfworld.spfworld.utils.XutilsClass;

/**
 * Created by guozhengke on 2016/9/9.
 */
public class SetPassWordFragment extends Fragment {
    @ViewInject(R.id.register_butn)
    private TextView register_butn;
    @ViewInject(R.id.set_name_et)
    private EditText set_name;
    @ViewInject(R.id.set_password_et)
    private EditText set_password;
    @ViewInject(R.id.set_password_loginBack)
    private ImageView set_password_loginBack;
    private SharedHelper sharedHelper;//登录轻量级缓存


    private Handler handler;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.setpassword,container,false);
        x.view().inject(this,view);
        sharedHelper=new SharedHelper(getActivity());
        //返回键
        set_password_loginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity loginActivity= (LoginActivity) getActivity();
                handler=loginActivity.handler;
                Message message=new Message();
                message.what=1;
                handler.sendMessage(message);
            }
        });
        //点击注册完成跳转
        register_butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetPassWord();
            }
        });

        return view;
    }
    //注册网络请求接口
    public void GetPassWord(){
        String setName=set_name.getText().toString();
        final String setPassword=set_password.getText().toString();
        Log.e("传入参数数据",setName+setPassword+Content.verification+Content.phone);
        XutilsClass.getInstance().getPassWord(setName, Content.phone,Content.verification,setPassword,new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("SetPassWordFragment",s);
                Gson gson=new Gson();
                SetPassWord setPassWord=gson.fromJson(s,SetPassWord.class);
                if (setPassWord.getStatus()==200){
                    //Toast.makeText(getActivity(),"注册成功"+setPassWord.getMessage(), Toast.LENGTH_SHORT).show();
                    GetLogin(setPassword);
                }else {
                    Toast.makeText(getActivity(),"登录失败,"+setPassWord.getMessage(), Toast.LENGTH_SHORT).show();
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
    //判断字符串是否全部为数字
    public boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
    //注册完成后登录网络请求
    public void GetLogin(final String setPassword){
        XutilsClass.getInstance().getLogin(Content.phone, setPassword, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("GetLogin++++++",s);
                Gson gson=new Gson();
                Login login=gson.fromJson(s,Login.class);
                if (login.getStatus()==200){
                    sharedHelper.PutData("String","mobile",Content.phone);
                    sharedHelper.PutData("String","password",setPassword);
                    sharedHelper.PutData("String","user_key",login.getData().getToken());
                    sharedHelper.PutData("String","Userid",login.getData().getUserid());
                    Intent intent=new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(),"欢迎您！", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getActivity(),"注册失败,"+login.getMessage(), Toast.LENGTH_SHORT).show();
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
