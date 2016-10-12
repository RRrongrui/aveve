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
import spfworld.spfworld.adapter.User.MyColtFondAdapter;
import spfworld.spfworld.entity.User.ColtFond;
import spfworld.spfworld.utils.SharedHelper;
import spfworld.spfworld.utils.XutilsClass;

/**
 * 塘口
 * Created by Administrator on 2016/9/28.
 */
public class MyColtFondFragment extends Fragment{
    private MyColtFondAdapter myColtFondAdapter;
    private List<ColtFond.DataBean> coltfondData;
    @ViewInject(R.id.fond_listview)
    private ListView fond_listview;
    private SharedHelper sharedHelper;
    private int page =1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.my_colt_fond,container,false);
        x.view().inject(this,view);
        sharedHelper=new SharedHelper(getActivity());
        GetMyColtFondFragment();
        return view;
    }
    private void GetMyColtFondFragment(){
        final String method="1";
        String Userid=sharedHelper.ReadData("String","Userid").toString();
        XutilsClass.getInstance().getMyColtFondFragment(method,Userid, page+"", new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.i("GetMyColtFondFragment==",s);
                Gson gson = new Gson();
                ColtFond coltFond = gson.fromJson(s,ColtFond.class);
                coltfondData = coltFond.getData();
                initfond();
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.i("GetMyColtFond==失败",throwable.toString());
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void initfond() {
        MyColtFondAdapter myColtFondAdapter = new MyColtFondAdapter(getActivity(),coltfondData);
        fond_listview.setAdapter(myColtFondAdapter);
    }
}
