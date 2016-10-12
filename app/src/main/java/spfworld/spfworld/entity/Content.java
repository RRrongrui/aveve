package spfworld.spfworld.entity;

import java.util.List;

/**
 * Created by guozhengke on 2016/9/1.
 * 静态实体类
 */
public class Content {
    public static String Userid=new String();//用户id
    public static String city=new String();//选择城市
    public static String mapcity=new String();//定位当前城市
    public static String lnt=new String();//定位当前纬度
    public static String lat=new String();//定位当前精度
    public static String pond_id=new String();//塘口列表条目id
    public static String phone=new String();//手机号码
    public static String verification=new String();//验证码
    public static String act_id=new String();//活动详情id
    public static int flag=0;//选择微信或支付宝
    public static String mony=new String();//活动商品价格
    public static String Zmony=new String();//活动总价格
    public static String NUMBER=new String();//活动数量
    public static String event_name=new String();//活动名称
    public static String event_address=new String();//活动名称
    public static List<String> listTime;//选择时间
    public static List<String> actTime;//选择时间段
    public static String RCTime=new String();//水平滑动选中值
    public static String GRTime=new String();//gridview选中值
    public static String DATAINDENT=new String();//订单号

    //商城
    public static String storelist_id=new String();//商城列表id
    public static String link_web=new String();//商品外链网站
    public static String recommed_one=new String();//好物推荐
    public static String recommed_two=new String();//一周推荐id
    public static String serech_keyword=new String();//搜索关键字

}
