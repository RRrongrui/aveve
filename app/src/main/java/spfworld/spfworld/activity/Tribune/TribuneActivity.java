package spfworld.spfworld.activity.Tribune;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.fragment.find.tribune.TribuneFragment;

//论坛模块
public class TribuneActivity extends AppCompatActivity {
    private FragmentManager FM;
    public Handler handler;
    private List<Fragment> TriFt;
    private  final int MAIN_CONTENT_SPACE_ID=R.id.tri_fagment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tribune);
        x.view().inject(this);
        //页面切换
        FM=getSupportFragmentManager();
        TriFt=iniFragmentList();
        setTFshow(0);
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 0:
                        setTFshow(0);
                        break;
                }
            }
        };
    }


    public void setTFshow(int index) {
        FragmentTransaction FT = FM.beginTransaction();
        if (index < TriFt.size()) {
            for (int i = 0; i < TriFt.size(); i++) {
                if (index == i) {
                    FT.show(TriFt.get(i));
                } else {
                    FT.hide(TriFt.get(i));
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

        TribuneFragment tribuneFragment = new TribuneFragment();

        FT.add(MAIN_CONTENT_SPACE_ID, tribuneFragment, "发现_TAG=0");

        FT.commit();

        list.add(tribuneFragment);

        return list;
    }

}
