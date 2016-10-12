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
import spfworld.spfworld.adapter.User.MyColtTribuneAdapter;
import spfworld.spfworld.entity.User.ColtTribune;
import spfworld.spfworld.utils.SharedHelper;
import spfworld.spfworld.utils.XutilsClass;

/**
 * 帖子
 * Created by Administrator on 2016/9/28.
 */
public class MyColtTribuneFragment extends Fragment {
    private MyColtTribuneAdapter myColtTribuneAdapter;
    private List<ColtTribune.DataBean> coltTribuneData;
    @ViewInject(R.id.tribune_listview)
    private ListView tribune_listview;
    private SharedHelper sharedHelper;
    private int page =1;
//    private String userid = "8";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.my_colt_tribune,container,false);
        x.view().inject(this,view);
        sharedHelper=new SharedHelper(getActivity());
        GetMyColtTribuneFragment();
        return view;
    }
    private void GetMyColtTribuneFragment(){
        final String method="3";
        String Userid=sharedHelper.ReadData("String","Userid").toString();
        XutilsClass.getInstance().getMyColtFondFragment(method,Userid, page+"", new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.i("GetMyColtTribune==",s);
                Gson gson = new Gson();
                ColtTribune coltComm = gson.fromJson(s,ColtTribune.class);
                coltTribuneData = coltComm.getData();
                initTribune();
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.i("GetMyColtTribune==失败",throwable.toString());
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    private void initTribune() {
        MyColtTribuneAdapter myColtTribuneAdapter = new MyColtTribuneAdapter(getActivity(),coltTribuneData);
        tribune_listview.setAdapter(myColtTribuneAdapter);
    }
}
