package spfworld.spfworld.geographicalMap;


import android.content.Context;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

/**
 * Created by guozhengke on 2016/9/4.
 */
public class MyAMapLocation {
    public static MyAMapLocation myaMapLocation=null;
    public static AMapLocationClientOption mLocationOption = null;
    public static AMapLocationClient mLocationClient=null;
    public static MyAMapLocation getaMapLocation(Context context, AMapLocationListener aMapLocationListener) {
        if (myaMapLocation==null){
            myaMapLocation=new MyAMapLocation();
        }
        mLocationClient=new AMapLocationClient(context);
        mLocationClient.unRegisterLocationListener(aMapLocationListener);
        inLocation();
        return myaMapLocation;
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
    public  void stop(){
        mLocationClient.stopLocation();
    }


}
