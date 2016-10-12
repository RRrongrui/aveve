package spfworld.spfworld.fragment.find.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import spfworld.spfworld.R;

/**
 * Created by Administrator on 2016/9/14.
 */
public class UserNiNameFragment extends Fragment{
    private View view;
    @ViewInject(R.id.et_nicheng)
    private EditText editext;
    @ViewInject(R.id.layout)
    private RelativeLayout layout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.title_user_data,container,false);
        x.view().inject(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @Event(value={R.id.bu_user_data_finsh,
            R.id.tv_title_caly,R.id.et_nicheng,R.id.layout},
            type=View.OnClickListener.class)
    private void mClick(View v){

        switch (v.getId()){
            case R.id.bu_user_data_finsh://回退
                getActivity().finish();

                break;
            case R.id.tv_title_caly://完成
                String name = editext.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("name", name);
                getActivity().setResult(1, intent);
                getActivity().finish();

                break;
            case R.id.et_nicheng://昵称输入
                break;
            default:
                hideSystemKeyBoard(getActivity(),layout);
                break;
        }
    }

    public static void hideSystemKeyBoard(Context mcontext, View v) {
        InputMethodManager imm = (InputMethodManager) mcontext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
