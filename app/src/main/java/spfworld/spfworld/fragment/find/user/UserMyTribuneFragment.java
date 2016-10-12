package spfworld.spfworld.fragment.find.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.activity.Tribune.TribuneDatailsActivity;
import spfworld.spfworld.adapter.User.UserMyTribuneAdapter;
import spfworld.spfworld.entity.User.UserMyTribune;
import spfworld.spfworld.utils.SharedHelper;
import spfworld.spfworld.utils.XutilsClass;
import spfworld.spfworld.widget.percent.view.MyListView;

/**
 * Created by Administrator on 2016/10/10.
 */
public class UserMyTribuneFragment extends Fragment {
    private Context ncontext;
    private View view;
    private SharedHelper sharedHelper;
    @ViewInject(R.id.activity_back)
    private RelativeLayout activity_back;
    @ViewInject(R.id.lv_tribune)
    private MyListView lv_tribune;
    private LinearLayoutManager manager;
    private List<UserMyTribune.DataBean> myTribuneData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.user_tribune, container, false);
        x.view().inject(this, view);
        sharedHelper=new SharedHelper(getActivity());
        ncontext = getActivity();
        GetUserMyTribune();
        activity_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return view;
    }
    private int page = 1;
    private void GetUserMyTribune(){
        String Userid=sharedHelper.ReadData("String","Userid").toString();
        XutilsClass.getInstance().getUserMyTribuneFragment(Userid, page, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("oye==成功",s);
                Gson gson = new Gson();
                UserMyTribune userMyTribune = gson.fromJson(s,UserMyTribune.class);
                myTribuneData=userMyTribune.getData();
                isMyList();
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.e("oye==失败",throwable.toString());
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    private void isMyList(){
        manager = new LinearLayoutManager(ncontext,LinearLayoutManager.VERTICAL,false);
//        lv_tribune.setLayoutManager(manager);
        if (myTribuneData == null){
            myTribuneData = new ArrayList<>();
        }
        UserMyTribuneAdapter userMyTribuneAdapter = new UserMyTribuneAdapter(getActivity(),myTribuneData);
        lv_tribune.setAdapter(userMyTribuneAdapter);
        lv_tribune.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ncontext, TribuneDatailsActivity.class);
//                intent.putExtra("id", (CharSequence) myTribuneData);
                startActivity(intent);
            }
        });
    }
}
