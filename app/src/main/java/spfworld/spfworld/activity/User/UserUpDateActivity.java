package spfworld.spfworld.activity.User;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import spfworld.spfworld.R;
import spfworld.spfworld.fragment.find.user.PersonalUpDateFragment;

/**
 * 我的资料设置
 * Created by Administrator on 2016/9/7.
 */
public class UserUpDateActivity extends AppCompatActivity{
    private PersonalUpDateFragment personalUpdateFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);
        FragmentManager fragmt = getSupportFragmentManager();
        FragmentTransaction transaction = fragmt.beginTransaction();
        if (null==personalUpdateFragment){
            personalUpdateFragment = new PersonalUpDateFragment();
            transaction.add(R.id.id_frag_user_date_layout,personalUpdateFragment);
            transaction.commit();
        }else {
            transaction.show(personalUpdateFragment);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        personalUpdateFragment.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);
//        String name = data.getStringExtra("name");
//
//        if(requestCode == REQUEST_SECOND ) {
//            String name = data.getStringExtra("name");
//            tvName.setText(name);
//        }
    }
}



