package ab.util;

import android.os.Message;

/**
 * 封装message
 * 
 * @author xutao
 * 
 */
public class AbMsgUtil {
	public static Message getMessage(Object obj, int what) {
		Message message = new Message();
		message.obj = obj;
		message.what = what;
		return message;
	}
}
