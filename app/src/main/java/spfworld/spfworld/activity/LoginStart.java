package spfworld.spfworld.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import spfworld.spfworld.MainActivity;
import spfworld.spfworld.R;

/**
 * Created by guozhengke on 2016/9/13.
 * 设置app Login页，延时进入主页
 */
public class LoginStart extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(LoginStart.this,MainActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }
}
