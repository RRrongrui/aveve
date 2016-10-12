package spfworld.spfworld.fragment.find.pay;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import spfworld.spfworld.R;
import spfworld.spfworld.activity.IndentDetailActivity;
import spfworld.spfworld.activity.PayActivity;
import spfworld.spfworld.activity.PayDefeatActivity;
import spfworld.spfworld.activity.PaySuccessActivity;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.pay.H5PayDemoActivity;
import spfworld.spfworld.pay.PayDemoActivity;
import spfworld.spfworld.pay.PayResult;
import spfworld.spfworld.pay.SignUtils;
import spfworld.spfworld.utils.dialog.MyAlertDialog;

/**
 * Created by guozhengke on 2016/9/18.
 * 支付宝支付页
 */
public class OnlinePaymentFragment extends Fragment {
    @ViewInject(R.id.online_payment_back)
    private ImageView online_payment_back;
    @ViewInject(R.id.online_payment_btn_zhifu)
    private ImageView online_payment_btn_zhifu;
//    @ViewInject(R.id.online_payment_btn_weixin)
//    private ImageView online_payment_btn_weixin;
    @ViewInject(R.id.online_payment_apply)
    private TextView online_payment_apply;
    @ViewInject(R.id.online_payment_countDown)
    private TextView online_payment_countDown;
    @ViewInject(R.id.online_payment_name)
    private TextView online_payment_name;
    @ViewInject(R.id.online_payment_zCost)
    private TextView online_payment_zCost;

    private Handler handler=new Handler();
    private int MINUTE=14;
    private int SECOND=59;

    // 商户PID
    //
    public static final String PARTNER = "2088221973007254";
    // 商户收款账号
    //yundiaoke@hotmail.com
    public static final String SELLER = "yundiaoke@hotmail.com";
    // 商户私钥，pkcs8格式
    public static final String RSA_PRIVATE = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK8YZb5piqfWtzB4" +
            "Kvd3/WOo+79pxAZI5vCcekdIoljVHDBr6EptHD3lH+NeCvjssrDCW5cYV48GtEOM" +
            "lYKTCSbG1/s5tLuQRoW+HRsxWEYnnP+yMMqFko/xeRWnulDyc+WtLp2u69sSSP8l" +
            "ADHdhBYEFYRI+P+Dv7cCCt2aZ6DHAgMBAAECgYBdlkfDh7vxy8UsZf5pOTw5iXfN" +
            "rqV0yoCNeMWu1jbYDkg75WFKbplax93MdFafCDzWV3wG/Z7HNskhFcJQAXEw4ub7" +
            "Rqx8ppL8MwDw9L0t3aNXpNfT0H/Vm2SdUgGnns6k7rxCQMMsqGdDhMAKjKnE2bg3" +
            "xDYMlPFJBdTR0rwsEQJBAOH0+2ff1+PnZOm90VJjT/wCOHcAuJvSZFSe/cCooYQK" +
            "x37189PJZKr1M2R4jenfvdO7weqxcK1wK7fzBO4v6l8CQQDGYDW8KDkEtXZHCY5W" +
            "NiskR711cDAFRqm27RMvLBmWV0IrulOCVEW4Io+ZEZEErNU4yKh42oVK6/v9IZ64" +
            "wjKZAkEAsfpKUE5jebMYrHgEOZXaOZDyMuIRh0MYHgNBso/g8OWgr6NBVC9MqNAM" +
            "k/XVKkM+/Vjl7FupeiNhfDniR07clwJBAIgLmS5140ygagIjwpLLSWDzNjJhAv3L" +
            "TT7fbYWvV8jsBLxaZ0T9KGc0hIh0LKEpKn1r12YybrFID6O0t9Z7kBkCQFQOJslN" +
            "R93dWsaHIAXB0fmViJ9pegsuDSX52oY+ZaQa4Ww2kgieMSN9Us+YhfHy7jN78t7N" +
            "/WC+5PWXAMJ9Az0=";
    // 支付宝公钥
    public static final String RSA_PUBLIC = "";
    private static final int SDK_PAY_FLAG = 1;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);
                    /**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息

                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(getActivity(), "支付成功", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getActivity(), PaySuccessActivity.class);
                        startActivity(intent);
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(getActivity(), "支付结果确认中", Toast.LENGTH_SHORT).show();

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(getActivity(), "支付失败", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getActivity(), PayDefeatActivity.class);
                            startActivity(intent);
                        }
                    }
                    break;
                }
                default:
                    break;
            }
        };
    };

    /**
     * call alipay sdk pay. 调用SDK支付
     *
     */
    public void pay()  {

        if (TextUtils.isEmpty(PARTNER) || TextUtils.isEmpty(RSA_PRIVATE) || TextUtils.isEmpty(SELLER)) {
            new AlertDialog.Builder(getActivity()).setTitle("警告").setMessage("需要配置PARTNER | RSA_PRIVATE| SELLER")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialoginterface, int i) {
                            //
                            getActivity().finish();
                        }
                    }).show();
            return;
        }
        String orderInfo = null;
        switch (Content.flag){
            case 1:
                //Content.Zmony
                orderInfo= getOrderInfo(Content.event_name, "FromAliPay","0.01" );
                break;
            case 2:
                orderInfo= getOrderInfo(Content.event_name, "FromWXPay","0.01");
                break;
        }


        /**
         * 特别注意，这里的签名逻辑需要放在服务端，切勿将私钥泄露在代码中！
         */
        String sign = sign(orderInfo);
        try {
            /**
             * 仅需对sign 做URL编码
             */
            sign = URLEncoder.encode(sign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /**
         * 完整的符合支付宝参数规范的订单信息
         */
        final String payInfo = orderInfo + "&sign=\"" + sign + "\"&" + getSignType();
        Log.e("+++++++",payInfo.toString());

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(getActivity());
                // 调用支付接口，获取支付结果
                String result = alipay.pay(payInfo, true);

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    /**
     * get the sdk version. 获取SDK版本号
     *
     */
    public void getSDKVersion() {
        PayTask payTask = new PayTask(getActivity());
        String version = payTask.getVersion();
        Toast.makeText(getActivity(), version, Toast.LENGTH_SHORT).show();
    }

    /**
     * 原生的H5（手机网页版支付切natvie支付） 【对应页面网页支付按钮】
     *
     * @param v
     */
//    public void h5Pay(View v) {
//        Intent intent = new Intent(getActivity(), H5PayDemoActivity.class);
//        Bundle extras = new Bundle();
//        /**
//         * url是测试的网站，在app内部打开页面是基于webview打开的，demo中的webview是H5PayDemoActivity，
//         * demo中拦截url进行支付的逻辑是在H5PayDemoActivity中shouldOverrideUrlLoading方法实现，
//         * 商户可以根据自己的需求来实现
//         */
//        String url = "http://m.taobao.com";
//        // url可以是一号店或者淘宝等第三方的购物wap站点，在该网站的支付过程中，支付宝sdk完成拦截支付
//        extras.putString("url", url);
//        intent.putExtras(extras);
//        startActivity(intent);
//    }

    /**
     * create the order info. 创建订单信息
     *
     */
    private String getOrderInfo(String subject, String body, String price) {

        // 签约合作者身份ID
        String orderInfo = "partner=" + "\"" + PARTNER + "\"";

        // 签约卖家支付宝账号
        orderInfo += "&seller_id=" + "\"" + SELLER + "\"";

        // 商户网站唯一订单号
        orderInfo += "&out_trade_no=" + "\"" + getOutTradeNo() + "\"";

        // 商品名称
        orderInfo += "&subject=" + "\"" + subject + "\"";

        // 商品详情
        orderInfo += "&body=" + "\"" + body + "\"";

        // 商品金额
        orderInfo += "&total_fee=" + "\"" + price + "\"";

        // 服务器异步通知页面路径
        orderInfo += "&notify_url=" + "\"" + "http://m.yundiaoke.cn/api/pay/notifyurl" + "\"";

        // 服务接口名称， 固定值
        orderInfo += "&service=\"mobile.securitypay.pay\"";

        // 支付类型， 固定值
        orderInfo += "&payment_type=\"1\"";

        // 参数编码， 固定值
        orderInfo += "&_input_charset=\"utf-8\"";

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        orderInfo += "&it_b_pay=\"15m\"";

        // extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
        // orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
        orderInfo += "&return_url=\"m.alipay.com\"";

        return orderInfo;
    }

    /**
     * get the out_trade_no for an order. 生成商户订单号，该值在商户端应保持唯一（可自定义格式规范）
     *
     */
    private String getOutTradeNo() {
//        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
//        Date date = new Date();
//        String key = format.format(date);
//
//        Random r = new Random();
//        key = key + r.nextInt();
//        key = key.substring(0, 15);
       String key=Content.DATAINDENT;
        return key;
    }

    /**
     * sign the order info. 对订单信息进行签名
     *
     * @param content
     *            待签名订单信息
     */
    private String sign(String content) {
        return SignUtils.sign(content, RSA_PRIVATE);
    }

    /**
     * get the sign type we use. 获取签名方式
     *
     */
    private String getSignType() {
        return "sign_type=\"RSA\"";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.event_online_payment,container,false);
        x.view().inject(this,view);
        handler.postDelayed(runnable,1000);
        getData();//设置数据
        //返回键
        online_payment_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MyAlertDialog myAlertDialog=new MyAlertDialog(getActivity());
                myAlertDialog.setTitle("提示");
                myAlertDialog.setMessage("放弃支付?");
                myAlertDialog.SetCancelButton("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getActivity(), IndentDetailActivity.class);
                        startActivity(intent);

                    }
                });
                myAlertDialog.SetDetermineButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myAlertDialog.Dismiss();
                    }
                });

                myAlertDialog.Show();
            }
        });
        //选择支付类型
        switch (Content.flag){
            case 0:
                online_payment_btn_zhifu.setImageResource(R.mipmap.event_merchandise_selection_fasle);
                //online_payment_btn_weixin.setImageResource(R.mipmap.event_merchandise_selection_fasle);
                break;
            case 1:
                online_payment_btn_zhifu.setImageResource(R.mipmap.event_merchandise_selection_true);
               // online_payment_btn_weixin.setImageResource(R.mipmap.event_merchandise_selection_fasle);
                break;
            case 2:
                //online_payment_btn_weixin.setImageResource(R.mipmap.event_merchandise_selection_true);
                online_payment_btn_zhifu.setImageResource(R.mipmap.event_merchandise_selection_fasle);
                break;
        }
        online_payment_btn_zhifu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("+++++:","点击事件发生");
                online_payment_btn_zhifu.setImageResource(R.mipmap.event_merchandise_selection_true);
                //online_payment_btn_weixin.setImageResource(R.mipmap.event_merchandise_selection_fasle);
                Content.flag=1;
            }
        });
        //online_payment_btn_weixin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("::::::","点击事件发生");
//                online_payment_btn_weixin.setImageResource(R.mipmap.event_merchandise_selection_true);
//                online_payment_btn_zhifu.setImageResource(R.mipmap.event_merchandise_selection_fasle);
//                Content.flag=2;
//            }
//        });
        //确认支付调用
        online_payment_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (Content.flag){
                    case 0:
                        Toast.makeText(getActivity(),"请选择支付类型", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Log.e("00000000","调用支付宝");
                        pay();
                        break;
                    case 2:
                        Log.e("1111111111","调用微信");
                        break;
                }
            }
        });
        return view;
    }
    //设置数据
    private void getData() {
        online_payment_name.setText(Content.event_name);
        online_payment_zCost.setText("￥"+Content.Zmony);
    }
    //定时器线程
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            if (MINUTE==0){
                if (SECOND==0){
                    online_payment_countDown.setText("00:00");
                }else if (SECOND<11){
                    SECOND--;
                    online_payment_countDown.setText(MINUTE+":0"+SECOND);
                }else {
                    SECOND--;
                    online_payment_countDown.setText(MINUTE+":"+SECOND);
                }
            }else if (MINUTE<10){
                if (SECOND==0){
                    MINUTE--;
                    SECOND=59;
                    online_payment_countDown.setText("0"+MINUTE+":"+SECOND);
                }else if (SECOND<11){
                    SECOND--;
                    online_payment_countDown.setText("0"+MINUTE+":0"+SECOND);
                }else {
                    SECOND--;
                    online_payment_countDown.setText("0"+MINUTE+":"+SECOND);
                }

            }else if (SECOND==0){
                SECOND=59;
                MINUTE--;
                online_payment_countDown.setText(MINUTE+":"+SECOND);
            }else if (SECOND<11){
                SECOND--;
                online_payment_countDown.setText(MINUTE+":0"+SECOND);
            }else {
                SECOND--;
                online_payment_countDown.setText(MINUTE+":"+SECOND);
            }
            //online_payment_countDown.setText(TIME+"");
            handler.postDelayed(this,1000);
        }
    };
}
