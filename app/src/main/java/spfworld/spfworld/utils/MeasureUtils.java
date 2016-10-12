package spfworld.spfworld.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * 屏幕操作工具类
 *
 */
public class MeasureUtils {  
       
    /** 
     * 获取屏幕宽 
     */ 
    public static int getWidth(Context context){  
        WindowManager wm=(WindowManager) context.getSystemService(Context.WINDOW_SERVICE);  
        DisplayMetrics outMetrics = new DisplayMetrics();  
        wm.getDefaultDisplay().getMetrics(outMetrics);  
        return outMetrics.widthPixels;  
    }  
       
    /** 
     * 获取屏幕高 
     */ 
    public static int getHeight(Context context){  
        WindowManager wm=(WindowManager) context.getSystemService(Context.WINDOW_SERVICE);  
        DisplayMetrics outMetrics = new DisplayMetrics();  
        wm.getDefaultDisplay().getMetrics(outMetrics);  
        return outMetrics.heightPixels;  
    }
    
    
   
}