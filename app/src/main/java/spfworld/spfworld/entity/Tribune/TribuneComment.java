package spfworld.spfworld.entity.Tribune;

import java.util.List;

/**
 * 显示帖子回复内容  层主信息
 * Created by Administrator on 2016/9/26.
 */
public class TribuneComment {

    /**
     * status : 200
     * message : 数据成功
     * data : [{"r_id":"44","uid":"17","pid":"4","username":"zar","replys":"Q*","created_at":"2016-09-19 13:20:29","images":["m.yundiaoke.cn/Uploads/Notepic/0"],"headpic":"20160926115653headpic.png"},{"r_id":"45","uid":"17","pid":"4","username":"zar","replys":"Sfsdfsfsdf","created_at":"2016-09-19 13:29:37","images":["m.yundiaoke.cn/Uploads/Notepic/0"],"headpic":"20160926115653headpic.png"},{"r_id":"47","uid":"17","pid":"4","username":"zar","replys":"Pop","created_at":"2016-09-19 13:41:40","images":["m.yundiaoke.cn/Uploads/Notepic/0"],"headpic":"20160926115653headpic.png"}]
     */

    private int status;
    private String message;
    /**
     * r_id : 44
     * uid : 17
     * pid : 4
     * username : zar
     * replys : Q*
     * created_at : 2016-09-19 13:20:29
     * images : ["m.yundiaoke.cn/Uploads/Notepic/0"]
     * headpic : 20160926115653headpic.png
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
        private String username;
        private String replys;
        private String created_at;
        private String headpic;
        private List<String> images;

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

        public String getHeadpic() {
            return headpic;
        }

        public void setHeadpic(String headpic) {
            this.headpic = headpic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
