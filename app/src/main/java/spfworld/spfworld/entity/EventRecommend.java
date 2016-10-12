package spfworld.spfworld.entity;

import java.util.List;

/**
 * Created by guozhengke on 2016/9/14.
 * 精选推荐，活动中，进行中，历史  实体类
 */
public class EventRecommend {

    /**
     * status : 200
     * message : 获取数据成功
     * data : [[{"act_id":"2","theme":"aaaa","original":"200.00","price":"100.00","begin_time":"2016-09-05","end_time":"2016-09-13","dead_time":"2016-09-04","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg"},{"act_id":"3","theme":"的说法是电风扇","original":"200.00","price":"18.00","begin_time":"2016-09-09","end_time":"2016-09-17","dead_time":"2016-09-08","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160902/57c93a4b81c3b.jpg"},{"act_id":"4","theme":"第三方的所发生的","original":"11.00","price":"1.00","begin_time":"2016-09-12","end_time":"2016-09-12","dead_time":"2016-09-12","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg"}],[{"act_id":"5","theme":"的说法是电风扇","original":"111.00","price":"12.00","begin_time":"2016-09-12","end_time":"2016-09-16","dead_time":"2016-09-12","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg"},{"act_id":"6","theme":"多杀多少反倒是","original":"111.00","price":"11.00","begin_time":"2016-09-12","end_time":"2016-09-12","dead_time":"2016-09-12","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg"},{"act_id":"7","theme":"的说法是电风扇","original":"12.00","price":"1.00","begin_time":"2016-09-12","end_time":"2016-09-17","dead_time":"2016-09-12","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg"}]]
     */

    private int status;
    private String message;
    /**
     * act_id : 2
     * theme : aaaa
     * original : 200.00
     * price : 100.00
     * begin_time : 2016-09-05
     * end_time : 2016-09-13
     * dead_time : 2016-09-04
     * content : m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg
     */

    private List<List<DataBean>> data;

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

    public List<List<DataBean>> getData() {
        return data;
    }

    public void setData(List<List<DataBean>> data) {
        this.data = data;
    }

    public static class DataBean {
        private String act_id;
        private String theme;
        private String original;
        private String price;
        private String begin_time;
        private String end_time;
        private String dead_time;
        private String content;

        public String getAct_id() {
            return act_id;
        }

        public void setAct_id(String act_id) {
            this.act_id = act_id;
        }

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }

        public String getOriginal() {
            return original;
        }

        public void setOriginal(String original) {
            this.original = original;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getBegin_time() {
            return begin_time;
        }

        public void setBegin_time(String begin_time) {
            this.begin_time = begin_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getDead_time() {
            return dead_time;
        }

        public void setDead_time(String dead_time) {
            this.dead_time = dead_time;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
