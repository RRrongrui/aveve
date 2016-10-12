package spfworld.spfworld.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9.
 */
public class ColtTribune {

    /**
     * status : 200
     * message : 获取数据成功
     * data : [{"id":"15","pid":"42","userid":"8","is_del":"1","c_id":"42","uid":"8","username":"我爱钓鱼","title":"钓鱼了","count":"3"},{"id":"14","pid":"37","userid":"8","is_del":"1","c_id":"37","uid":"26","username":"钓遍天下无敌手","title":"海边小钓，收获还不错吧  哈哈","count":"3"},{"id":"13","pid":"40","userid":"8","is_del":"1","c_id":"40","uid":"28","username":"路亚小哥","title":"寻找群山中的圣地","count":"13"}]
     */

    private int status;
    private String message;
    /**
     * id : 15
     * pid : 42
     * userid : 8
     * is_del : 1
     * c_id : 42
     * uid : 8
     * username : 我爱钓鱼
     * title : 钓鱼了
     * count : 3
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
        private String id;
        private String pid;
        private String userid;
        private String is_del;
        private String c_id;
        private String uid;
        private String username;
        private String title;
        private String count;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getIs_del() {
            return is_del;
        }

        public void setIs_del(String is_del) {
            this.is_del = is_del;
        }

        public String getC_id() {
            return c_id;
        }

        public void setC_id(String c_id) {
            this.c_id = c_id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }
    }
}
