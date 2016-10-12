package spfworld.spfworld.fragment.find.event;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.ant.liao.GifView;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.activity.EventDetailActivity;
import spfworld.spfworld.adapter.EventRecommendGridviewAdapter;
import spfworld.spfworld.adapter.RecommendListviewAdapter;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.entity.Event;
import spfworld.spfworld.entity.EventRecommend;
import spfworld.spfworld.utils.XutilsClass;

/**
 * Created by guozhengke on 2016/9/12.
 * 活动推荐页
 */
public class RecommendFragment extends Fragment {
    @ViewInject(R.id.gifView)
    private GifView gifView;
    @ViewInject(R.id.gif_view_ll)
    private LinearLayout gif_view_ll;
    private List<Event.DataBean> GridData;
    private List<List<EventRecommend.DataBean>> RecommendData;
    private EventRecommendGridviewAdapter gridviewAdapter;
    private RecommendListviewAdapter listviewAdapter;
    private GridView recommend_gridview;
    @ViewInject(R.id.recommend_listview)
    private PullToRefreshListView recommend_listview;
    private LinearLayout gridview;
    private ListView listviewHeard;
    private int page=1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.find_event_recommend,container,false);
        x.view().inject(this,view);
        gifView.setGifImage(R.drawable.loading);//加载动画
        GetEventToday();
       GetEventChoiceness(1);
        gridview= (LinearLayout) inflater.inflate(R.layout.recommend_head,null);
        recommend_gridview= (GridView) gridview.findViewById(R.id.recommend_gridview);
        listviewHeard=recommend_listview.getRefreshableView();
        //今日推荐点击事件
        recommend_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Content.act_id=GridData.get(position).getAct_id();
                Intent intent=new Intent(getActivity(), EventDetailActivity.class);
                startActivity(intent);
            }
        });
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
//                GetEventChoiceness(1);
                listviewAdapter.notifyDataSetChanged();
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
                GetEventChoiceness(page);
                Log.e("动作","下");
            }
        });

        return view;
    }
    //今日推荐网络请求
    public void GetEventToday(){
        final String method="1";
        XutilsClass.getInstance().getEvent(method,1, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("GetEvent+++++",s);
                Gson gson=new Gson();
                Event event=gson.fromJson(s,Event.class);
                GridData=event.getData();
                getGridData();
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
    //精选推荐网络请求
    public void GetEventChoiceness(final int page){
        final String method="2";
        XutilsClass.getInstance().getEvent(method,page, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("GetEventChoiceness",s);
                Gson gson=new Gson();
                EventRecommend recommend=gson.fromJson(s,EventRecommend.class);

                if (page==1){
                    RecommendData=recommend.getData();
                    if (recommend.getStatus()==200){
                        gif_view_ll.setVisibility(View.GONE);
                        getListData();
                    }else {
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

                }else {
                    if (recommend.getStatus()==200){
                        RecommendData.addAll(recommend.getData());
                        listviewAdapter.notifyDataSetChanged();
                        recommend_listview.onRefreshComplete();
                    }else {
                        recommend_listview.onRefreshComplete();
                    }
                }
            }
            @Override
            public void onError(Throwable throwable, boolean b) {
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
    //设置今日推荐gridview设配器
    private void getGridData() {
        gridviewAdapter=new EventRecommendGridviewAdapter(getActivity(),GridData);
        recommend_gridview.setAdapter(gridviewAdapter);

    }
    //设置精选推荐listview设配器
    private void getListData() {
        listviewAdapter=new RecommendListviewAdapter(getActivity(),RecommendData);
        listviewHeard.addHeaderView(gridview);
        listviewHeard.setAdapter(listviewAdapter);
    }
}
