package spfworld.spfworld;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TabHost;

import org.xutils.x;

import spfworld.spfworld.activity.FindActivity;
import spfworld.spfworld.activity.StoreActivity;
import spfworld.spfworld.activity.Tribune.TribuneActivity;
import spfworld.spfworld.activity.User.UserActivity;

public class MainActivity extends TabActivity{

    private FrameLayout MAINLinearLayout;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        getTab();

        //模糊处理未完成
//        MAINLinearLayout = (FrameLayout) findViewById(R.id.MAINLinearLayout);
    }
    //选项卡设置
    public void getTab(){
        TabHost host = getTabHost();
        LayoutInflater out = LayoutInflater.from(this);

        //创建发现选项卡
        TabHost.TabSpec find=host.newTabSpec("find");
        View find_view=out.inflate(R.layout.tab_find,null);
        find.setIndicator(find_view);
        find.setContent(new Intent(MainActivity.this, FindActivity.class));
        host.addTab(find);
        //创建商城选项卡
        TabHost.TabSpec store=host.newTabSpec("store");
        View store_view=out.inflate(R.layout.tab_store,null);
        store.setIndicator(store_view);
        store.setContent(new Intent(MainActivity.this, StoreActivity.class));
        host.addTab(store);
        //创建论坛选项卡
        TabHost.TabSpec tribune=host.newTabSpec("tribune");
        View tribune_view=out.inflate(R.layout.tab_tribune,null);
        tribune.setIndicator(tribune_view);
        tribune.setContent(new Intent(MainActivity.this, TribuneActivity.class));
        host.addTab(tribune);
        //创建我的选项卡
        TabHost.TabSpec my=host.newTabSpec("my");
        View my_view=out.inflate(R.layout.tab_my,null);
        my.setIndicator(my_view);
        my.setContent(new Intent(MainActivity.this, UserActivity.class));
        host.addTab(my);
    }
}
