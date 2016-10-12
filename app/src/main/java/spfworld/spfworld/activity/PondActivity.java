package spfworld.spfworld.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.fragment.find.PondDetailFragment;
import spfworld.spfworld.fragment.find.PondFragment;

public class PondActivity extends FragmentActivity {
    private FragmentManager FM;
    public Handler handler;
    private List<Fragment> FGList;
    private  final int MAIN_CONTENT_SPACE_ID=R.id.pond_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pond);
        x.view().inject(this);
        //fragment切换
        FM = getSupportFragmentManager();
        FGList = iniFragmentList();
        setFGshow(0);
        //handler传值
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 0:
                        setFGshow(0);
                        break;
                    case 1:
                        setFGshow(1);
                        break;
                }
            }
        };
    }


    /**
     * 按下标显示Fragment
     *
     * @param index
     */
    public void setFGshow(int index) {
        FragmentTransaction FT = FM.beginTransaction();
        if (index < FGList.size()) {
            for (int i = 0; i < FGList.size(); i++) {
                    if (index == i) {
                        FT.show(FGList.get(i));
                    } else {
                        FT.hide(FGList.get(i));

                    }

            }
        } else {
            Log.e("MainActivity", "下标越界没有此页面");
        }
        FT.commit();
    }
    /**
     * 初始化Fragment将Fragment添加到事务中去
     */
    public List<Fragment> iniFragmentList() {
        List<Fragment> list = new ArrayList<Fragment>();
        FragmentTransaction FT = FM.beginTransaction();

        PondFragment pondFragment=new PondFragment();
        PondDetailFragment detailFragment=new PondDetailFragment();

        FT.add(MAIN_CONTENT_SPACE_ID,pondFragment,"塘口_TAG=0");
        FT.add(MAIN_CONTENT_SPACE_ID,detailFragment,"塘口详情_TAG=1");

        FT.commit();

        list.add(pondFragment);
        list.add(detailFragment);

        return list;
    }
}
