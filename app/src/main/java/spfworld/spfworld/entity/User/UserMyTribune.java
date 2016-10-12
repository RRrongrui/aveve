package spfworld.spfworld.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/10/10.
 */
public class UserMyTribune {

    /**
     * status : 200
     * message : 获取数据成功
     * data : [{"c_id":"47","uid":"15","username":"RR","title":"舒通","comment":"舒通","zan":"1","replycount":"0","created_at":"2016-10-09 13:42:30","pic":["m.yundiaoke.cn/Uploads/Notepic/0"],"headpic":"m.yundiaoke.cn/Uploads/Headpic/","count":"0"},{"c_id":"46","uid":"15","username":"RR","title":"我是噗通","comment":"不一样吧我","zan":"1","replycount":"0","created_at":"2016-10-09 13:36:39","pic":["m.yundiaoke.cn/Uploads/Notepic/0"],"headpic":"m.yundiaoke.cn/Uploads/Headpic/","count":"0"},{"c_id":"45","uid":"15","username":"RR","title":"我是舒通！","comment":"不一样的我！！！","zan":"0","replycount":"0","created_at":"2016-10-09 13:35:33","pic":["m.yundiaoke.cn/Uploads/Notepic/0"],"headpic":"m.yundiaoke.cn/Uploads/Headpic/","count":"0"},{"c_id":"31","uid":"15","username":"Rong","title":"Rong","comment":"RONG","zan":"0","replycount":"0","created_at":"2016-09-30 16:30:28","pic":["m.yundiaoke.cn/Uploads/Notepic/201609301630280notepic.png"],"headpic":"m.yundiaoke.cn/Uploads/Headpic/","count":"0"}]
     */

    private int status;
    private String message;
    /**
     * c_id : 47
     * uid : 15
     * username : RR
     * title : 舒通
     * comment : 舒通
     * zan : 1
     * replycount : 0
     * created_at : 2016-10-09 13:42:30
     * pic : ["m.yundiaoke.cn/Uploads/Notepic/0"]
     * headpic : m.yundiaoke.cn/Uploads/Headpic/
     * count : 0
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
        private String c_id;
        private String uid;
        private String username;
        private String title;
        private String comment;
        private String zan;
        private String replycount;
        private String created_at;
        private String headpic;
        private String count;
        private List<String> pic;

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

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getZan() {
            return zan;
        }

        public void setZan(String zan) {
            this.zan = zan;
        }

        public String getReplycount() {
            return replycount;
        }

        public void setReplycount(String replycount) {
            this.replycount = replycount;
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

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public List<String> getPic() {
            return pic;
        }

        public void setPic(List<String> pic) {
            this.pic = pic;
        }
    }
}
