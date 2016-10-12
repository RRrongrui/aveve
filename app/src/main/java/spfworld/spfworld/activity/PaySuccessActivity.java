package spfworld.spfworld.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import spfworld.spfworld.MainActivity;
import spfworld.spfworld.R;

/**
 * Created by guozhengke on 2016/9/26.
 * 支付成功页
 *
 */
public class PaySuccessActivity extends AppCompatActivity {
    @ViewInject(R.id.success_indentDetail)
    private TextView success_indentDetail;
    @ViewInject(R.id.back_main)
    private TextView back_main;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_success);
        x.view().inject(this);
        //返回主页
        back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PaySuccessActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //查看订单
        success_indentDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PaySuccessActivity.this, IndentDetailActivity.class);
                startActivity(intent);
            }
        });
    }
}
