package ab.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GsonTools {

	public GsonTools() {
		// TODO Auto-generated constructor stub
	}

	public static String createGsonString(Object object) {
		Gson gson = new Gson();
		String gsonString = gson.toJson(object);
		return gsonString;
	}

	public static <T> T changeGsonToBean(String gsonString, Class<T> cls) {
		Gson gson = new Gson();
		T t = gson.fromJson(gsonString, cls);
		return t;
	}
	public static <T> List<T> changeGsonToList(String gsonString, Class<T> cls) {
		Gson gson = new Gson();
		List<T> list = gson.fromJson(gsonString, new TypeToken<List<T>>() {}.getType());
		return list;
	}
	public static <T> List<Map<String, T>> changeGsonToListMaps(
			String gsonString) {
		List<Map<String, T>> list = null;
		Gson gson = new Gson();
		list = gson.fromJson(gsonString, new TypeToken<List<Map<String, T>>>() {
		}.getType());
		return list;
	}

	public static <T> Map<String, T> changeGsonToMaps(String gsonString) {
		Map<String, T> map = null;
		Gson gson = new Gson();
		map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
		}.getType());
		return map;
	}
	public static String bean2Json(int status,Map<String,Object> datas)throws Exception{
		JSONObject obj=new JSONObject();
		obj.put("status", status);
		Set<String>keys=datas.keySet();
		for (String key : keys) {
			obj.put(key, datas.get(key));
		}
		return obj.toString();
	}

}
