package spfworld.spfworld.utils;//package myadl.com.adl.SceneryFragment;

import android.graphics.Bitmap;
import android.widget.ImageView;


import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.io.InterruptedIOException;

import spfworld.spfworld.R;

/**
 * Created by guozhengke on 2016-09-08.
 */
public class ImageLoad extends InterruptedIOException {
    /**
     * 从网络获取图片
     * @param Url 网络图片的请求地址
     * @param imageView 要设置为网络图片的ImageView
     */
    public void HttpImage(String Url, ImageView imageView){
        //显示图片的配置
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.bottom)// 设置图片在下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.bottom)// 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.bottom) // 设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .displayer(new RoundedBitmapDisplayer(10))  // 设置成圆角图片
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        ImageLoader.getInstance().displayImage(Url, imageView, options);
    }

    public void HttpListImage(String Url, ImageView imageView){
        //显示图片的配置
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.bottom)// 设置图片在下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.bottom)// 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.bottom) // 设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        ImageLoader.getInstance().displayImage(Url, imageView, options);
    }
}
