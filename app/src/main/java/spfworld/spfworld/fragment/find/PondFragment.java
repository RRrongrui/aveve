package spfworld.spfworld.fragment.find;

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
import spfworld.spfworld.activity.PondActivity;
import spfworld.spfworld.adapter.PondItemAdapter;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.entity.Pond;
import spfworld.spfworld.utils.XutilsClass;

/**
 * Created by guozhengke on 2016/9/4.
 */
public class PondFragment extends Fragment {
    @ViewInject(R.id.gifView)
    private GifView gifView;
    @ViewInject(R.id.gif_view_ll)
    private LinearLayout gif_view_ll;
    @ViewInject(R.id.pond_back)
    private ImageView img_back;
    @ViewInject(R.id.pond_map)
    private ImageView img_map;
    @ViewInject(R.id.pond_listview)
    private PullToRefreshListView pond_listview;
    private Handler handler;
    private List<Pond.DataBean> data;
    private int page=1;
    private PondItemAdapter pondItemAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_pond, container, false);
        x.view().inject(this, view);
        gifView.setGifImage(R.drawable.loading);//加载动画
        GetPond(page);
        pond_listview.setMode(PullToRefreshBase.Mode.BOTH);
        //设置PullRefreshListView上提加载时的加载提示
        pond_listview.getLoadingLayoutProxy(false, true).setPullLabel("上拉加载...");
        pond_listview.getLoadingLayoutProxy(false, true).setRefreshingLabel("正在加载...");
        pond_listview.getLoadingLayoutProxy(false, true).setReleaseLabel("松开加载更多...");
        // 设置PullRefreshListView下拉加载时的加载提示
        pond_listview.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新...");
        pond_listview.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新...");
        pond_listview.getLoadingLayoutProxy(true, false).setReleaseLabel("松开刷新...");
        pond_listview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(final PullToRefreshBase<ListView> refreshView) {
                //GetPond(page);
                Log.e("PondFragment", "下拉");
                pondItemAdapter.notifyDataSetChanged();
                refreshView.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        refreshView.onRefreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                GetPond(page);
            }
        });
        //详情页
        pond_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Content.pond_id=data.get(position-1).getPon_id();
                PondActivity pondActivity= (PondActivity) getActivity();
                handler=pondActivity.handler;
                Message message=new Message();
                message.what=1;
                handler.sendMessage(message);
            }
        });
        //返回上层
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    //塘口列表网络请求
    public void GetPond(final int page){
        XutilsClass.getInstance().getPond(page, Content.lnt,Content.lat, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("PondFragment++++数据返回结果",s);
                Gson gson=new Gson();
                Pond pond=gson.fromJson(s,Pond.class);
                if (page==1){
                    data=pond.getData();
                    if (pond.getStatus()==200){
                        gif_view_ll.setVisibility(View.GONE);
                        isData();
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
                    data.addAll(pond.getData());
                    pondItemAdapter.notifyDataSetChanged();
                    pond_listview.onRefreshComplete();
                }
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.e("PondFragment++++数据请求失败",throwable.toString());
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

    //listview添加适配器
    private void isData() {
        pondItemAdapter= new PondItemAdapter(getActivity(), data);
        pond_listview.setAdapter(pondItemAdapter);
    }
}
