package spfworld.spfworld.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import spfworld.spfworld.MainActivity;
import spfworld.spfworld.R;
import spfworld.spfworld.carousel.entity.BannerEntity;
import spfworld.spfworld.carousel.view.Banner;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.entity.Event;
import spfworld.spfworld.entity.EventDtail;
import spfworld.spfworld.fragment.find.event.EventFragment;
import spfworld.spfworld.fragment.find.store.LinkWebViewFragment;
import spfworld.spfworld.fragment.find.store.StoreDetailFragment;
import spfworld.spfworld.utils.ImageLoad;
import spfworld.spfworld.utils.SharedHelper;
import spfworld.spfworld.utils.XutilsClass;
import spfworld.spfworld.utils.dialog.MyAlertDialog;

/**
 * Created by guozhengke on 2016/9/13.
 * 活动详情
 */
public class EventDetailActivity extends AppCompatActivity {
    private FragmentManager FM;
    public Handler handler;
    private List<Fragment> FGList;
    private  final int MAIN_CONTENT_SPACE_ID=R.id.event_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);
        x.view().inject(this);
        //fragment切换
        FM=getSupportFragmentManager();
        FGList=iniFragmentList();
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
            Log.e("EventDetailActivity", "下标越界没有此页面");
        }
        FT.commit();
    }
    /**
     * 初始化Fragment将Fragment添加到事务中去
     */
    public List<Fragment> iniFragmentList() {
        List<Fragment> list = new ArrayList<Fragment>();
        FragmentTransaction FT = FM.beginTransaction();
        EventFragment eventFragment=new EventFragment();
        FT.add(MAIN_CONTENT_SPACE_ID,eventFragment,"活动详情_TAG=0");

        FT.commit();
        list.add(eventFragment);
        return list;
    }
}
