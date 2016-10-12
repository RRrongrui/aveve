package spfworld.spfworld.entity;

import java.util.List;

/**
 * Created by guozhengke on 2016/9/26.
 */
public class IndentDetail {

    /**
     * status : 200
     * message : 获取数据成功
     * data : [{"order_id":"42","order_num":"2016092612153014733704","act_id":"2","act_theme":"aaaa","price":"1.00","num":"1","total_price":"1.00","appmobile":"15821581768","act_address":"上海闵行区泰虹路268号","joindate":"周二2016-09-06","jointime":"10:00-16:30","create_time":"2016年09月26日 12:15:30","status":"1","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg"}]
     */

    private int status;
    private String message;
    /**
     * order_id : 42
     * order_num : 2016092612153014733704
     * act_id : 2
     * act_theme : aaaa
     * price : 1.00
     * num : 1
     * total_price : 1.00
     * appmobile : 15821581768
     * act_address : 上海闵行区泰虹路268号
     * joindate : 周二2016-09-06
     * jointime : 10:00-16:30
     * create_time : 2016年09月26日 12:15:30
     * status : 1
     * content : m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg
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
        private String order_id;
        private String order_num;
        private String act_id;
        private String act_theme;
        private String price;
        private String num;
        private String total_price;
        private String appmobile;
        private String act_address;
        private String joindate;
        private String jointime;
        private String create_time;
        private String status;
        private String content;

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getOrder_num() {
            return order_num;
        }

        public void setOrder_num(String order_num) {
            this.order_num = order_num;
        }

        public String getAct_id() {
            return act_id;
        }

        public void setAct_id(String act_id) {
            this.act_id = act_id;
        }

        public String getAct_theme() {
            return act_theme;
        }

        public void setAct_theme(String act_theme) {
            this.act_theme = act_theme;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getTotal_price() {
            return total_price;
        }

        public void setTotal_price(String total_price) {
            this.total_price = total_price;
        }

        public String getAppmobile() {
            return appmobile;
        }

        public void setAppmobile(String appmobile) {
            this.appmobile = appmobile;
        }

        public String getAct_address() {
            return act_address;
        }

        public void setAct_address(String act_address) {
            this.act_address = act_address;
        }

        public String getJoindate() {
            return joindate;
        }

        public void setJoindate(String joindate) {
            this.joindate = joindate;
        }

        public String getJointime() {
            return jointime;
        }

        public void setJointime(String jointime) {
            this.jointime = jointime;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
