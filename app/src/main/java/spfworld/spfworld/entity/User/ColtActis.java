package spfworld.spfworld.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9.
 */
public class ColtActis {

    /**
     * status : 200
     * message : 获取数据成功
     * data : [{"id":"39","pid":"2","userid":"8","is_del":"0","act_id":"2","theme":"民间钓鱼大赛节","begin_time":"1473004800","end_time":"1475424000","act_prov":"上海","act_city":"闵行区","act_area":"","address":"泰虹路268号","limit_num":"100","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160930/57ee20ee55e71.jpg","biaoqian":"0"},{"id":"37","pid":"6","userid":"8","is_del":"0","act_id":"6","theme":"国庆自驾游露营野钓大赛节","begin_time":"1473609600","end_time":"1475856000","act_prov":"江西","act_city":"南昌","act_area":"西湖区","address":"八一大道888号","limit_num":"11","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160930/57ede70cbd747.jpg","biaoqian":"0"},{"id":"35","pid":"3","userid":"8","is_del":"0","act_id":"3","theme":"野钓露营大赛","begin_time":"1474473600","end_time":"1477756800","act_prov":"江西","act_city":"南昌","act_area":"西湖区","address":"八一大道888号","limit_num":"100","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160930/57ede7d56b0bf.png","biaoqian":"2"}]
     */

    private int status;
    private String message;
    /**
     * id : 39
     * pid : 2
     * userid : 8
     * is_del : 0
     * act_id : 2
     * theme : 民间钓鱼大赛节
     * begin_time : 1473004800
     * end_time : 1475424000
     * act_prov : 上海
     * act_city : 闵行区
     * act_area :
     * address : 泰虹路268号
     * limit_num : 100
     * content : m.yundiaoke.cn/Uploads/Ueditor/image/20160930/57ee20ee55e71.jpg
     * biaoqian : 0
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
        private String act_id;
        private String theme;
        private String begin_time;
        private String end_time;
        private String act_prov;
        private String act_city;
        private String act_area;
        private String address;
        private String limit_num;
        private String content;
        private String biaoqian;

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

        public String getLimit_num() {
            return limit_num;
        }

        public void setLimit_num(String limit_num) {
            this.limit_num = limit_num;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getBiaoqian() {
            return biaoqian;
        }

        public void setBiaoqian(String biaoqian) {
            this.biaoqian = biaoqian;
        }
    }
}
