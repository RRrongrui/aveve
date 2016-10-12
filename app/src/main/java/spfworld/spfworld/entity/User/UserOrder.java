package spfworld.spfworld.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/9/28.
 */
public class UserOrder {
    /**
     * status : 200
     * message : 获取数据成功
     * data : [{"order_id":"100","order_num":"2016092713041414793495","act_id":"4","act_theme":"第三方的所发生的","price":"1.00","num":"6","total_price":"6.00","act_address":"江西南昌西湖区八一大道888号","joindate":"周一2016-09-12","jointime":"14:58-14:58","create_time":"2016年09月27日 13:04:14","status":"0","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg"},{"order_id":"99","order_num":"2016092617312714776418","act_id":"4","act_theme":"第三方的所发生的","price":"0.00","num":"1","total_price":"0.00","act_address":"江西南昌西湖区八一大道888号","joindate":"周一2016-09-12","jointime":"14:58-14:58","create_time":"2016年09月26日 17:31:27","status":"1","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg"},{"order_id":"98","order_num":"2016092617232614742855","act_id":"4","act_theme":"第三方的所发生的","price":"0.00","num":"1","total_price":"0.00","act_address":"江西南昌西湖区八一大道888号","joindate":"周一2016-09-12","jointime":"14:58-14:58","create_time":"2016年09月26日 17:23:26","status":"1","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg"},{"order_id":"97","order_num":"2016092617215314746832","act_id":"7","act_theme":"的说法是电风扇","price":"0.00","num":"1","total_price":"0.00","act_address":"江西南昌西湖区八一大道888号","joindate":"周二2016-09-13","jointime":"15:00-15:30","create_time":"2016年09月26日 17:21:53","status":"1","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg"},{"order_id":"96","order_num":"2016092617203514724324","act_id":"3","act_theme":"的说法是电风扇","price":"0.00","num":"1","total_price":"0.00","act_address":"江西南昌西湖区八一大道888号","joindate":"周四2016-09-22","jointime":"22:30-00:00","create_time":"2016年09月26日 17:20:35","status":"1","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg"},{"order_id":"95","order_num":"2016092617182814731048","act_id":"4","act_theme":"第三方的所发生的","price":"0.00","num":"1","total_price":"0.00","act_address":"江西南昌西湖区八一大道888号","joindate":"周一2016-09-12","jointime":"14:58-14:58","create_time":"2016年09月26日 17:18:28","status":"1","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg"},{"order_id":"94","order_num":"2016092616540114718079","act_id":"4","act_theme":"第三方的所发生的","price":"0.00","num":"1","total_price":"0.00","act_address":"江西南昌西湖区八一大道888号","joindate":"周一2016-09-12","jointime":"14:58-14:58","create_time":"2016年09月26日 16:54:01","status":"0","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg"},{"order_id":"93","order_num":"2016092616331414721725","act_id":"4","act_theme":"第三方的所发生的","price":"0.00","num":"1","total_price":"0.00","act_address":"江西南昌西湖区八一大道888号","joindate":"周一2016-09-12","jointime":"14:58-14:58","create_time":"2016年09月26日 16:33:14","status":"0","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg"},{"order_id":"92","order_num":"2016092616311314731331","act_id":"3","act_theme":"的说法是电风扇","price":"0.00","num":"1","total_price":"0.00","act_address":"江西南昌西湖区八一大道888号","joindate":"周四2016-09-22","jointime":"22:30-00:00","create_time":"2016年09月26日 16:31:13","status":"0","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg"},{"order_id":"91","order_num":"2016092616300914746767","act_id":"6","act_theme":"多杀多少反倒是","price":"0.00","num":"1","total_price":"0.00","act_address":"江西南昌西湖区八一大道888号","joindate":"周一2016-09-12","jointime":"12:30-14:30","create_time":"2016年09月26日 16:30:09","status":"0","content":"m.yundiaoke.cn/Uploads/Ueditor/image/20160912/57d64708cbca8.jpg"}]
     */
    private int status;
    private String message;
    /**
     * order_id : 100
     * order_num : 2016092713041414793495
     * act_id : 4
     * act_theme : 第三方的所发生的
     * price : 1.00
     * num : 6
     * total_price : 6.00
     * act_address : 江西南昌西湖区八一大道888号
     * joindate : 周一2016-09-12
     * jointime : 14:58-14:58
     * create_time : 2016年09月27日 13:04:14
     * status : 0
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
