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
public class HistoryFragment extends Fragment {
    @ViewInject(R.id.history_listview)
    private ListView history_listview;

    private List<List<EventRecommend.DataBean>> historyData;
    private RegistrationListviewItemAdapter history_Adapter;

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){
            GetEventHistory();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            GetEventHistory();
        }
    }

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.find_event_history,container,false);
        x.view().inject(this,view);
        return view;
    }
    //历史网络请求
    public void GetEventHistory(){
        final String method="5";
        XutilsClass.getInstance().getEvent(method,1, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("GetEventHistory",s);
                Gson gson=new Gson();
                EventRecommend recommend=gson.fromJson(s,EventRecommend.class);
                historyData=recommend.getData();
                getRegistrationData();
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
        history_Adapter=new RegistrationListviewItemAdapter(getActivity(),historyData);
        history_listview.setAdapter(history_Adapter);
    }
}
