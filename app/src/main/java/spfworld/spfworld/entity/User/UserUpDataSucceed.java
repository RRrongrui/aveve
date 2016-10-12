package spfworld.spfworld.entity.User;

/**
 * Created by Administrator on 2016/9/28.
 */
public class UserUpDataSucceed {

    /**
     * status : 200
     * message : 修改用户信息成功
     * data : null
     */

    private int status;
    private String message;
    private Object data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
