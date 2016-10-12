package spfworld.spfworld.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/9/29.
 */
public class ColtFond {

    /**
     * status : 200
     * message : 获取数据成功
     * data : [{"id":"34","pid":"7865","userid":"8","is_del":"1","pon_id":"7865","theme":"高山水库","price":"0.00","content":"m.yundiaoke.cn","status":"0","charge":"0","address":"重庆市永川区三教镇高山水库"},{"id":"33","pid":"7864","userid":"8","is_del":"1","pon_id":"7864","theme":"鱼背山水库","price":"0.00","content":"m.yundiaoke.cn","status":"0","charge":"0","address":"重庆市万州区走马镇鱼背山水库"},{"id":"31","pid":"7861","userid":"8","is_del":"1","pon_id":"7861","theme":"子童纯天然养鱼场","price":"0.00","content":"m.yundiaoke.cn","status":"0","charge":"0","address":"重庆市潼南县崇龛镇白沙村村口"},{"id":"30","pid":"7862","userid":"8","is_del":"1","pon_id":"7862","theme":"大滩口水库","price":"0.00","content":"m.yundiaoke.cn","status":"2","charge":"0","address":"重庆市万州区大滩口水库"}]
     */

    private int status;
    private String message;
    /**
     * id : 34
     * pid : 7865
     * userid : 8
     * is_del : 1
     * pon_id : 7865
     * theme : 高山水库
     * price : 0.00
     * content : m.yundiaoke.cn
     * status : 0
     * charge : 0
     * address : 重庆市永川区三教镇高山水库
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
        private String pon_id;
        private String theme;
        private String price;
        private String content;
        private String status;
        private String charge;
        private String address;

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

        public String getPon_id() {
            return pon_id;
        }

        public void setPon_id(String pon_id) {
            this.pon_id = pon_id;
        }

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCharge() {
            return charge;
        }

        public void setCharge(String charge) {
            this.charge = charge;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
