package spfworld.spfworld.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.entity.IndentDetail;
import spfworld.spfworld.pay.PayDemoActivity;
import spfworld.spfworld.utils.ImageLoad;
import spfworld.spfworld.utils.XutilsClass;

/**
 * Created by guozhengke on 2016/9/26.
 * 订单详情页
 * post请求
 */
public class IndentDetailActivity extends AppCompatActivity {
    @ViewInject(R.id.indent_detail_no)
    private TextView indent_detail_no;
    @ViewInject(R.id.indent_detail_state)
    private TextView indent_detail_state;
    @ViewInject(R.id.indent_detail_name)
    private TextView indent_detail_name;
    @ViewInject(R.id.indent_detail_evenTtime)
    private TextView indent_detail_evenTtime;
    @ViewInject(R.id.indent_detail_address)
    private TextView indent_detail_address;
    @ViewInject(R.id.indent_detail_phone)
    private TextView indent_detail_phone;
    @ViewInject(R.id.event_indentTime)
    private TextView event_indentTime;
    @ViewInject(R.id.indent_detail_dCost)
    private TextView indent_detail_dCost;
    @ViewInject(R.id.indent_detail_number)
    private  TextView indent_detail_number;
    @ViewInject(R.id.indent_detail_zCost)
    private TextView indent_detail_zCost;
    @ViewInject(R.id.indent_detail_img)
    private ImageView indent_detail_img;
    @ViewInject(R.id.pay_success)
    private LinearLayout pay_success;
    @ViewInject(R.id.indent_detail_false)
    private  TextView indent_detail_false;
    @ViewInject(R.id.indent_detail_true)
    private  TextView indent_detail_true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_indent_dtail);
        x.view().inject(this);
        GetIndentDtail();
    }
    //页面网络请求
    public void GetIndentDtail(){
        XutilsClass.getInstance().postIndetDetail(Content.DATAINDENT, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("GetIndentDtail",s);
                Gson gson=new Gson();
                IndentDetail indentDetail=gson.fromJson(s,IndentDetail.class);
                final List<IndentDetail.DataBean> data=indentDetail.getData();
                //判断返回参数
                if (indentDetail.getStatus()==200){
                    //设置数据
                    ImageLoad imageLoad=new ImageLoad();
                    imageLoad.HttpImage("http://"+data.get(0).getContent(),indent_detail_img);
                    indent_detail_no.setText("订单编号:"+data.get(0).getOrder_num());
                    indent_detail_name.setText(data.get(0).getAct_theme());
                    indent_detail_evenTtime.setText("时间:"+data.get(0).getJoindate()+data.get(0).getJointime());
                    indent_detail_address.setText("地址:"+data.get(0).getAct_address());
                    indent_detail_phone.setText(data.get(0).getAppmobile());
                    event_indentTime.setText(data.get(0).getCreate_time());
                    indent_detail_dCost.setText("￥"+data.get(0).getPrice());
                    indent_detail_number.setText(data.get(0).getNum()+"份");
                    indent_detail_zCost.setText("￥"+data.get(0).getTotal_price());
                    switch (data.get(0).getStatus()){
                        case "0":
                            indent_detail_state.setText("待付款");
                            pay_success.setVisibility(View.VISIBLE);
                            //取消订单
                            indent_detail_false.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    GetIndentDel(data.get(0).getOrder_num());
                                }
                            });
                            //前往支付
                            indent_detail_true.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Content.DATAINDENT=data.get(0).getOrder_num();
                                    Content.event_name=data.get(0).getAct_theme();
                                    Content.Zmony=data.get(0).getTotal_price();
                                    Intent intent=new Intent(IndentDetailActivity.this, PayDemoActivity.class);
                                    startActivity(intent);
                                }
                            });
                            break;
                        case "1":
                            indent_detail_state.setText("付款成功");
                            pay_success.setVisibility(View.INVISIBLE);
                            break;
                    }
                }
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.e("GetIndentDtail___",throwable.toString());
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    //取消订单网络请求
    public  void GetIndentDel(String order_num){
        XutilsClass.getInstance().postIndentDel(order_num, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("跳转，取消订单成功",s);
                //Intent intent=new Intent();
                //startActivity(intent);
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.e("取消订单失败",throwable.toString());
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
