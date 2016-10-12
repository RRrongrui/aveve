package spfworld.spfworld.fragment.find.event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.adapter.RegistrationListviewItemAdapter;
import spfworld.spfworld.entity.EventRecommend;
import spfworld.spfworld.utils.XutilsClass;

/**
 * Created by guozhengke on 2016/9/12.
 * 活动推荐页
 */
public class UnderwayFragment extends Fragment {
    @ViewInject(R.id.underway_listview)
    private PullToRefreshListView underway_listview;

    private List<List<EventRecommend.DataBean>> underwayData;
    private RegistrationListviewItemAdapter underway_Adapter;
    private int page=1;

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){
            GetEventUderWay(1);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            GetEventUderWay(1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.find_event_underway,container,false);
        x.view().inject(this,view);
        //GetEventUderWay(page);
        underway_listview.setMode(PullToRefreshBase.Mode.BOTH);
        //设置PullRefreshListView上提加载时的加载提示
        underway_listview.getLoadingLayoutProxy(false, true).setPullLabel("上拉加载...");
        underway_listview.getLoadingLayoutProxy(false, true).setRefreshingLabel("正在加载...");
        underway_listview.getLoadingLayoutProxy(false, true).setReleaseLabel("松开加载更多...");
        // 设置PullRefreshListView下拉加载时的加载提示
        underway_listview.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新...");
        underway_listview.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新...");
        underway_listview.getLoadingLayoutProxy(true, false).setReleaseLabel("松开刷新...");
        underway_listview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(final PullToRefreshBase<ListView> refreshView) {
                //GetEventUderWay(1);
                underway_Adapter.notifyDataSetChanged();
//                refreshView.onRefreshComplete();
                refreshView.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        refreshView.onRefreshComplete();
                    }
                }, 1000);
                Log.e("PondFragment", "下拉");
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                GetEventUderWay(page);


            }
        });
        return view;
    }
    //进行中网络请求
    public void GetEventUderWay(final int page){
        final String method="4";
        XutilsClass.getInstance().getEvent(method,page, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("GetEventUderWay",s);
                Gson gson=new Gson();
                EventRecommend recommend=gson.fromJson(s,EventRecommend.class);
                if (page==1){
                    if (recommend.getStatus()==200){
                        underwayData=recommend.getData();
                        getRegistrationData();
                    }else {
                        underway_listview.onRefreshComplete();
                    }
                }else{
                    if (recommend.getStatus()==200){
                        underwayData.addAll(recommend.getData());
                        underway_Adapter.notifyDataSetChanged();
                        underway_listview.onRefreshComplete();
                    }else {
                        underway_listview.onRefreshComplete();
                    }
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
    //设置报名中适配器
    private void getRegistrationData() {
        underway_Adapter=new RegistrationListviewItemAdapter(getActivity(),underwayData);
        underway_listview.setAdapter(underway_Adapter);
    }
}
