package spfworld.spfworld.utils;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import org.xutils.x;

import java.io.File;

import spfworld.spfworld.constants.CommonConstants;

/**
 * Created by guozhengke on 2016/8/30.
 */
public class MyApplication extends Application {
    public static Context context;
    private static Handler mHandler;
    private static Thread mMainThread;
    private static int mMainThreadId;
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        mHandler = new Handler();
        mMainThread = Thread.currentThread();
        mMainThreadId = android.os.Process.myTid();
        instance = this;
        //xutils初始化
        x.Ext.init(this);
        context=this;
        //创建默认的ImageLoader配置参数
        ImageLoaderConfiguration imageLoaderConfiguration=ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(imageLoaderConfiguration);

        // 配置ImageLoad
        File cacheDir = new File(CommonConstants.SDPATH_IMAGE);
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory().cacheOnDisc().build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .memoryCacheExtraOptions(480, 800)
                .threadPoolSize(2)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new WeakMemoryCache())
                .memoryCacheSize(2 * 1024 * 1024)
                .discCacheSize(50 * 1024 * 1024)
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .discCacheFileCount(100)
//				.discCache(new UnlimitedDiscCache(cacheDir))
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .imageDownloader(
                        new BaseImageDownloader(getApplicationContext(),
                                5 * 1000, 30 * 1000)).writeDebugLogs()
                .defaultDisplayImageOptions(options).build();
        ImageLoader.getInstance().init(config);
    }

    /** 获取上下文对象 */
    public static Context getContext() {
        return context;
    }

    /** 获取Handler对象 */
    public static Handler getHandler() {
        return mHandler;
    }

    /** 获取主线程对象 */
    public static Thread getMainThread() {
        return mMainThread;
    }

    /** 获取主线程ID */
    public static int getMainThreadId() {
        return mMainThreadId;
    }

    public static MyApplication getInstance() {
        return instance;
    }


}

