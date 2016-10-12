package spfworld.spfworld.fragment.find;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import spfworld.spfworld.R;
import spfworld.spfworld.activity.LoginActivity;
import spfworld.spfworld.activity.PondActivity;
import spfworld.spfworld.carousel.entity.BannerEntity;
import spfworld.spfworld.carousel.view.Banner;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.entity.PondDetail;
import spfworld.spfworld.utils.SharedHelper;
import spfworld.spfworld.utils.XutilsClass;
import spfworld.spfworld.utils.dialog.CallDialog;
import spfworld.spfworld.utils.dialog.MyAlertDialog;

/**
 * Created by guozhengke on 2016/9/6.
 * 钓点详情
 */
public class PondDetailFragment extends Fragment {
    @ViewInject(R.id.pond_collct)
    private ImageView pond_collct;
    @ViewInject(R.id.pond_detail_back)
    private ImageView img_detail_back;
    @ViewInject(R.id.pond_detail_phone)
    private ImageView img_detail_phone;
    @ViewInject(R.id.pondDetail_title)
    private TextView tv_title;
    @ViewInject(R.id.pondDetail_name)
    private TextView tv_name;
    @ViewInject(R.id.pondDetail_adress)
    private TextView tv_adress;
//    @ViewInject(R.id.pond_detail_jigging)
//    private ImageView img_jigging;
//    @ViewInject(R.id.pond_detail_scat)
//    private ImageView img_scat;
//    @ViewInject(R.id.pond_detail_rud)
//    private ImageView img_rud;
//    @ViewInject(R.id.pond_detail_bait)
//    private ImageView img_bait;
    @ViewInject(R.id.daohang)
    private RelativeLayout daohang;
    @ViewInject(R.id.main_banner)
    private Banner mBanner;
    private List<BannerEntity> mList;
    private List<PondDetail.DataBean> data;
    private Handler handler;
    private View diagView;
    private FragmentManager FM;
    FragmentTransaction FT;
    private View view=null;
    private int FLAG=0;
    private int AUTO=0;
    private SharedHelper sharedHelper;
    private String Userid=null;
    private String phone=null;

    @Nullable
    //判断页面显示时网络请求
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden == false) {
            //判断登录状态
            sharedHelper=new SharedHelper(getActivity());
            final String user_key=sharedHelper.ReadData("String","user_key").toString();
            Userid=sharedHelper.ReadData("String","Userid").toString();
            if (user_key=="user_key"||user_key==null){
                AUTO=0;
            }else {
                AUTO=1;
            }
            GetPondDtail(Userid);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.find_pond_detail, container, false);
            x.view().inject(this, view);
            FM = getFragmentManager();
            FT = FM.beginTransaction();


            diagView = inflater.from(getContext()).inflate(R.layout.call_diag, container, false);
            img_detail_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().finish();
                }
            });
            //img_detail_phone.setImageBitmap();
            img_detail_phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("PondDetailFragment", "点击事件发生");
                    showDialog();
                }
            });
        //导航（暂未开放）
        daohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"暂未开放,敬请期待!", Toast.LENGTH_SHORT).show();
            }
        });
        //收藏
        pond_collct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (AUTO) {
                    case 0:
                        final MyAlertDialog myAlertDialog = new MyAlertDialog(getActivity());
                        myAlertDialog.setTitle("提示");
                        myAlertDialog.setMessage("是否登录或注册?");
                        myAlertDialog.SetCancelButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sharedHelper.cleardata();
                                Intent intent = new Intent(getActivity(), LoginActivity.class);
                                startActivity(intent);
                            }
                        });
                        myAlertDialog.SetDetermineButton("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                myAlertDialog.Dismiss();
                            }
                        });
                        myAlertDialog.Show();
                        break;
                    case 1:
                        switch (FLAG) {
                            case 0:
                                pond_collct.setImageResource(R.mipmap.collect);
                                PondDetailCollction(Userid);
                                FLAG = 1;
                                break;
                            case 1:
                                pond_collct.setImageResource(R.mipmap.pond_collect);
                                PondDetailCollctionDel(Userid);
                                FLAG = 0;
                                break;
                        }
                        break;
                }
            }
        });
        return view;
    }




    //拨打电话弹出框
    public void showDialog(){
        Log.e("PondDetailFragment","调用showDialog");
        CallDialog.Builder builder=new CallDialog.Builder(getActivity());
        if (data.get(0).getPhone()!=null||!data.get(0).getPhone().equals("")){
            builder.setTitle("021-31037228");
            phone="021-31037228";
        }else {
            builder.setTitle(data.get(0).getPhone());
            phone=data.get(0).getPhone();
        }
        builder.setPositiveButton("电话咨询", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(Intent.ACTION_CALL);
                Uri data=Uri.parse("tel:"+phone);
                intent.setData(data);
                startActivity(intent);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
    //收藏网络请求
    public void PondDetailCollction(String Userid){
        XutilsClass.getInstance().postPondCollection(Userid, Content.pond_id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("收藏",s);
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
    //取消收藏网络请求
    public void PondDetailCollctionDel(String Userid){
        XutilsClass.getInstance().postPondCollectionDel(Userid, Content.pond_id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("取消收藏",s);
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
    //详情页网络请求调用数据
    public void GetPondDtail(String userid){
        XutilsClass.getInstance().getPondDtail(userid,Content.pond_id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("PondDetailFragment+++",s);
                Gson gson=new Gson();
                PondDetail pondDetail=gson.fromJson(s,PondDetail.class);
                data=pondDetail.getData();
                getData();
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.e("请求错误",throwable.toString());
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    //设置数据
    private void getData() {
        tv_title.setText(data.get(0).getTheme());
        tv_name.setText(data.get(0).getTheme());
        tv_adress.setText(data.get(0).getAddress());
        //收藏
        switch (AUTO) {
            case 0:
                pond_collct.setImageResource(R.mipmap.pond_collect);
                break;
            case 1:
                if (data.get(0).getCollection() != null && !data.get(0).getCollection().equals("")) {
                    switch (data.get(0).getCollection()) {
                        case "0":
                            pond_collct.setImageResource(R.mipmap.pond_collect);
                            FLAG = 0;
                            break;
                        case "1":
                            pond_collct.setImageResource(R.mipmap.collect);
                            FLAG = 1;
                            break;
                    }
                } else {
                    pond_collct.setImageResource(R.mipmap.pond_collect);
                    FLAG = 0;
                }
                break;
        }
        //钓点情况
//        if (!data.get(0).getType().equals("")){
//            for (int i=0;i<data.get(0).getType().size();i++){
//                switch (data.get(0).getType().get(i)) {
//                    case "1":
//                        img_bait.setImageResource(R.mipmap.pond_bait);
//                        break;
//                    case "2":
//                        img_scat.setImageResource(R.mipmap.pond_scat);
//                        break;
//                    case "3":
//                        img_rud.setImageResource(R.mipmap.pond_rud);
//                        break;
//                    case "4":
//                        img_jigging.setImageResource(R.mipmap.pond_jigging);
//                        break;
//                }
//            }
//        }
        //轮播
//        if (data.get(0).getContent()!=null){}
        mList = new ArrayList<>();
        for (int i=0;i<data.get(0).getContent().size();i++){
            mList.add(new BannerEntity(i,"http://"+data.get(0).getContent().get(i),null,""));
        }
        mBanner.setList(mList);
//        mBanner.setChangeDuration(0);//设置切换时间
//        mBanner.setPauseDuration(2000);//设置停留时间
//        mBanner.setAuto(true);

    }
}
