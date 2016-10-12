package spfworld.spfworld.activity.User;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.adapter.EventViewPagerAdapter;
import spfworld.spfworld.fragment.find.user.MyColtActiviesFragment;
import spfworld.spfworld.fragment.find.user.MyColtCommodityFragment;
import spfworld.spfworld.fragment.find.user.MyColtFondFragment;
import spfworld.spfworld.fragment.find.user.MyColtTribuneFragment;


/**
 * Created by Administrator on 2016/9/14.
 */
public class MyCollectActivity extends AppCompatActivity {
    private FragmentManager FM;
    private MyColtFondFragment myColtFondFragment;//塘口
    private MyColtActiviesFragment myActiviesFragment;//活动
    private MyColtTribuneFragment myColtTribuneFragment;//帖子
    private MyColtCommodityFragment myColtCommodityFragment;//商品
    private List<Fragment> mList;
    @ViewInject(R.id.frag_collent_viewpager)
    private ViewPager fragcollentviewpager;
    @ViewInject(R.id.rb_collent_frag_fond)
    private RadioButton rbcollentfragfond;//1
    @ViewInject(R.id.rb_collent_frag_activies)
    private RadioButton rbcollentfragactivies;//2
    @ViewInject(R.id.rb_collent_frag_tribune)
    private RadioButton rbcollentfragtribune;//3
    @ViewInject(R.id.rb_collent_frag_commodity)
    private RadioButton rbcollentfragcommodity;//4
    @ViewInject(R.id.bu_user_collent_finsh)
    private Button buusercollentfinsh;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycollect);
        x.view().inject(this);
        init();
        eventBack();

    }

    private void init() {
        mList=new ArrayList<Fragment>();
        FM=getSupportFragmentManager();
        myColtFondFragment=new MyColtFondFragment();
        myActiviesFragment=new MyColtActiviesFragment();
        myColtTribuneFragment=new MyColtTribuneFragment();
        myColtCommodityFragment=new MyColtCommodityFragment();
        mList.add(myColtFondFragment);
        mList.add(myActiviesFragment);
        mList.add(myColtTribuneFragment);
        mList.add(myColtCommodityFragment);
        viewpagerAdapter();
    }
    //viewpager绑定设置设配器
    public void viewpagerAdapter(){
        fragcollentviewpager.setAdapter(new EventViewPagerAdapter(FM,mList));
        //viewpager监听事件
        fragcollentviewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
            case R.id.rb_collent_frag_fond:
                fragcollentviewpager.setCurrentItem(0);
                break;
            case R.id.rb_collent_frag_activies:
                fragcollentviewpager.setCurrentItem(1);
                break;
            case R.id.rb_collent_frag_tribune:
                fragcollentviewpager.setCurrentItem(2);
                break;
            case R.id.rb_collent_frag_commodity:
                fragcollentviewpager.setCurrentItem(3);
                break;
        }

    }
    //RadioButton绑定适配器监听
    public void selectRadioButton(int position ){
        Log.i("selectRadioButton+++", String.valueOf(position));
        switch (position){
            case 0:
                rbcollentfragfond.setChecked(true);
                break;
            case 1:
                rbcollentfragactivies.setChecked(true);
                break;
            case 2:
                rbcollentfragtribune.setChecked(true);
                break;
            case 3:
                rbcollentfragcommodity.setChecked(true);
                break;

        }
    }
    //返回按钮点击事件
    public void eventBack(){
        buusercollentfinsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MyCollectActivity.this, UserActivity.class);
//                startActivity(intent);
                finish();
            }
        });
    }
}
