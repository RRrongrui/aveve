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
import spfworld.spfworld.adapter.User.MyColtActiviesAdapter;
import spfworld.spfworld.entity.User.ColtActis;
import spfworld.spfworld.utils.SharedHelper;
import spfworld.spfworld.utils.XutilsClass;

/**
 *活动
 * Created by Administrator on 2016/9/14.
 */
public class MyColtActiviesFragment extends Fragment {
    private MyColtActiviesAdapter myColtActiviesAdapter;
    private List<ColtActis.DataBean> coltActisData;
    @ViewInject(R.id.activies_listview)
    private ListView activies_listview;
    private SharedHelper sharedHelper;
    private int page =1;
//    private String userid = "8";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.my_colt_activies,container,false);
        x.view().inject(this,view);
        sharedHelper=new SharedHelper(getActivity());
        GetMyColtActiviesFragment();
        return view;
    }
    private void GetMyColtActiviesFragment(){
        final String method="2";
        String Userid=sharedHelper.ReadData("String","Userid").toString();
        XutilsClass.getInstance().getMyColtFondFragment(method,Userid, page+"", new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.i("GetMyColtActivies==",s);
                Gson gson = new Gson();
                ColtActis coltActis = gson.fromJson(s,ColtActis.class);
                coltActisData = coltActis.getData();
                initactis();
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.i("GetMyColtActis==失败",throwable.toString());
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    private void initactis() {
        MyColtActiviesAdapter myColtActiviesAdapter = new MyColtActiviesAdapter(getActivity(),coltActisData);
        activies_listview.setAdapter(myColtActiviesAdapter);
    }
}

