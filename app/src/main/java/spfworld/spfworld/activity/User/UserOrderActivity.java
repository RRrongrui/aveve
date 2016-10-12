package spfworld.spfworld.activity.User;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import spfworld.spfworld.R;
import spfworld.spfworld.fragment.find.user.UserOrderFragment;

/**
 * Created by Administrator on 2016/9/28.
 */
public class UserOrderActivity extends AppCompatActivity {
    private UserOrderFragment userOrderFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);
        FragmentManager fragmt = getSupportFragmentManager();
        FragmentTransaction transaction = fragmt.beginTransaction();
        if (null == userOrderFragment) {
            userOrderFragment = new UserOrderFragment();
            transaction.add(R.id.id_frag_user_date_layout, userOrderFragment);
            transaction.commit();
        } else {
            transaction.show(userOrderFragment);
        }
    }
}
