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
import spfworld.spfworld.entity.IndentDetail;

/**
 * Created by guozhengke on 2016/9/26.
 * 支付失败页
 */
public class PayDefeatActivity extends AppCompatActivity{
    @ViewInject(R.id.back_main)
    private TextView back_main;
    @ViewInject(R.id.defeat_indent_list)
    private TextView defeat_indent_list;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_defeat);
        x.view().inject(this);
        //返回主页
        back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PayDefeatActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //进入订单列表
        defeat_indent_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PayDefeatActivity.this, IndentDetailActivity.class);
                startActivity(intent);
            }
        });
    }
}
