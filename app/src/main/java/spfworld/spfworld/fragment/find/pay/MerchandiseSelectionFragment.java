package spfworld.spfworld.fragment.find.pay;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.text.DecimalFormat;
import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.activity.EventDetailActivity;
import spfworld.spfworld.activity.PayActivity;
import spfworld.spfworld.adapter.EventRVGridViewAdapter;
import spfworld.spfworld.adapter.EventRecyclerViewAdapter;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.utils.DecorationItem;

/**
 * Created by guozhengke on 2016/9/18.
 * 支付选择商品页
 */
public class MerchandiseSelectionFragment extends Fragment {
    @ViewInject(R.id.merchandise_back)
    private ImageView merchandise_back;
    @ViewInject(R.id.merchandise_apply)
    private TextView merchandise_apply;
    @ViewInject(R.id.merchandise_jian)
    private ImageView merchandise_jian;
    @ViewInject(R.id.merchandise_jia)
    private ImageView merchandise_jia;
    @ViewInject(R.id.merchandise_text)
    private TextView merchandise_text;
    @ViewInject(R.id.merchandise_mony_text)
    private TextView merchandise_mony_text;
    @ViewInject(R.id.merchandise_mony)
    private TextView merchandise_mony;
    @ViewInject(R.id.merchandise_recyclerView)
    private RecyclerView merchandise_recyclerView;
    @ViewInject(R.id.merchandise_recyclerView_gridview)
    private RecyclerView recyclerView_gridview;
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager mGridLayoutManager;
    private EventRecyclerViewAdapter   eventRecyclerViewAdapter;
    private EventRVGridViewAdapter eventRVGridViewAdapter;
    private Handler handler;
    private int NUMBER=1;
    private double MONY=0;
    private DecimalFormat df;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.event_merchandise_selection,container,false);
        x.view().inject(this,view);
        //recyclerView水平滑动
        mLinearLayoutManager=new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        merchandise_recyclerView.setLayoutManager(mLinearLayoutManager);
        merchandise_recyclerView.addItemDecoration(new DecorationItem(getActivity(),LinearLayoutManager.HORIZONTAL));
        eventRecyclerViewAdapter=new EventRecyclerViewAdapter(getActivity(),Content.listTime);
        merchandise_recyclerView.setAdapter(eventRecyclerViewAdapter);
        Log.e("种22222",Content.RCTime);
        eventRecyclerViewAdapter.setOnItemClickListener(new EventRecyclerViewAdapter.EventRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data, int position) {
                Log.e("cccccc",data+position);
                Content.RCTime=data;
            }
        });
        //显示时间段gridview
        mGridLayoutManager=new GridLayoutManager(getActivity(),3);
        recyclerView_gridview.setLayoutManager(mGridLayoutManager);
        eventRVGridViewAdapter=new EventRVGridViewAdapter(getActivity(),Content.actTime);
        recyclerView_gridview.setAdapter(eventRVGridViewAdapter);
        Log.e("种3333333",Content.GRTime);
        eventRVGridViewAdapter.setOnItemClickListener(new EventRVGridViewAdapter.EventRVGridViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data, int position) {
                Log.e("aaaaaa",data+position);
                Content.GRTime=data;
            }
        });





        //传入获取参数
        merchandise_mony.setText("￥"+Content.mony);
        df= new DecimalFormat("###.00");//转化成为两位小数
        MONY=Double.valueOf(Content.mony);
        String mony=df.format(MONY);

        //计算价格和票数
        merchandise_text.setText(NUMBER+"");
        merchandise_mony_text.setText(mony);
        merchandise_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NUMBER==1){
                    merchandise_text.setText(NUMBER+"");
                    String mony=df.format(NUMBER*MONY);
                    merchandise_mony_text.setText(mony);
                    merchandise_jian.setImageResource(R.mipmap.event_subtract_false);
                    Toast.makeText(getActivity(),"亲,不能再减了哦", Toast.LENGTH_SHORT).show();
                }else if (NUMBER<1){
                    NUMBER=1;
                    merchandise_text.setText(NUMBER+"");
                    String mony=df.format(NUMBER*MONY);
                    merchandise_mony_text.setText(mony);
                    merchandise_jian.setImageResource(R.mipmap.event_subtract_false);
                    Toast.makeText(getActivity(),"亲,不能再减了哦", Toast.LENGTH_SHORT).show();
                }else {
                    NUMBER--;
                    if (NUMBER==1){
                        merchandise_text.setText(NUMBER+"");
                        String mony=df.format(NUMBER*MONY);
                        merchandise_mony_text.setText(mony);
                        merchandise_jian.setImageResource(R.mipmap.event_subtract_false);
                    }else {
                        merchandise_text.setText(NUMBER+"");
                        String mony=df.format(NUMBER*MONY);
                        merchandise_mony_text.setText(mony);
                        merchandise_jian.setImageResource(R.mipmap.event_subtract_true);
                    }
                }

            }
        });
        merchandise_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                merchandise_jian.setImageResource(R.mipmap.event_subtract_true);
                if (NUMBER==10){
                    merchandise_text.setText(NUMBER+"");
                    String mony=df.format(NUMBER*MONY);
                    merchandise_mony_text.setText(mony);
                    Toast.makeText(getActivity(),"亲,最多只能买这么多哦", Toast.LENGTH_SHORT).show();
                }else if (NUMBER>10){
                    NUMBER=10;
                    merchandise_text.setText(NUMBER+"");
                    String mony=df.format(NUMBER*MONY);
                    merchandise_mony_text.setText(mony);
                    Toast.makeText(getActivity(),"亲,最多只能买这么多哦", Toast.LENGTH_SHORT).show();
                }else {
                    NUMBER++;
                    merchandise_text.setText(NUMBER+"");
                    String mony=df.format(NUMBER*MONY);
                    merchandise_mony_text.setText(mony);
                }
            }
        });

        //返回键
        merchandise_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), EventDetailActivity.class);
                startActivity(intent);
            }
        });
        //下一步 跳转
        merchandise_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Content.Zmony=merchandise_mony_text.getText().toString();
                Content.NUMBER=merchandise_text.getText().toString();
                PayActivity payActivity= (PayActivity) getActivity();
                handler=payActivity.handler;
                Message message=new Message();
                message.what=1;
                handler.sendMessage(message);
            }
        });

        return view;
    }
}
