package spfworld.spfworld.fragment.find.store;

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
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import spfworld.spfworld.MainActivity;
import spfworld.spfworld.R;
import spfworld.spfworld.activity.LoginActivity;
import spfworld.spfworld.activity.StoreActivity;
import spfworld.spfworld.activity.StoreDetailActivity;
import spfworld.spfworld.carousel.entity.BannerEntity;
import spfworld.spfworld.carousel.view.Banner;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.entity.StoreDetail;
import spfworld.spfworld.utils.SharedHelper;
import spfworld.spfworld.utils.XutilsClass;
import spfworld.spfworld.utils.dialog.MyAlertDialog;

/**
 * Created by guozhengke on 2016/9/26.
 * 商城详情页
 */
public class StoreDetailFragment extends Fragment {
    @ViewInject(R.id.store_detail_collction)
    private LinearLayout store_detail_collction;
    @ViewInject(R.id.collction_img)
    private ImageView collction_img;
    @ViewInject(R.id.collction_text)
    private TextView collction_text;
    @ViewInject(R.id.store_detail_link)
    private TextView store_detail_link;
    @ViewInject(R.id.store_detail_name)
    private TextView store_detail_name;
    @ViewInject(R.id.store_detail_mony)
    private TextView store_detail_mony;
    @ViewInject(R.id.detail_webview)
    private WebView detail_webview;
    @ViewInject(R.id.store_detail_back)
    private ImageView store_detail_back;
    @ViewInject(R.id.main_banner)
    private Banner mBanner;
    private Handler handler;
    private List<StoreDetail.DataBean> data;
    private List<BannerEntity> mList;
    private int FLAG=0;
    private int AUTO=0;
    private SharedHelper sharedHelper;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.store_detail,container,false);
        x.view().inject(this,view);
        sharedHelper=new SharedHelper(getActivity());
        final String user_key=sharedHelper.ReadData("String","user_key").toString();
        final String Userid=sharedHelper.ReadData("String","Userid").toString();
        if (user_key=="user_key"||user_key==null){
            AUTO=0;
        }else {
            AUTO=1;
        }
        GetStoreDetail(Userid);
        //返回键
        store_detail_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        //链接页
        store_detail_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Content.link_web=data.get(0).getUrl();
                StoreDetailActivity storeDetailActivity= (StoreDetailActivity) getActivity();
                handler=storeDetailActivity.handler;
                Message message=new Message();
                message.what=1;
                handler.sendMessage(message);
            }
        });
        //收藏
        store_detail_collction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (AUTO) {
                    case 0:
                        final MyAlertDialog myAlertDialog = new MyAlertDialog(getActivity());
                        myAlertDialog.setTitle("提示");
                        myAlertDialog.setMessage("是否登录或注册?");
                        myAlertDialog.SetCancelButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sharedHelper.cleardata();
                                Intent intent = new Intent(getActivity(), LoginActivity.class);
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
                        break;
                    case 1:
                        switch (FLAG){
                            case 0:
                                collction_img.setImageResource(R.mipmap.collect);
                                collction_text.setText("已收藏");
                                GetStoreCollction(Userid);
                                FLAG=1;
                                break;
                            case 1:
                                collction_img.setImageResource(R.mipmap.pond_collect);
                                collction_text.setText("未收藏");
                                GetStoreCollctionDel(Userid);
                                FLAG=0;
                                break;
                        }
                        break;
                }
            }
        });
        return view;
    }
    //商品收藏
    public void GetStoreCollction(String userid){
        XutilsClass.getInstance().postStoreCollection(userid, Content.storelist_id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("商品收藏",s);
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
    //商品取消收藏
    public void GetStoreCollctionDel(String userid){
        XutilsClass.getInstance().postStoreCollectionDel(userid, Content.storelist_id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("商品取消收藏",s);
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
    //商品详情页网络请求
    public void GetStoreDetail(String Userid){
        XutilsClass.getInstance().getStoreDetail(Userid,Content.storelist_id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("GetStoreDetail",s);
                Gson gson=new Gson();
                StoreDetail storeDetail=gson.fromJson(s,StoreDetail.class);
                data=storeDetail.getData();
                getData();
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
    //webview数据正则表达式
    private String replaceImgStyle(String html){
        String reg = "style=\"([^\"]+)\"";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(html);
        return matcher.replaceAll("");
    }
    //设置数据
    private void getData() {
        store_detail_name.setText(data.get(0).getName());
        store_detail_mony.setText("￥"+data.get(0).getPrice());
        String imgStyle = "<style> img{ max-width:100%; height:auto;} </style>";
        String content=data.get(0).getContent();
        content = replaceImgStyle(content);
        content=imgStyle+content;
        content=content.replace("/Uploads/","http://m.yundiaoke.cn/Uploads/");
//        detail_webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        detail_webview.getSettings().setLoadWithOverviewMode(true);
        detail_webview.loadData(content,"text/html; charset=UTF-8",null);


        //收藏
        switch (AUTO) {
            case 0:
                collction_img.setImageResource(R.mipmap.pond_collect);
                collction_text.setText("未收藏");
                break;
            case 1:
                if (data.get(0).getCollection() != null) {
                    switch (data.get(0).getCollection()) {
                        case "0":
                            collction_img.setImageResource(R.mipmap.pond_collect);
                            collction_text.setText("未收藏");
                            FLAG = 0;
                            break;
                        case "1":
                            collction_img.setImageResource(R.mipmap.collect);
                            collction_text.setText("已收藏");
                            FLAG = 1;
                            break;
                    }
                } else if (data.get(0).getCollection() == null) {
                    collction_img.setImageResource(R.mipmap.pond_collect);
                    collction_text.setText("未收藏");
                    FLAG = 0;
                }
                break;
        }
        //轮播
        mList= new ArrayList<>();
        for (int i=0;i<data.get(0).getImages_url().size();i++){
            mList.add(new BannerEntity(i,"http://"+data.get(0).getImages_url().get(i),null,null));
        }
        mBanner.setList(mList);
//        mBanner.setPauseDuration(500);
//        mBanner.setChangeDuration(1000);
    }

}
