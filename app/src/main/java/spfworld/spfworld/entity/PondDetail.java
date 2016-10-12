package spfworld.spfworld.entity;

import java.util.List;

/**
 * Created by guozhengke on 2016/9/8.
 */
public class PondDetail {

    /**
     * status : 200
     * message : 获取数据成功
     * data : [{"pon_id":"1","theme":"雷公湖gfff","price":"100.00","prov":"上海","city":"松江区","area":"","address":"漕河泾开发区","lng":"121.395334","lat":"31.160489","phone":"15888992318","content":[],"type":["2"],"status":"5","num":"0","charge":"0"}]
     */

    private int status;
    private String message;
    /**
     * pon_id : 1
     * theme : 雷公湖gfff
     * price : 100.00
     * prov : 上海
     * city : 松江区
     * area :
     * address : 漕河泾开发区
     * lng : 121.395334
     * lat : 31.160489
     * phone : 15888992318
     * content : []
     * type : ["2"]
     * status : 5
     * num : 0
     * charge : 0
     * collection:0
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
        private String pon_id;
        private String theme;
        private String price;
        private String prov;
        private String city;
        private String area;
        private String address;
        private String lng;
        private String lat;
        private String phone;
        private String status;
        private String num;
        private String charge;
        private List<?> content;
        private List<String> type;
        private String collection;

        public String getCollection() {
            return collection;
        }

        public void setCollection(String collection) {
            this.collection = collection;
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

        public String getProv() {
            return prov;
        }

        public void setProv(String prov) {
            this.prov = prov;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getCharge() {
            return charge;
        }

        public void setCharge(String charge) {
            this.charge = charge;
        }

        public List<String> getContent() {
            return (List<String>) content;
        }

        public void setContent(List<String> content) {
            this.content = content;
        }

        public List<String> getType() {
            return type;
        }

        public void setType(List<String> type) {
            this.type = type;
        }
    }
}
