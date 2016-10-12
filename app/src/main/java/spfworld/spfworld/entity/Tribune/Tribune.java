package spfworld.spfworld.entity.Tribune;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
public class Tribune {

    /**
     * status : 200
     * message : 数据成功
     * data : [{"c_id":"11","uid":"17","username":"zar","title":"","comment":"","pic":["201609191653530notepic.png","201609191653531notepic.png"],"zan":"0","replycount":"0","created_at":"2016-09-23 09:28:00","headpic":"","count":"0"},{"c_id":"10","uid":"17","username":"zar","title":"Fdfsdf ","comment":"Fdfsdf ","pic":["0"],"zan":"0","replycount":"0","created_at":"2016-09-23 00:00:00","headpic":"","count":"7"},{"c_id":"12","uid":"17","username":"zar","title":"Ee","comment":"","pic":["201609201651370notepic.png","201609201651371notepic.png"],"zan":"0","replycount":"0","created_at":"2016-09-23 00:00:00","headpic":"","count":"2"},{"c_id":"14","uid":"17","username":"zar","title":"Sdfsfsf","comment":"","pic":["201609221506480notepic.png","201609221506481notepic.png"],"zan":"0","replycount":"0","created_at":"2016-09-23 00:00:00","headpic":"","count":"0"},{"c_id":"13","uid":"17","username":"zar","title":"Fatigues hi","comment":"Fddddd","pic":["0"],"zan":"0","replycount":"0","created_at":"2016-09-22 10:30:20","headpic":"","count":"0"},{"c_id":"9","uid":"17","username":"zar","title":"Fljdfashlgasglsa hfs adf'lg lag last hallaaaa","comment":"Slash Isolde sjdf*slfj flashed lsad'f Åland local kids k*flajHHLKHLKHLK LGJLKFLDJGLF HL JDFG D","pic":["201609191612010notepic.png"],"zan":"0","replycount":"0","created_at":"2016-09-19 16:12:01","headpic":"","count":"3"},{"c_id":"8","uid":"17","username":"zar","title":"Fljdfashlgasglsa hfs adf'lg lag last hall","comment":"Slash Isolde sjdf*slfj flashed lsad'f Åland local kids k*flajHHLKHLKHLK LGJLKFLDJGLF HL JDFG D","pic":["0"],"zan":"0","replycount":"0","created_at":"2016-09-19 16:11:41","headpic":"","count":"0"},{"c_id":"7","uid":"17","username":"zar","title":"aaaaaa","comment":"aaaaa","pic":["201609131715272notepic.png"],"zan":"0","replycount":"0","created_at":"2016-09-18 00:00:00","headpic":"","count":"2"},{"c_id":"5","uid":"8","username":"wzp","title":"aaaaaa","comment":"上传数据测试，发送*费时间管理 老师讲道理就干啥了就董事的历史拉萨弗兰克收到了哈哈","pic":["201609131715270notepic.png","201609131715271notepic.png","201609131715272notepic.png"],"zan":"0","replycount":"0","created_at":"2016-09-13 17:15:27","headpic":"m.yundiaoke.cn/Uploads/Notepic/201609131715272notepic.png","count":"1"},{"c_id":"4","uid":"17","username":"zar","title":"上传数据","comment":"上传数据测试，发送*费时间管理 老师讲道理就干啥了就董事的历史拉萨弗兰克收到了哈哈","pic":["201609131659470notepic.png","201609131659471notepic.png","201609131659472notepic.png"],"zan":"0","replycount":"0","created_at":"2016-09-13 16:59:47","headpic":"","count":"3"}]
     */

    private int status;
    private String message;
    /**
     * c_id : 11
     * uid : 17
     * username : zar
     * title :
     * comment :
     * pic : ["201609191653530notepic.png","201609191653531notepic.png"]
     * zan : 0
     * replycount : 0
     * created_at : 2016-09-23 09:28:00
     * headpic :
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
