package spfworld.spfworld.activity.User;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import spfworld.spfworld.R;

/**
 * Created by Administrator on 2016/9/18.
 */
public class FriendActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_friend);
        Button buFinsh = (Button) findViewById(R.id.bu_user_data_finsh);
        buFinsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
