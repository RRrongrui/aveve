package spfworld.spfworld.entity;

import java.util.List;

/**
 * Created by guozhengke on 2016/9/20.
 */
public class EventDtail {

    /**
     * status : 200
     * message : 获取数据成功
     * data : [{"act_id":"3","theme":"的说法是电风扇","original":"200.00","price":"18.00","begin_time":"2016-09-22","end_time":"2016-09-22","dead_time":"2016-09-21","content":["m.yundiaoke.cn/Uploads/Ueditor/image/20160902/57c93a4b81c3b.jpg","m.yundiaoke.cn/Uploads/Ueditor/image/20160902/57c91d4142f4d.jpg","m.yundiaoke.cn/Uploads/Ueditor/image/20160902/57c948be946b4.jpg"],"tags":"0","phone":"13699882255","mobile":"13622558899","limit_num":"100","mer_name":"云钓客","act_time":["22:30-00:00"],"act_prov":"江西","act_city":"南昌","act_area":"西湖区","address":"八一大道888号","sig_num":0,"describe":"飒飒发","newTime":["周四2016-09-22"],"biaoqian":"0","collection":"1"}]
     */

    private int status;
    private String message;
    /**
     * act_id : 3
     * theme : 的说法是电风扇
     * original : 200.00
     * price : 18.00
     * begin_time : 2016-09-22
     * end_time : 2016-09-22
     * dead_time : 2016-09-21
     * content : ["m.yundiaoke.cn/Uploads/Ueditor/image/20160902/57c93a4b81c3b.jpg","m.yundiaoke.cn/Uploads/Ueditor/image/20160902/57c91d4142f4d.jpg","m.yundiaoke.cn/Uploads/Ueditor/image/20160902/57c948be946b4.jpg"]
     * tags : 0
     * phone : 13699882255
     * mobile : 13622558899
     * limit_num : 100
     * mer_name : 云钓客
     * act_time : ["22:30-00:00"]
     * act_prov : 江西
     * act_city : 南昌
     * act_area : 西湖区
     * address : 八一大道888号
     * sig_num : 0
     * describe : 飒飒发
     * newTime : ["周四2016-09-22"]
     * biaoqian : 0
     * collection : 1
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
        private String tags;
        private String phone;
        private String mobile;
        private String limit_num;
        private String mer_name;
        private String act_prov;
        private String act_city;
        private String act_area;
        private String address;
        private String sig_num;
        private String describe;
        private String biaoqian;
        private String collection;
        private List<String> content;
        private List<String> act_time;
        private List<String> newTime;

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

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getLimit_num() {
            return limit_num;
        }

        public void setLimit_num(String limit_num) {
            this.limit_num = limit_num;
        }

        public String getMer_name() {
            return mer_name;
        }

        public void setMer_name(String mer_name) {
            this.mer_name = mer_name;
        }

        public String getAct_prov() {
            return act_prov;
        }

        public void setAct_prov(String act_prov) {
            this.act_prov = act_prov;
        }

        public String getAct_city() {
            return act_city;
        }

        public void setAct_city(String act_city) {
            this.act_city = act_city;
        }

        public String getAct_area() {
            return act_area;
        }

        public void setAct_area(String act_area) {
            this.act_area = act_area;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getSig_num() {
            return sig_num;
        }

        public void setSig_num(String sig_num) {
            this.sig_num = sig_num;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public String getBiaoqian() {
            return biaoqian;
        }

        public void setBiaoqian(String biaoqian) {
            this.biaoqian = biaoqian;
        }

        public String getCollection() {
            return collection;
        }

        public void setCollection(String collection) {
            this.collection = collection;
        }

        public List<String> getContent() {
            return content;
        }

        public void setContent(List<String> content) {
            this.content = content;
        }

        public List<String> getAct_time() {
            return act_time;
        }

        public void setAct_time(List<String> act_time) {
            this.act_time = act_time;
        }

        public List<String> getNewTime() {
            return newTime;
        }

        public void setNewTime(List<String> newTime) {
            this.newTime = newTime;
        }
    }
}
