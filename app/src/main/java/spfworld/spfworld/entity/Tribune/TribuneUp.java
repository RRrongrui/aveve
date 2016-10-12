package spfworld.spfworld.entity.Tribune;

/**
 * Created by Administrator on 2016/10/11.
 */
public class TribuneUp {

    /**
     * status : 200
     * message : 发布成功
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
