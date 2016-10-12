package spfworld.spfworld.activity.Tribune;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import spfworld.spfworld.R;
import spfworld.spfworld.fragment.find.tribune.TribuneDatailsFragment;


/**
 * 主题帖
 * Created by Administrator on 2016/9/6.
 */
public class TribuneDatailsActivity extends AppCompatActivity{
    private TribuneDatailsFragment tribuneDatailsFragment;
    private FragmentManager fragmt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tribune_topic_main);
        FragmentManager fragmt = getSupportFragmentManager();
        FragmentTransaction transaction = fragmt.beginTransaction();
        if (null==tribuneDatailsFragment){
            tribuneDatailsFragment = new TribuneDatailsFragment();
            transaction.add(R.id.id_frag_tribune_topic_layout,tribuneDatailsFragment);
            transaction.commit();
        }else {
            transaction.show(tribuneDatailsFragment);
        }
    }
}
