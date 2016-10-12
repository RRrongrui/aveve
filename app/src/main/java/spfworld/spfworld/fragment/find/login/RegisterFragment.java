package spfworld.spfworld.fragment.find.login;

import android.os.Bundle;
import android.os.CountDownTimer;
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

import spfworld.spfworld.R;
import spfworld.spfworld.activity.LoginActivity;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.entity.Verification;
import spfworld.spfworld.utils.XutilsClass;

/**
 * Created by guozhengke on 2016/9/8.
 * 注册页面fragment
 */
public class RegisterFragment extends Fragment {
    @ViewInject(R.id.register_loginBack)
    private ImageView img_loginBack;
    @ViewInject(R.id.register_phone)
    private EditText et_phone;
    @ViewInject(R.id.register_verification_et)
    private EditText et_verification;
    @ViewInject(R.id.register_verification_btn)
    private TextView btn_verification;
    @ViewInject(R.id.register_butn)
    private TextView register_butn;

    private Handler handler;
    private Verification verification;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.login_register_fragment,container,false);
        x.view().inject(this,view);
        //返回按钮监听
        img_loginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity loginActivity= (LoginActivity) getActivity();
                handler=loginActivity.handler;
                Message message=new Message();
                message.what=0;
                handler.sendMessage(message);
            }
        });
        //点击验证成功跳转
        register_butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String EtPhone=et_phone.getText().toString();
                String EtVerification=et_verification.getText().toString();
                if (EtPhone!=null&&!EtPhone.equals("")&&EtVerification!=null&&!EtVerification.equals("")) {
                    if (EtVerification.equals(verification.getData())) {
                        Content.verification = verification.getData();
                        LoginActivity loginActivity = (LoginActivity) getActivity();
                        handler = loginActivity.handler;
                        Message message = new Message();
                        message.what = 2;
                        handler.sendMessage(message);
                    } else {
                        Toast.makeText(getActivity(), "验证码错误,请重新输入", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getActivity(), "手机号码或验证码不正确", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //验证码
        btn_verification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetVerification();
            }
        });

        return view;
    }
    //验证码设置
    private CountDownTimer timer=new CountDownTimer(60000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            btn_verification.setText(millisUntilFinished/1000+"s");
        }

        @Override
        public void onFinish() {
            btn_verification.setEnabled(true);
            btn_verification.setText("获取验证码");
        }
    };
    //注册获取验证码网络请求数据
    public void GetVerification(){
        String EtPhone=et_phone.getText().toString();
        if (EtPhone!=null&&!EtPhone.equals("")) {
            timer.start();
            Content.phone = EtPhone;
            XutilsClass.getInstance().getVerification(EtPhone, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String s) {
                    Gson gson = new Gson();
                    verification = gson.fromJson(s, Verification.class);
                    Log.e("RegisterFragment++++++", s);


                }

                @Override
                public void onError(Throwable throwable, boolean b) {
                    Log.e("onError++++", throwable.toString());
                }

                @Override
                public void onCancelled(CancelledException e) {

                }

                @Override
                public void onFinished() {

                }
            });
        }else {
            Toast.makeText(getActivity(), "手机号码不能为空", Toast.LENGTH_SHORT).show();
        }
    }
}
