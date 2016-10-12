package spfworld.spfworld.fragment.find.user;

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
import spfworld.spfworld.adapter.User.MyColtCommodityAdapter;
import spfworld.spfworld.entity.User.ColtComm;
import spfworld.spfworld.utils.SharedHelper;
import spfworld.spfworld.utils.XutilsClass;

/**
 * //商品
 * Created by Administrator on 2016/9/28.
 */
public class MyColtCommodityFragment extends Fragment {
    private MyColtCommodityAdapter myColtCommodityAdapter;
    private List<ColtComm.DataBean> coltCommData;
    @ViewInject(R.id.commodity_listview)
    private ListView commodity_listview;
    private SharedHelper sharedHelper;
    private int page =1;
//    private String userid = "8";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.my_colt_commodity,container,false);
        x.view().inject(this,view);
        sharedHelper=new SharedHelper(getActivity());
        GetMyColtCommodityFragment();
        return view;
    }
    private void GetMyColtCommodityFragment(){
        final String method="4";
        String Userid=sharedHelper.ReadData("String","Userid").toString();
        XutilsClass.getInstance().getMyColtFondFragment(method,Userid, page+"", new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.i("GetMyColtCommodity==",s);
                Gson gson = new Gson();
                ColtComm coltComm = gson.fromJson(s,ColtComm.class);
                coltCommData = coltComm.getData();
                initcomm();
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.i("GetMyColtCommodit==失败",throwable.toString());
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    private void initcomm() {
        MyColtCommodityAdapter myColtCommodityAdapter = new MyColtCommodityAdapter(getActivity(),coltCommData);
        commodity_listview.setAdapter(myColtCommodityAdapter);
    }
}
