package spfworld.spfworld.fragment.find.store;

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
import android.widget.ImageView;
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

import spfworld.spfworld.MainActivity;
import spfworld.spfworld.R;
import spfworld.spfworld.activity.StoreDetailActivity;
import spfworld.spfworld.adapter.StoreListviewItemAdapter;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.entity.StoreList;
import spfworld.spfworld.utils.SharedHelper;
import spfworld.spfworld.utils.XutilsClass;

/**
 * Created by guozhengke on 2016/9/4.
 */
public class FootPrintFragment extends Fragment {
    @ViewInject(R.id.gifView)
    private GifView gifView;
    @ViewInject(R.id.gif_view_ll)
    private LinearLayout gif_view_ll;
    @ViewInject(R.id.footprint_back)
    private ImageView img_back;
    @ViewInject(R.id.footprint_listview)
    private PullToRefreshListView footprint_listview;
    private StoreListviewItemAdapter  storeListviewItemAdapter;
    private SharedHelper sharedHelper;
    private List<StoreList.DataBean> data;
    int page=1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.store_footprint,container,false);
        x.view().inject(this,view);
        gifView.setGifImage(R.drawable.loading);//加载动画
        sharedHelper=new SharedHelper(getActivity());
        final String Userid=sharedHelper.ReadData("String","Userid").toString();
        GetFootPrint(Userid,page);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        footprint_listview.setMode(PullToRefreshBase.Mode.BOTH);
        //设置PullRefreshListView上提加载时的加载提示
        footprint_listview.getLoadingLayoutProxy(false, true).setPullLabel("上拉加载...");
        footprint_listview.getLoadingLayoutProxy(false, true).setRefreshingLabel("正在加载...");
        footprint_listview.getLoadingLayoutProxy(false, true).setReleaseLabel("松开加载更多...");
        // 设置PullRefreshListView下拉加载时的加载提示
        footprint_listview.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新...");
        footprint_listview.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新...");
        footprint_listview.getLoadingLayoutProxy(true, false).setReleaseLabel("松开刷新...");
        footprint_listview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
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
                GetFootPrint(Userid,page);
                Log.e("动作","下");
            }
        });
        footprint_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Content.storelist_id=data.get(position-1).getId();
                Intent intent=new Intent(getActivity(), StoreDetailActivity.class);
                startActivity(intent);
            }
        });
        return  view;
    }
    public void GetFootPrint(String Userid, final int page){
        XutilsClass.getInstance().getStoreFootPrint(Userid, page, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("GetFootPrint",s);
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
                                //gifView.setVisibility(View.GONE);
                                gif_view_ll.setVisibility(View.GONE);
                                Toast.makeText(getActivity(),"请检查网络连接", Toast.LENGTH_SHORT).show();
                            }
                        }, 5000);
                    }
                }else {
                    if (storeList.getStatus()==200){
                        data.addAll(storeList.getData());
                        storeListviewItemAdapter.notifyDataSetChanged();
                        footprint_listview.onRefreshComplete();
                    }else {
                        footprint_listview.onRefreshComplete();
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
    //设置适配器
    private void getData() {
        storeListviewItemAdapter=new StoreListviewItemAdapter(getActivity(),data);
        footprint_listview.setAdapter(storeListviewItemAdapter);
    }

}
