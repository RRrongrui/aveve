package spfworld.spfworld.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by guozhengke on 2016/8/30.
 * 轻量级缓存：自动登录
 */
public class SharedHelper {
    private Context mContext;

    public SharedHelper() {
    }

    public SharedHelper(Context mContext) {
        this.mContext = mContext;
    }


    /**
     * ，以键值对的方式存储
     * @param type 数据类型如String，int，boolean
     * @param name 数据名字
     * @param data 数据值
     */
    public void PutData(String type, String name, Object data) {
        SharedPreferences Sp = mContext.getSharedPreferences("Investigate", Context.MODE_PRIVATE);
        SharedPreferences.Editor Se = Sp.edit();
        switch (type) {
            case "int":
                Se.putInt(name, (Integer) data);
                break;
            case "String":
                Se.putString(name, (String) data);
                break;
            case "boolean":
                Se.putBoolean(name, (Boolean) data);
                break;
            case "long":
                Se.putLong(name, (Long) data);
                break;
            case "float":
                Se.putFloat(name, (Float) data);
                break;
            default:
                Log.e("SharedHelper", "错误定位SharedHelper," + "无此类型的数据:" + type);
                break;
        }
        Se.commit();
    }

    /**
     * 从XML数据存储中获取数据
     * @param type  数据类型
     * @param name  数据名
     * @return
     */
    public Object ReadData(String type,String name){
        SharedPreferences Sp = mContext.getSharedPreferences("Investigate", Context.MODE_PRIVATE);
        Object data=new Object();
        switch (type){
            case "int":
                data=Sp.getInt(name,0);
                break;
            case "String":
                data=Sp.getString(name,name);
                break;
            case "boolean":
                data=Sp.getBoolean(name,false);
                break;
            case "long":
                data=Sp.getLong(name,0);
                break;
            case "float":
                data=Sp.getFloat(name,0);
                break;
            default:
                Log.e("SharedHelper", "错误定位SharedHelper," + "无此数据:" + type);
                break;
        }
        return  data;
    }

    /**
     * 清除所有的数据
     */
    public void cleardata(){
        SharedPreferences Sp = mContext.getSharedPreferences("Investigate", Context.MODE_PRIVATE);
        SharedPreferences.Editor Se = Sp.edit();
        Se.clear();
        Se.commit();
    }
}
