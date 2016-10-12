package spfworld.spfworld.fragment.find.store;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ant.liao.GifView;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.activity.FootPrintActivity;
import spfworld.spfworld.activity.LoginActivity;
import spfworld.spfworld.activity.StoreActivity;
import spfworld.spfworld.activity.StoreDetailActivity;
import spfworld.spfworld.activity.StoreSerchListActivity;
import spfworld.spfworld.adapter.StoreListviewItemAdapter;
import spfworld.spfworld.carousel.entity.BannerEntity;
import spfworld.spfworld.carousel.interfaces.OnPagerClickListener;
import spfworld.spfworld.carousel.view.Banner;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.entity.StoreCarousel;
import spfworld.spfworld.entity.StoreList;
import spfworld.spfworld.entity.StoreRecommend;
import spfworld.spfworld.entity.StoreSerch;
import spfworld.spfworld.utils.ImageLoad;
import spfworld.spfworld.utils.SharedHelper;
import spfworld.spfworld.utils.XutilsClass;
import spfworld.spfworld.utils.dialog.MyAlertDialog;

/**
 * Created by guozhengke on 2016/8/30.
 * 商城主页
 */
public class StoreFragment extends Fragment {
    @ViewInject(R.id.gifView)
    private GifView gifView;
    @ViewInject(R.id.gif_view_ll)
    private LinearLayout gif_view_ll;
    private Handler handler;
    private java.util.List<StoreList.DataBean> data;
    private List<StoreCarousel.DataBean> Cdata;
    private StoreListviewItemAdapter  storeListviewItemAdapter;
    private LinearLayout store_footprint;
    private EditText ed_search;
    private PullToRefreshListView recommend_listview;
    private Banner banner;
    private ImageView store_one_img;
    private TextView store_one_name;
    private TextView store_one_text;
    private LinearLayout store_one_ll;
    private ImageView store_two_img;
    private TextView store_two_name;
    private TextView store_two_text;
    private LinearLayout store_two_ll;
    private LinearLayout store_th_ll;
    private List<BannerEntity> mList;
    private LinearLayout store_fragment_head;
    private ListView listview_head;
    private int page=1;
    private int AUTO=0;
    private SharedHelper sharedHelper;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_store,container,false);
        recommend_listview= (PullToRefreshListView) view.findViewById(R.id.store_listview);
        ed_search= (EditText) view.findViewById(R.id.store_search);
        store_fragment_head= (LinearLayout) inflater.inflate(R.layout.store_fragment_head,null);
        //@ViewInject(R.id.store_view)
        banner= (Banner) store_fragment_head.findViewById(R.id.store_view);
        //@ViewInject(R.id.store_one_ll)
        store_one_ll= (LinearLayout) store_fragment_head.findViewById(R.id.store_one_ll);
        //@ViewInject(R.id.store_two_ll)
        store_two_ll= (LinearLayout) store_fragment_head.findViewById(R.id.store_two_ll);
        //@ViewInject(R.id.store_th_ll)
        store_th_ll= (LinearLayout) store_fragment_head.findViewById(R.id.store_th_ll);
        //@ViewInject(R.id.store_one_img)
        store_one_img=(ImageView) store_fragment_head.findViewById(R.id.store_one_img);
        //@ViewInject(R.id.store_one_text)
        store_one_text=(TextView) store_fragment_head.findViewById(R.id.store_one_text  );
        //@ViewInject(R.id.store_one_name)
        store_one_name= (TextView) store_fragment_head.findViewById(R.id.store_one_name);
        //@ViewInject(R.id.store_two_name)
        store_two_name= (TextView) store_fragment_head.findViewById(R.id.store_two_name);
        //@ViewInject(R.id.store_two_text)
        store_two_text=(TextView) store_fragment_head.findViewById(R.id.store_two_text);
        //@ViewInject(R.id.store_two_img)
        store_two_img= (ImageView) store_fragment_head.findViewById(R.id.store_two_img);
        //@ViewInject(R.id.footprint_LL)
        store_footprint= (LinearLayout) store_fragment_head.findViewById(R.id.footprint_LL);

        x.view().inject(this,view);
        //判断登录状态
        sharedHelper=new SharedHelper(getActivity());
        final String user_key=sharedHelper.ReadData("String","user_key").toString();
        final String Userid=sharedHelper.ReadData("String","Userid").toString();
        if (user_key=="user_key"||user_key==null){
            AUTO=0;
        }else {
            AUTO=1;
        }
        gifView.setGifImage(R.drawable.loading);//加载动画
        listview_head=recommend_listview.getRefreshableView();
        recommend_listview.setMode(PullToRefreshBase.Mode.BOTH);
        //设置PullRefreshListView上提加载时的加载提示
        recommend_listview.getLoadingLayoutProxy(false, true).setPullLabel("上拉加载...");
        recommend_listview.getLoadingLayoutProxy(false, true).setRefreshingLabel("正在加载...");
        recommend_listview.getLoadingLayoutProxy(false, true).setReleaseLabel("松开加载更多...");
        // 设置PullRefreshListView下拉加载时的加载提示
        recommend_listview.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新...");
        recommend_listview.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新...");
        recommend_listview.getLoadingLayoutProxy(true, false).setReleaseLabel("松开刷新...");
        recommend_listview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(final PullToRefreshBase<ListView> refreshView) {
                storeListviewItemAdapter.notifyDataSetChanged();
                refreshView.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        refreshView.onRefreshComplete();
                    }
                }, 1000);
                Log.e("动作","上");
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                GetStoreList(page);
                Log.e("动作","下");
            }
        });
        //足迹
        store_footprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (AUTO){
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
                        Intent intent=new Intent(getActivity(), FootPrintActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
        //搜索
        final InputMethodManager imm= (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        ed_search.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Content.serech_keyword=ed_search.getText().toString();
                if(keyCode==KeyEvent.KEYCODE_ENTER){
                    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                    Intent intent=new Intent(getActivity(), StoreSerchListActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });
        //商品列表
        recommend_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Content.storelist_id=data.get(position-2).getId();
                Intent intent=new Intent(getActivity(), StoreDetailActivity.class);
                switch (AUTO){
                    case 0:
                        startActivity(intent);
                        break;
                    case 1:
                        RecordFootPrint(Userid,data.get(position-2).getId());
                        startActivity(intent);
                        break;

                }
            }
        });
        //好物推荐
        store_one_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Content.storelist_id = Content.recommed_one;
                Intent intent = new Intent(getActivity(), StoreDetailActivity.class);
                switch (AUTO) {
                    case 0:
                        startActivity(intent);
                        break;
                    case 1:
                        RecordFootPrint(Userid, Content.recommed_one);
                        startActivity(intent);
                        break;

                }
            }
        });
        //一周推荐
        store_two_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Content.storelist_id=Content.recommed_two;
                Intent intent = new Intent(getActivity(), StoreDetailActivity.class);
                switch (AUTO) {
                    case 0:
                        startActivity(intent);
                        break;
                    case 1:
                        RecordFootPrint(Userid,Content.recommed_two);
                        startActivity(intent);
                        break;

                }
            }
        });
        //限时抢购
        store_th_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"暂未开放,敬请期待!", Toast.LENGTH_SHORT).show();
            }
        });
        GetStoreCarousel();
        setRecommend();
        GetStoreList(page);
        return view;
    }
    //商城推荐判断
    public void setRecommend(){
        for(int i=2;i<4;i++){
            GetStoreRecommend(i);
        }
    }
    //商城推荐网络请求
    public void GetStoreRecommend(final int method){
        XutilsClass.getInstance().getStoreRecommend(method, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("GetStoreRecommend",s);
                Gson gson=new Gson();
                StoreRecommend storeRecommend=gson.fromJson(s,StoreRecommend.class);
                ImageLoad imageLoad=new ImageLoad();
                switch (method){
                    case 2:
                        Content.recommed_two=storeRecommend.getData().get(0).getId();
                        imageLoad.HttpImage("http://"+storeRecommend.getData().get(0).getImages_url(),store_two_img);
                        store_two_name.setText(storeRecommend.getData().get(0).getName());
                        store_two_text.setText("一周推荐");
                        break;
                    case 3:
                        Content.recommed_one=storeRecommend.getData().get(0).getId();
                        imageLoad.HttpImage("http://"+storeRecommend.getData().get(0).getImages_url(),store_one_img);
                        store_one_name.setText(storeRecommend.getData().get(0).getName());
                        store_one_text.setText("好物推荐");
                        break;
                }
            }
            @Override
            public void onError(Throwable throwable, boolean b) {}
            @Override
            public void onCancelled(CancelledException e) {}
            @Override
            public void onFinished() {
            }});
    }
    //商城轮播网络请求
    public void GetStoreCarousel(){
        XutilsClass.getInstance().getStoreCarousel(new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("GetStoreCarousel",s);
                Gson gson=new Gson();
                StoreCarousel storeCarousel=gson.fromJson(s,StoreCarousel.class);
                Cdata=storeCarousel.getData();
                if (storeCarousel.getStatus()==200){
                    getCdata();
                }
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

    //商城轮播
    private void getCdata() {
        mList=new ArrayList<>();
        for (int i=0;i<Cdata.size();i++){
            mList.add(new BannerEntity(i,"http://"+Cdata.get(i).getImages_url(),null,null));
        }
        banner.setList(mList);
//        banner.setChangeDuration(0);//设置切换时间
//        banner.setPauseDuration(2000);//设置停留时间
    }

    //商品列表网络请求
    public void GetStoreList(final int page){
        XutilsClass.getInstance().getStoreList(page, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("GetStoreList",s);
                Gson gson=new Gson();
                StoreList storeList=gson.fromJson(s,StoreList.class);

                if (page==1){
                    data=storeList.getData();
                    if (storeList.getStatus()==200){
                        gif_view_ll.setVisibility(View.GONE);
                        getData();
                    }else {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                gif_view_ll.setVisibility(View.GONE);
                                Toast.makeText(getActivity(),"请检查网络连接", Toast.LENGTH_SHORT).show();
                            }
                        }, 5000);
                    }
                }else {
                    if (storeList.getStatus()==200){
                        data.addAll(storeList.getData());
                        storeListviewItemAdapter.notifyDataSetChanged();
                        recommend_listview.onRefreshComplete();
                    }else {
                        recommend_listview.onRefreshComplete();
                    }
                }
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.e("GetStoreList",throwable.toString());
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //gifView.setVisibility(View.GONE);
                        gif_view_ll.setVisibility(View.GONE);
                        Toast.makeText(getActivity(),"请检查网络连接", Toast.LENGTH_SHORT).show();
                    }
                }, 5000);
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    //商品足迹记录网络请求
    public void RecordFootPrint(String Userid,String storelist_id){
        XutilsClass.getInstance().postFootPrint(Userid, storelist_id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("RecordFootPrint",s);
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
    //设置适配器
    private void getData() {
        storeListviewItemAdapter=new StoreListviewItemAdapter(getActivity(),data);
        listview_head.addHeaderView(store_fragment_head);
        listview_head.setAdapter(storeListviewItemAdapter);
    }



}
