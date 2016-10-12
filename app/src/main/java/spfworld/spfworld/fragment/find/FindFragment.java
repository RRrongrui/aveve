package spfworld.spfworld.fragment.find;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.ant.liao.GifView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import spfworld.spfworld.MainActivity;
import spfworld.spfworld.R;
import spfworld.spfworld.activity.CityListActivity;
import spfworld.spfworld.activity.EventActivity;
import spfworld.spfworld.activity.LoginActivity;
import spfworld.spfworld.activity.PondActivity;
import spfworld.spfworld.carousel.entity.BannerEntity;
import spfworld.spfworld.carousel.view.Banner;
import spfworld.spfworld.custom.FishAnimation;
import spfworld.spfworld.custom.WaterWaveView;
import spfworld.spfworld.entity.Carousel;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.entity.weater;

import spfworld.spfworld.utils.SharedHelper;
import spfworld.spfworld.utils.XutilsClass;

/**
 * Created by guozhengke on 2016/8/30.
 */
public class FindFragment extends Fragment {
    @ViewInject(R.id.gifView)
    private GifView gifView;
    @ViewInject(R.id.gif_view_ll)
    private LinearLayout gif_view_ll;
    @ViewInject(R.id.waveview_one)
    private WaterWaveView waveview_one;
    @ViewInject(R.id.waveview_two)
    private WaterWaveView waveview_two;
    @ViewInject(R.id.main_banner)
    private Banner mBanner;
    @ViewInject(R.id.wether_img)
    private ImageView wether_img;
    @ViewInject(R.id.wether_temperature)
    private TextView tv_wether;
    @ViewInject(R.id.wether_case)
    private TextView tv_case;
    @ViewInject(R.id.baidu_location)
    private TextView tv_city;
    @ViewInject(R.id.find_pond)
    private ImageView img_pond;
    @ViewInject(R.id.find_event)
    private ImageView img_event;
    @ViewInject(R.id.fish_one)
    private ImageView fish_one;
    @ViewInject(R.id.fish_two)
    private  ImageView fish_two;
    @ViewInject(R.id.fish_th)
    private ImageView fish_th;
    public static AMapLocationClientOption mLocationOption = null;
    public static AMapLocationClient mLocationClient=null;
    private List<BannerEntity> mList;
    private List<Carousel.DataBean> Cdata;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_find,container,false);
        x.view().inject(this,view);
        gifView.setGifImage(R.drawable.loading);
        FishAnimation fishAnimation=new FishAnimation();
        fishAnimation.fish(fish_one,15000,100);
        fishAnimation.fish(fish_two,13000,100);
        fishAnimation.fish(fish_th,14000,100);
        //加载波浪动画
        WaveAnimation();
        GetCarousel();
        //活动
        img_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), EventActivity.class);
                startActivity(intent);
            }
        });

        mLocationClient=new AMapLocationClient(getContext());
        inLocation();
        mLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation amapLocation) {
                if (amapLocation != null) {
                    if (amapLocation.getErrorCode() == 0) {
                        mLocationClient.stopLocation();
                        Log.e("chengshi++++++++=",amapLocation.getCity());
                        Content.mapcity=amapLocation.getCity();
                        Content.lnt=amapLocation.getLongitude()+"";//获取精度
                        Content.lat=amapLocation.getLatitude()+"";//获取纬度
                        weather(amapLocation.getCity());

                    }else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        Log.e("AmapError","location Error, ErrCode:"
                                + amapLocation.getErrorCode() + ", errInfo:"
                                + amapLocation.getErrorInfo());
                    }
                }
            }
        });
        //城市列表
        tv_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), CityListActivity.class);
                startActivity(intent);
            }
        });
        //塘口
        img_pond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), PondActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    //波浪动画设置
    private void WaveAnimation() {
        waveview_one.setAmplitude(15.0F);
        waveview_one.setWaterAlpha(100);
        waveview_one.setF(0.016F);
        waveview_one.setWaterLevel(0.5F);
        waveview_one.setColor(Color.argb(150,55,172,251));
        waveview_two.setAmplitude(15.0F);
        waveview_two.setWaterAlpha(100);
        waveview_two.setF(0.012F);
        waveview_two.setWaterLevel(0.5F);
        waveview_two.setColor(Color.argb(150,55,172,251));
        waveview_one.startWave();
        waveview_two.startWave();
    }

    public void weather(String city){
        if (Content.city.equals("")){
            tv_city.setText(city);
            getweatherdata(city);
        }else {
            tv_city.setText(Content.city);
            getweatherdata(Content.city);
        }
    }
    //网络请求天气（测试，聚合数据中心）
    private void getweatherdata(String cityname) {
        //String key="445362869081d177d5c945f228dfd534";
        String key="1417c5fa0cfee0c38922014b6c91d385";//正式版key
        XutilsClass.getInstance().getcityweather(cityname, key, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("TAG+++++++++",s);
               // Toast.makeText(getActivity(),"成功", Toast.LENGTH_SHORT).show();
                Gson gson=new Gson();
                weater wether=gson.fromJson(s,weater.class);
                String wetherCase=wether.getResult().getData().getRealtime().getWeather().getInfo();
                tv_wether.setText(wether.getResult().getData().getRealtime().getWeather().getTemperature()+"°C");
                tv_case.setText(wetherCase);
                if (wetherCase.contains("晴")){
                    wether_img.setImageResource(R.mipmap.wether);
                }else if (wetherCase.contains("雨")){
                    switch (wetherCase){
                        case "大雨":
                            wether_img.setImageResource(R.mipmap.wether_big_rain);
                            break;
                        case "阵雨":
                            wether_img.setImageResource(R.mipmap.wether_shower);
                            break;
                        case "小雨":
                            wether_img.setImageResource(R.mipmap.wether_small_rain);
                            break;
                        default:
                            wether_img.setImageResource(R.mipmap.wether_small_rain);
                            break;
                    }
                }else if(wetherCase.contains("阴")){
                    wether_img.setImageResource(R.mipmap.wether_cloudy_day);
                }else if (wetherCase.contains("雪")){
                    switch (wetherCase){
                        case "大雪":
                            wether_img.setImageResource(R.mipmap.wether_big_snow);
                            break;
                        case "雨夹雪":
                            wether_img.setImageResource(R.mipmap.wether_sleet);
                            break;
                        default:
                            wether_img.setImageResource(R.mipmap.wether_big_snow);
                            break;
                    }
                }else if(wetherCase.contains("云")){
                    wether_img.setImageResource(R.mipmap.wether_cloudy);
                }

            }
            @Override
            public void onError(Throwable throwable, boolean b) {
               // Toast.makeText(getActivity(),"失败", Toast.LENGTH_SHORT).show();
                Log.e("TAG",throwable.toString());
            }
            @Override
            public void onCancelled(CancelledException e) {
            }
            @Override
            public void onFinished() {

            }
        });
    }
    //轮播图网络请求
    public void GetCarousel(){
        XutilsClass.getInstance().getCarousel(new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("imgimgimgimg",s);
                Gson gson=new Gson();
                Carousel carousel=gson.fromJson(s,Carousel.class);
                Cdata=carousel.getData();
                if (carousel.getStatus()==200){
                    gif_view_ll.setVisibility(View.GONE);
                    getCdata();
                }else {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //gifView.setVisibility(View.GONE);
                            gif_view_ll.setVisibility(View.GONE);
                            Toast.makeText(getActivity(),"请检查网络连接", Toast.LENGTH_SHORT).show();
                        }
                    }, 5000);
                }
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifView.setVisibility(View.GONE);
                        gif_view_ll.setVisibility(View.GONE);
                        Toast.makeText(getActivity(),"请检查网络连接", Toast.LENGTH_SHORT).show();
                    }
                }, 5000);

            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    //获取轮播图img
    private void getCdata() {
        //gifView.setVisibility(View.GONE);
        mList = new ArrayList<>();
        for (int i=0;i<Cdata.size();i++){
            mList.add(new BannerEntity(i,"http://"+Cdata.get(i).getImg(),null,""));
        }
        mBanner.setList(mList);
//        mBanner.setChangeDuration(0);//设置切换时间
//        mBanner.setPauseDuration(2000);//设置停留时间
    }

    //高德地图定位
    private static void inLocation(){
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(false);
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.startLocation();
    }

}
