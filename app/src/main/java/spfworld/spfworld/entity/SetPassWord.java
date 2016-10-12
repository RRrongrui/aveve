package spfworld.spfworld.entity;

/**
 * Created by guozhengke on 2016/9/9.
 */
public class SetPassWord {

    /**
     * status : 200
     * message : 注册成功
     * data : {"userid":"7","token":"a7ec1a45a6a37af58f2bb3ad1819001f68538121"}
     */

    private int status;
    private String message;
    /**
     * userid : 7
     * token : a7ec1a45a6a37af58f2bb3ad1819001f68538121
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
