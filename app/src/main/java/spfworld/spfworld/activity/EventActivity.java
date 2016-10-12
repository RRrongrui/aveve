package spfworld.spfworld.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import spfworld.spfworld.MainActivity;
import spfworld.spfworld.R;
import spfworld.spfworld.adapter.EventViewPagerAdapter;
import spfworld.spfworld.fragment.find.event.HistoryFragment;
import spfworld.spfworld.fragment.find.event.RecommendFragment;
import spfworld.spfworld.fragment.find.event.RegistrationFragment;
import spfworld.spfworld.fragment.find.event.UnderwayFragment;

public class EventActivity extends FragmentActivity {
    private FragmentManager FM;
    private RegistrationFragment mRegistrationFragment;
    private RecommendFragment mRecommendFragment;
    private UnderwayFragment mUnderwayFragment;
    private HistoryFragment mHistoryFragment;
    private List<Fragment> mList;

    @ViewInject(R.id.event_viewpager_fragment)
    private ViewPager mViewPager;
    @ViewInject(R.id.btn_recommed)
    private RadioButton btn_recommend;
    @ViewInject(R.id.btn_underway)
    private RadioButton btn_underway;
    @ViewInject(R.id.btn_registration)
    private RadioButton btn_register;
    @ViewInject(R.id.btn_history)
    private RadioButton btn_history;
    @ViewInject(R.id.event_back)
    private ImageView event_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        x.view().inject(this);
        init();
        eventBack();
    }
    //初始化组件
    public void init(){
        mList=new  ArrayList<Fragment>();
        FM=getSupportFragmentManager();
        mRecommendFragment=new RecommendFragment();
        mRegistrationFragment=new RegistrationFragment();
        mUnderwayFragment=new UnderwayFragment();
        mHistoryFragment=new HistoryFragment();
        mList.add(mRecommendFragment);
        mList.add(mRegistrationFragment);
        mList.add(mUnderwayFragment);
        mList.add(mHistoryFragment);
        viewpagerAdapter();
    }
    //viewpager绑定设置设配器
    public void viewpagerAdapter(){
        mViewPager.setAdapter(new EventViewPagerAdapter(FM,mList));
        //viewpager监听事件
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                Log.i("setOnPageChangeListener", String.valueOf(position));
                selectRadioButton(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
    //RadioButton点击事件viewpager切换
    public void MyOclick(View view){
        switch (view.getId()){
            case R.id.btn_recommed:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.btn_registration:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.btn_underway:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.btn_history:
                mViewPager.setCurrentItem(3);
                break;
        }

    }
    //RadioButton绑定适配器监听
    public void selectRadioButton(int position ){
        Log.i("selectRadioButton+++", String.valueOf(position));
        switch (position){
            case 0:
                btn_recommend.setChecked(true);
                break;
            case 1:
                btn_register.setChecked(true);
                break;
            case 2:
                btn_underway.setChecked(true);
                break;
            case 3:
                btn_history.setChecked(true);
                break;

        }
    }
    //返回按钮点击事件
    public void eventBack(){
        event_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
