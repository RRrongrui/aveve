package spfworld.spfworld.entity.Tribune;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
public class TribuneCommentReply {

    /**
     * status : 200
     * message : 数据成功
     * data : [{"r_id":"50","uid":"17","pid":"5","r_pid":"46","username":"zar","replys":"Zzzz","created_at":"2016-09-19 15:17:56"},{"r_id":"51","uid":"17","pid":"5","r_pid":"46","username":"zar","replys":"Ttttttttttttttt","created_at":"2016-09-19 16:39:45"},{"r_id":"56","uid":"17","pid":"5","r_pid":"46","username":"zar","replys":"Sftr","created_at":"2016-09-20 10:49:47"},{"r_id":"57","uid":"17","pid":"5","r_pid":"46","username":"zar","replys":"11111","created_at":"2016-09-20 11:14:28"}]
     */

    private int status;
    private String message;
    /**
     * r_id : 50
     * uid : 17
     * pid : 5
     * r_pid : 46
     * username : zar
     * replys : Zzzz
     * created_at : 2016-09-19 15:17:56
     */

    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String r_id;
        private String uid;
        private String pid;
        private String r_pid;
        private String username;
        private String replys;
        private String created_at;

        public String getR_id() {
            return r_id;
        }

        public void setR_id(String r_id) {
            this.r_id = r_id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getR_pid() {
            return r_pid;
        }

        public void setR_pid(String r_pid) {
            this.r_pid = r_pid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getReplys() {
            return replys;
        }

        public void setReplys(String replys) {
            this.replys = replys;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }
    }
}
