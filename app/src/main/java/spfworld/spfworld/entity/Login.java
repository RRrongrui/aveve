package spfworld.spfworld.entity;

/**
 * Created by guozhengke on 2016/9/9.
 */
public class Login {

    /**
     * status : 200
     * message : 登录成功
     * data : {"userid":"15","token":"e87158a68c107f78737e4095e3641f3726e5002c"}
     */

    private int status;
    private String message;
    /**
     * userid : 15
     * token : e87158a68c107f78737e4095e3641f3726e5002c
     */

    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String userid;
        private String token;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
