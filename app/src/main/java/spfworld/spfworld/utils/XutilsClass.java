package spfworld.spfworld.utils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by guozhengke on 2016/8/30.
 * 使用Xutils框架网络操作类
 */
public class XutilsClass {
    private String httpUrl="http://m.yundiaoke.cn/api/";

    private XutilsClass() {
    }
    private static XutilsClass instance = null;
    public static XutilsClass getInstance() {
        if (instance == null) {
            instance = new XutilsClass();
        }
        return instance;
    }
    //天气数据
    //http://op.juhe.cn/onebox/weather/query?cityname=上海市&key=445362869081d177d5c945f228dfd534
    public void getcityweather(String cityname, String key,Callback.CommonCallback<String> callback) {
        RequestParams params = new RequestParams("http://op.juhe.cn/onebox/weather/query?");
        params.addParameter("cityname", cityname);
        params.addParameter("key",key);
        x.http().get(params, callback);
    }
    //验证码
    //http://m.yundiaoke.cn/api/login/getCode
    public void getVerification(String mobile,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"login/getCode/");
        params.addParameter("mobile", mobile);
        x.http().post(params,callback);
    }
    //发现轮播图
    //http://m.yundiaoke.cn/api/pond/carousel
    public void getCarousel(Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"pond/carousel/");
        x.http().post(params,callback);
    }

    //塘口列表
    //http://m.yundiaoke.cn/api/pond/index/page/1/lng/121.232026/lat/31.111998
    public void getPond(int page,String lng,String lat,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"pond/index/");
        params.addParameter("page",page);
        params.addParameter("lng",lng);
        params.addParameter("lat",lat);
        x.http().get(params,callback);
    }
    //塘口详情
    //http://m.yundiaoke.cn/api/pond/detail/pon_id/1
    public void getPondDtail(String userid,String pon_id,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"pond/detail/");
        params.addParameter("pon_id",pon_id);
        params.addParameter("userid",userid);
        x.http().get(params,callback);
    }
    //塘口简介
    //http://m.yundiaoke.cn/api/pond/content/pon_id/2
    public void getPondIntro(String pon_id,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"pond/content/");
        params.addParameter("pon_id",pon_id);
        x.http().get(params,callback);
    }
    //注册
    //http://m.yundiaoke.cn/api/
    //mobile,code,password,手机号码，验证码，密码
    public void getPassWord(String username,String mobile,String code,String password,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"login/registerApp/");
        params.addParameter("mobile",mobile);
        params.addParameter("code",code);
        params.addParameter("password",password);
        params.addParameter("username",username);
        x.http().post(params,callback);
    }
    //登录
    //http://m.yundiaoke.cn/api/
    public void getLogin(String mobile,String password,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"login/login/");
        params.addParameter("mobile",mobile);
        params.addParameter("password",password);
        x.http().post(params,callback);
    }
    //活动
    //http://m.yundiaoke.cn/api/activity/index/method/1/page/1
    public void getEvent(String method,int page,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"activity/index/");
        params.addParameter("method",method);
        params.addParameter("page",page);
        x.http().get(params,callback);
    }
    //活动详情
    //http://m.yundiaoke.cn/api/activity/detail/act_id/3
    public void getEventDtail(String userid,String act_id,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"activity/detail/");
        params.addParameter("act_id",act_id);
        params.addParameter("userid",userid);
        x.http().get(params,callback);
    }
    //活动提交订单后台
    //http://m.yundiaoke.cn/api/activity/dobuy
    //提交参数:total_price订单总价格 price订单单价 num订单总数量 jointime活动的时间段 appmobile收货的手机号码
    //act_address详细地址 userid当前用户id actid当前活动id joindate选择活动时间  年月日格式
    public void getEventIndent(String userid,String actid,String total_price,String price,String num,String jointime,String appmobile, String act_address,String joindate,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"activity/dobuy/");
        params.addParameter("userid",userid);
        params.addParameter("actid",actid);
        params.addParameter("total_price",total_price);
        params.addParameter("price",price);
        params.addParameter("num",num);
        params.addParameter("jointime",jointime);
        params.addParameter("appmobile",appmobile);
        params.addParameter("act_address",act_address);
        params.addParameter("joindate",joindate);
        x.http().post(params,callback);
    }
    //订单详情
    //http://m.yundiaoke.cn/api/activity/orderDetail
    //参数：order_num订单号
    public void postIndetDetail(String order_num,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"activity/orderDetail/");
        params.addParameter("order_num",order_num);
        x.http().post(params,callback);
    }
    //取消订单
    //http://m.yundiaoke.cn/api/activity/delOrder/order_num/
    public void postIndentDel(String order_num,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"activity/delOrder/");
        params.addParameter("order_num",order_num);
        x.http().post(params,callback);
    }
    //商城轮播
    //http://m.yundiaoke.cn/api/goods/shopBanr
    public void getStoreCarousel(Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"goods/shopBanr/");
        x.http().get(params,callback);
    }
    //商品推荐
    //http://m.yundiaoke.cn/api/goods/isTop/method/2
    public void getStoreRecommend(int method,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"goods/isTop/");
        params.addParameter("method",method);
        x.http().get(params,callback);
    }

    //商品列表
    //http://m.yundiaoke.cn/api/goods/index
    //参数page分页
    public void getStoreList(int page,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"goods/index/");
        params.addParameter("page",page);
        x.http().get(params,callback);
    }

    //商品详情
    //http://m.yundiaoke.cn/api/goods/detail/goods_id/8
    public void getStoreDetail(String userid,String goods_id,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"goods/detail/");
        params.addParameter("userid",userid);
        params.addParameter("goods_id",goods_id);
        x.http().get(params,callback);
    }
    //商品搜索
    //http://m.yundiaoke.cn/api/goods/searchGoods
    public void getStoreSerchList(int page,String keyword,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"goods/searchGoods/");
        params.addParameter("page",page);
        params.addParameter("keyword",keyword);
        x.http().get(params,callback);
    }
    //活动收藏
    //http://m.yundiaoke.cn/api/activity/collection/userid/8/pid/1
    public void postEventCollection(String userid,String pid,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"activity/collection/");
        params.addParameter("userid",userid);
        params.addParameter("pid",pid);
        x.http().post(params,callback);
    }
    //活动取消收藏
    //http://m.yundiaoke.cn/api/activity/collectionDel
    public void postEventCollectionDel(String userid,String pid,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"activity/collectionDel/");
        params.addParameter("userid",userid);
        params.addParameter("pid",pid);
        x.http().post(params,callback);
    }
    //塘口收藏
    //http://m.yundiaoke.cn/api/pond/collection
        public void postPondCollection(String userid,String pid,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"pond/collection/");
        params.addParameter("userid",userid);
        params.addParameter("pid",pid);
        x.http().post(params,callback);
    }
    //塘口取消收藏
    //http://m.yundiaoke.cn/api/pond/collectionDel
    public void postPondCollectionDel(String userid,String pid,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"pond/collectionDel/");
        params.addParameter("userid",userid);
        params.addParameter("pid",pid);
        x.http().post(params,callback);
    }
    //商城收藏
    //http://m.yundiaoke.cn/api/goods/collection
    public void postStoreCollection(String userid,String pid,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"goods/collection/");
        params.addParameter("userid",userid);
        params.addParameter("pid",pid);
        x.http().post(params,callback);
    }
    //商城记录足迹
    //http://m.yundiaoke.cn/api/goods/footprint
    public void postFootPrint(String userid,String pid,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"goods/footprint/");
        params.addParameter("userid",userid);
        params.addParameter("pid",pid);
        x.http().post(params,callback);
    }
    //商城足迹
    //http://m.yundiaoke.cn/api/goods/footList/userid/8/page/1
    public void getStoreFootPrint(String userid,int page,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"goods/footList/");
        params.addParameter("userid",userid);
        params.addParameter("page",page);
        x.http().get(params,callback);
    }
    //商城取消收藏
    //http://m.yundiaoke.cn/api/goods/collectionDel
    public void postStoreCollectionDel(String userid,String pid,Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(httpUrl+"goods/collectionDel/");
        params.addParameter("userid",userid);
        params.addParameter("pid",pid);
        x.http().post(params,callback);
    }
    //发布评论
    //地址：http://m.yundiaoke.cn/api/comments/message
    public void getReleaseTribune(String uid, String title, String comment,
                                  String c_prov, String c_city, String c_area,
                                  String c_address, List urls,
                                  Callback.CommonCallback<String> callback) {
        RequestParams params = new RequestParams(httpUrl + "comments/Messageanz");
        params.addParameter("uid", uid);// uid:用户id
        params.addParameter("title", title);//title:帖子标题
        params.addParameter("comment", comment);//comment：帖子内容
        params.addParameter("c_prov", c_prov);//c_prov:省
        params.addParameter("c_city", c_city);//c_city：城市
        params.addParameter("c_area", c_area);//c_area:区
        params.addParameter("c_address", c_address);//c_address:详细地址
        params.addParameter("urls", urls);//url：图片
        x.http().post(params, callback);
    }

    //帖子列表
    //地址：http://m.yundiaoke.cn/api/comments/MessageList/page/1/keyword/2
    public void getTribune(String page, String keyword, Callback.CommonCallback<String> callback){
        RequestParams params = new RequestParams(httpUrl + "comments/MessageList/");
        params.addParameter("keyword",keyword);
        params.addParameter("page",page);
        x.http().post(params,callback);
    }

    //帖子详情
    // 地址：http://m.yundiaoke.cn/api/comments/MessageList/page/1/keyword/2
    public void getTribuneData(String c_id, Callback.CommonCallback<String> callback){
        RequestParams params = new RequestParams(httpUrl + "comments/MessagDetail");
        params.addParameter("c_id",c_id);
        x.http().post(params,callback);
    }
    //    回复层主帖子 上传回复层主
//    地址：http://m.yundiaoke.cn/api/comments/replyPid
    public void getTribuneCommentFloor(String c_id,String r_id,String replys,  Callback.CommonCallback<String> callback){
        RequestParams params = new RequestParams(httpUrl + "comments/replyPid");
        params.addParameter("c_id",c_id);
        params.addParameter("r_id",r_id);
        params.addParameter("replys",replys);
        x.http().post(params,callback);
    }
    //回复楼主帖子
//    地址：http://m.yundiaoke.cn/api/comments/replyMessage
    public void getTribuneDataTitle(String uid ,String c_id,String replys,String images, Callback.CommonCallback<String> callback){
        RequestParams params = new RequestParams(httpUrl + "comments/replyMessage");
        params.addParameter("uid",uid);
        params.addParameter("c_id",c_id);
        params.addParameter("replys",replys);
        params.addParameter("images",images);
        x.http().post(params,callback);
    }

    //回复层主帖子
//    地址：http://m.yundiaoke.cn/api/comments/replyPid
    public void getTbeComDataChildTitle(String uid,String c_id,String r_id,String replys,Callback.CommonCallback<String> callback){
        RequestParams params = new RequestParams(httpUrl + "comments/replyPid");
        params.addParameter("uid",uid);
        params.addParameter("c_id",c_id);
        params.addParameter("r_id",r_id);
        params.addParameter("replys",replys);
        x.http().post(params,callback);
    }


    //层主信息
    //http://m.yundiaoke.cn/api/comments/showReply/c_id/12 显示层主信息
    //http://m.yundiaoke.cn/api/comments/showReply/c_id/12/r_id/66/page/1 显示回复层主信息
    public void getTribnueCommentData(String c_id,  String page, Callback.CommonCallback<String> callback){
        RequestParams params = new RequestParams(httpUrl + "comments/showReply");
        params.addParameter("c_id",c_id);
//        params.addParameter("r_id",r_id);
        params.addParameter("page",page);
        x.http().get(params,callback);
    }

    //显示回复层主的帖子内容
    public void getTribnueCommentDataChild(String c_id,String r_id,Callback.CommonCallback<String> callback){
        RequestParams params = new RequestParams(httpUrl + "comments/layerMan");
        params.addParameter("c_id",c_id);
        params.addParameter("r_id",r_id);
//        params.addParameter("page",page);
        x.http().get(params,callback);
    }

    //查看个人资料：
    //http://m.yundiaoke.cn/api/user/userInfo/userid/8
    public void getUserData(String userid, Callback.CommonCallback<String> callback){
        RequestParams params = new RequestParams(httpUrl + "user/userInfo/");
        params.addParameter("userid",userid);
        x.http().get(params,callback);
    }
    //上传个人资料
//    http://m.yundiaoke.cn/api/user/updateInfo    请求方式：post
    public void getUpUserData(String userid, String pic, String nickname, String prov,
                              String city, String area, String signature, int sex,
                              String birthday, Callback.CommonCallback<String> callback){
        RequestParams params = new RequestParams(httpUrl + "user/updateInfo");
        params.addParameter("userid",userid);
        params.addParameter("pic",pic);
        params.addParameter("nickname",nickname);
        params.addParameter("prov",prov);
        params.addParameter("city",city);
        params.addParameter("area",area);
        params.addParameter("signature",signature);
        params.addParameter("sex",sex);
        params.addParameter("birthday",birthday);
        x.http().post(params,callback);
    }

    //我的订单
//    地址：http://m.yundiaoke.cn/api/user/myOrder
    public void getUserOrder(String userid, int page, Callback.CommonCallback<String> callback){
        RequestParams params = new RequestParams(httpUrl + "user/myOrder");
        params.addParameter("userid",userid);
        params.addParameter("page",page);
        x.http().post(params,callback);
    }
    //我的收藏 ====》塘口收藏
//    地址： http://m.yundiaoke.cn/api/user/myCollection
    public void getMyColtFondFragment(String method, String userid,String page , Callback.CommonCallback<String> callback){
        RequestParams params = new RequestParams(httpUrl + "user/myCollection");
        params.addParameter("method",method);
        params.addParameter("userid",userid);
        params.addParameter("page",page);
        x.http().post(params,callback);
    }
    //我发布过的帖子列表
    public void getUserMyTribuneFragment(String userid,int page , Callback.CommonCallback<String> callback){
        RequestParams params = new RequestParams(httpUrl + "user/published");
        params.addParameter("userid",userid);
        params.addParameter("page",page);
        x.http().post(params,callback);
    }
}
