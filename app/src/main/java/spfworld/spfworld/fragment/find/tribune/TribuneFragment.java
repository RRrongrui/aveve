package spfworld.spfworld.fragment.find.tribune;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

import ab.util.AbLogUtil;
import ab.util.AbStrUtil;
import spfworld.spfworld.R;
import spfworld.spfworld.activity.Tribune.PostTribuneDateActivity;
import spfworld.spfworld.activity.Tribune.TribuneDatailsActivity;
import spfworld.spfworld.adapter.Tribune.GridAdapter;
import spfworld.spfworld.adapter.Tribune.TribuneAdapter;
import spfworld.spfworld.entity.Tribune.Tribune;
import spfworld.spfworld.utils.SharedHelper;
import spfworld.spfworld.utils.XutilsClass;

/**
 * 论坛界面
 * Created by Administrator on 2016/8/30.
 */
public class TribuneFragment extends Fragment {
    private View view;
    private TribuneAdapter adapter;
    private ArrayList<Tribune.DataBean> data = new ArrayList<>();
    private int page=1;
    @ViewInject(R.id.mRecyclerView)
    private RecyclerView recyclerView;
    @ViewInject(R.id.swipelayout)
    private SwipeRefreshLayout layout;
    @ViewInject(R.id.tv_select)
    private TextView tvSelect;
    private GridAdapter ga;
    private LinearLayoutManager manager;
    private Context mContext;
    private PopupWindow popupWindow;
    private SharedHelper sharedHelper;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedHelper=new SharedHelper(getActivity());
        mContext = getContext();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tribune, container, false);
        x.view().inject(this, view);
        findViews();
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initdata();
    }
    //下拉刷新
    private void initdata() {
        layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                page=1;
                PotTribune();
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    //松手
                    Log.i("","===="+manager.findLastCompletelyVisibleItemPosition());
                    if (manager.findLastCompletelyVisibleItemPosition() == (data.size()-1)) {
                        //代表拖动到底部
                        Toast.makeText(getActivity(), "加载中。。。", Toast.LENGTH_SHORT).show();
                        page++;
                        PotTribune();
                    }
                }
            }
        });
    }
    //帖子列表网络请求
    String keyword = "2";
    private void PotTribune() {
        XutilsClass.getInstance().getTribune(page+"",keyword, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
               try {
                   AbLogUtil.i("oye", AbStrUtil.parseEmpty(s));
                   Gson gson=new Gson();
                   Tribune tribune = gson.fromJson(s,Tribune.class);
                   if (tribune!=null){
                       if (tribune.getStatus() == 200){
                           if (tribune.getData()!=null&&tribune.getData().size()>0){
                               if (page == 1){
                                   data.clear();
                               }
                               data.addAll(tribune.getData());
                               adapter.notifyDataSetChanged();
                               //写代码 下载数据 解析 记得做判断  不然后台炸 你必炸 最好外围包一个try catch
                               //后台给你的状态码 等于多少是成功的时候再去拿数据
                               layout.setRefreshing(false);
                           }
                       }
                   }
               }catch (Exception e){

               }
            }
            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.e("TribuneFragment数据请求失败",throwable.toString());
            }
            @Override
            public void onCancelled(CancelledException e) {
            }
            @Override
            public void onFinished() {
            }
        });
    }
    private void findViews() {
        manager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        if (data == null){
            data = new ArrayList<>();
        }

        adapter = new TribuneAdapter(mContext, data);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new TribuneAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {
                Intent intent = new Intent(mContext, TribuneDatailsActivity.class);
                intent.putExtra("id",data);
                startActivity(intent);
//                Toast.makeText(mContext, "点击条目ID：" + data, Toast.LENGTH_SHORT).show();
            }
        });
        PotTribune();
    }

    @Event(value = {R.id.iv_discuss, R.id.ll_pag}, type = View.OnClickListener.class)
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_discuss://发布我的帖子
                Intent intent = new Intent(mContext, PostTribuneDateActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_pag://智能排序
                ShowListPopupWindow();

                break;
            default:
                break;
        }
    }

    private void ShowListPopupWindow() {
        ListView lv = new ListView(getActivity());
        String[] data = {"智能排序","按热度排序", "按时间排序"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.pop_list_item_1,R.id.tv_text, data);
        lv.setAdapter(adapter);
        final PopupWindow popupWindow = new PopupWindow(lv, 300, 500);
        // 可以获取焦点
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.showAsDropDown(tvSelect);
//        popupWindow.dismiss();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (popupWindow!=null&&popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
                if (position == 0){
                    keyword="2";
                }else if (position ==1){
                    keyword = "1";
                }else {
                    keyword = "2";
                }
                page= 1;//默认请求第一页数据
                PotTribune();
            }
        });
    }
}