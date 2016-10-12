package spfworld.spfworld.entity;

import java.util.List;

/**
 * Created by guozhengke on 2016/9/12.
 */
public class Event {

    /**
     * status : 200
     * message : 获取数据成功
     * data : [{"act_id":"2","theme":"aaaa","original":"200.00","price":"100.00","begin_time":"1473004800","end_time":"1473696000","dead_time":"1472999280","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160902/57c93a4b81c3b.jpg"},{"act_id":"3","theme":"的说法是电风扇","original":"200.00","price":"18.00","begin_time":"1473350400","end_time":"1474041600","dead_time":"1473346920","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160902/57c93a4b81c3b.jpg"}]
     */

    private int status;
    private String message;
    /**
     * act_id : 2
     * theme : aaaa
     * original : 200.00
     * price : 100.00
     * begin_time : 1473004800
     * end_time : 1473696000
     * dead_time : 1472999280
     * content : m.yundiaoke.cn/Uploads/Ueditor/image/20160902/57c93a4b81c3b.jpg
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
