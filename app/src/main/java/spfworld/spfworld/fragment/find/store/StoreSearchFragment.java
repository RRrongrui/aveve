package spfworld.spfworld.fragment.find.store;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

import spfworld.spfworld.MainActivity;
import spfworld.spfworld.R;
import spfworld.spfworld.activity.StoreActivity;
import spfworld.spfworld.activity.StoreDetailActivity;
import spfworld.spfworld.adapter.StoreListviewItemAdapter;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.entity.StoreList;
import spfworld.spfworld.entity.StoreSerch;
import spfworld.spfworld.utils.XutilsClass;

/**
 * Created by guozhengke on 2016/9/6.
 * 商城搜索页
 */
public class StoreSearchFragment extends Fragment {
    @ViewInject(R.id.store_serch_back)
    private ImageView tv_back;
    @ViewInject(R.id.store_serch_listview)
    private ListView store_serch_listview;
    private List<StoreList.DataBean> data;
    private StoreListviewItemAdapter storeListviewItemAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.store_serch_list,container,false);
        x.view().inject(this,view);
        GetStoreSerchList(1);
        //返回
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        //列表
        store_serch_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Content.storelist_id=data.get(position).getId();
                Intent intent=new Intent(getActivity(), StoreDetailActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    //根据关键字进行网络请求
    public void GetStoreSerchList(int page){
        XutilsClass.getInstance().getStoreSerchList(page, Content.serech_keyword, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("GetStoreSerchList",s);
                Gson gson=new Gson();
                StoreList storeSerch=gson.fromJson(s,StoreList.class);
                data=storeSerch.getData();
                if (storeSerch.getStatus()==200) {
                    getData();
                }
            }

            @Override
            public void onError(Throwable throwable, boolean b) {

            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    //设置适配器
    private void getData() {
        storeListviewItemAdapter=new StoreListviewItemAdapter(getActivity(),data);
        store_serch_listview.setAdapter(storeListviewItemAdapter);

    }
}
