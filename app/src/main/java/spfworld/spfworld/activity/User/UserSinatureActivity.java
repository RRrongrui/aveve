package spfworld.spfworld.activity.User;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import spfworld.spfworld.R;
import spfworld.spfworld.fragment.find.user.UserSinatureFragment;


/**
 * Created by Administrator on 2016/9/11.
 */
public class UserSinatureActivity extends AppCompatActivity {
    private UserSinatureFragment userSinatureFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);

        FragmentManager fragmt = getSupportFragmentManager();
        FragmentTransaction transaction = fragmt.beginTransaction();
        if (null==userSinatureFragment){
            userSinatureFragment = new UserSinatureFragment();
            transaction.add(R.id.id_frag_user_date_layout,userSinatureFragment);
            transaction.commit();
        }else {
            transaction.show(userSinatureFragment);
        }
    }
}
