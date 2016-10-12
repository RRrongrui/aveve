package spfworld.spfworld.entity;

/**
 * Created by guozhengke on 2016/9/9.
 */
public class Verification {

    /**
     * status : 200
     * message : 获取验证码成功
     * data : 912597
     */

    private int status;
    private String message;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
