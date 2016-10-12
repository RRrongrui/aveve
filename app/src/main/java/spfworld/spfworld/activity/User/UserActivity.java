package spfworld.spfworld.activity.User;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.fragment.find.user.UserFragment;

//我的模块
public class UserActivity extends AppCompatActivity {
    private FragmentManager FM;
    public Handler handler;
    private List<Fragment> MyFt;
    private  final int MAIN_CONTENT_SPACE_ID=R.id.my_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        x.view().inject(this);
        //页面切换
        FM=getSupportFragmentManager();
        MyFt=iniFragmentList();
        setTFshow(0);
    }


    public void setTFshow(int index) {
        FragmentTransaction FT = FM.beginTransaction();
        if (index < MyFt.size()) {
            for (int i = 0; i < MyFt.size(); i++) {
                if (index == i) {
                    FT.show(MyFt.get(i));
                } else {
                    FT.hide(MyFt.get(i));
                }
            }
        } else {
            Log.e("MainActivity", "下标越界没有此页面");
        }
        FT.commit();
    }
    private List<Fragment> iniFragmentList() {
        List<Fragment> list = new ArrayList<Fragment>();
        FragmentTransaction FT = FM.beginTransaction();

        UserFragment userFragment = new UserFragment();

        FT.add(MAIN_CONTENT_SPACE_ID, userFragment, "发现_TAG=0");

        FT.commit();

        list.add(userFragment);

        return list;
    }

}
