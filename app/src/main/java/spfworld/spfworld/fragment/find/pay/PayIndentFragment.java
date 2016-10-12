package spfworld.spfworld.fragment.find.pay;

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

import spfworld.spfworld.R;
import spfworld.spfworld.activity.PayActivity;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.entity.EventIndent;
import spfworld.spfworld.pay.PayDemoActivity;
import spfworld.spfworld.utils.XutilsClass;

/**
 * Created by guozhengke on 2016/9/18.
 * 确认订单
 */
public class PayIndentFragment extends Fragment {
    @ViewInject(R.id.indent_back)
    private ImageView indent_back;
    @ViewInject(R.id.indent_apply)
    private TextView indent_apply;
    @ViewInject(R.id.event_indent_name)
    private TextView event_indent_name;
    @ViewInject(R.id.event_indent_time)
    private TextView event_indent_time;
    @ViewInject(R.id.event_indent_address)
    private TextView event_indent_address;
    @ViewInject(R.id.event_indent_dCost)
    private TextView event_indent_dCost;
    @ViewInject(R.id.event_indent_zCost)
    private TextView event_indent_zCost;
    @ViewInject(R.id.event_indent_number)
    private TextView event_indent_number;
    @ViewInject(R.id.event_indent_phone)
    private EditText event_indent_phone;

    private Handler handler;

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden==false){
            getData();//设置数据
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.event_indent,container,false);
        x.view().inject(this,view);
        //返回键
        indent_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PayActivity payActivity= (PayActivity) getActivity();
                handler=payActivity.handler;
                Message message=new Message();
                message.what=0;
                handler.sendMessage(message);
            }
        });
        //提交订单 跳转
        indent_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String event_phone=event_indent_phone.getText().toString();
                if (event_phone!=null&&!event_phone.equals("")){
                    if (event_phone.length()==11){
                        GetIndent(event_phone);
//                        Intent intent=new Intent(getActivity(), PayDemoActivity.class);
//                        startActivity(intent);
                    }else {
                        Toast.makeText(getActivity(),"手机号码填写错误", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getActivity(),"手机号码不能为空", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }

    private void getData() {
        Log.e("商品总价格",Content.Zmony);
        Log.e("商品数量",Content.NUMBER);
        event_indent_name.setText(Content.event_name);
        event_indent_time.setText("时间:"+Content.RCTime+"  "+Content.GRTime);
        event_indent_address.setText("地址:"+Content.event_address);
        event_indent_dCost.setText("￥"+Content.mony);
        event_indent_zCost.setText("￥"+Content.Zmony);
        event_indent_number.setText(Content.NUMBER);
    }
    //提交后台网络请求
    public void GetIndent(final String event_phone){
        XutilsClass.getInstance().getEventIndent("8", Content.act_id,Content.Zmony, Content.mony, Content.NUMBER,Content.GRTime, event_phone, Content.event_address,Content.RCTime, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String s) {
                        Log.e("提交后台网络请求",s);
                        Gson gson=new Gson();
                        EventIndent eventIndent=gson.fromJson(s,EventIndent.class);
                        if (eventIndent.getStatus()==200){
                            Content.DATAINDENT=eventIndent.getData();
                            Intent intent=new Intent(getActivity(),PayDemoActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(getActivity(),eventIndent.getMessage(), Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onError(Throwable throwable, boolean b) {
                        Log.e("提交后台网络请求返回错误",throwable.toString());
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
