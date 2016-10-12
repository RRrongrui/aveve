package spfworld.spfworld.entity.Tribune;

import java.util.List;

/**
 * Created by Administrator on 2016/9/28.
 */
public class TribnueCommentReplyData {

    /**
     * status : 200
     * message : 数据成功
     * data : [{"r_id":"78","uid":"17","pid":"12","username":"zar","replys":"C_id 12","created_at":"2016-09-22 10:14:22","images":["m.yundiaoke.cn/Uploads/Notepic/0"],"headpic":"20160927110623headpic.png","cengzhu":[{"r_id":"83","uid":"17","pid":"12","r_pid":"78","username":"zar","replys":"Zzzzzzzz","created_at":"2016-09-22 11:58:55"},{"r_id":"85","uid":"17","pid":"12","r_pid":"78","username":"zar","replys":"W***","created_at":"2016-09-22 13:52:40"}]},{"r_id":"66","uid":"17","pid":"12","username":"zar","replys":"521","created_at":"2016-09-20 17:01:14","images":["m.yundiaoke.cn/Uploads/Notepic/0"],"headpic":"20160927110623headpic.png","cengzhu":[{"r_id":"82","uid":"17","pid":"12","r_pid":"66","username":"zar","replys":"Hhhhhhhhhh","created_at":"2016-09-22 11:16:44"},{"r_id":"84","uid":"17","pid":"12","r_pid":"66","username":"zar","replys":"BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB","created_at":"2016-09-22 13:39:42"},{"r_id":"86","uid":"17","pid":"12","r_pid":"66","username":"zar","replys":"Ggggggg","created_at":"2016-09-22 18:02:11"}]}]
     */

    private int status;
    private String message;
    /**
     * r_id : 78
     * uid : 17
     * pid : 12
     * username : zar
     * replys : C_id 12
     * created_at : 2016-09-22 10:14:22
     * images : ["m.yundiaoke.cn/Uploads/Notepic/0"]
     * headpic : 20160927110623headpic.png
     * cengzhu : [{"r_id":"83","uid":"17","pid":"12","r_pid":"78","username":"zar","replys":"Zzzzzzzz","created_at":"2016-09-22 11:58:55"},{"r_id":"85","uid":"17","pid":"12","r_pid":"78","username":"zar","replys":"W***","created_at":"2016-09-22 13:52:40"}]
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
        /**
         * r_id : 83
         * uid : 17
         * pid : 12
         * r_pid : 78
         * username : zar
         * replys : Zzzzzzzz
         * created_at : 2016-09-22 11:58:55
         */

        private List<CengzhuBean> cengzhu;

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

        public List<CengzhuBean> getCengzhu() {
            return cengzhu;
        }

        public void setCengzhu(List<CengzhuBean> cengzhu) {
            this.cengzhu = cengzhu;
        }

        public static class CengzhuBean {
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
}
