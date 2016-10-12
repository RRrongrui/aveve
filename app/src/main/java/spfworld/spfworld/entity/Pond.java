package spfworld.spfworld.entity;

import java.util.List;

/**
 * Created by guozhengke on 2016/9/7.
 */
public class Pond {

    /**
     * status : 200
     * message : 获取数据成功
     * data : [{"pon_id":"6","theme":"adsadasdasdas","price":"200/小时","lng":"121.311100","lat":"31.200300","status":"3","big_img":"/Uploads/Uploads/Pond/1476233585_6209.jpeg","juli":10.17},{"pon_id":"8","theme":"这是神器","price":"100/天","lng":"116.007479","lat":"29.695240","status":"4","big_img":"","juli":586.44},{"pon_id":"7","theme":"的说法是电风扇","price":"22","lng":"115.906716","lat":"28.665549","status":"0","big_img":"","juli":606.84},{"pon_id":"9","theme":"的说法是电风扇","price":"22","lng":"115.906716","lat":"28.665549","status":"0","big_img":"/Uploads/Uploads/Pond/1476178708_6120.jpg","juli":606.84},{"pon_id":"10","theme":"这是神器","price":"666","lng":"115.906716","lat":"28.665549","status":"1","big_img":"","juli":606.84},{"pon_id":"11","theme":"这是神器","price":"120","lng":"115.906716","lat":"28.665549","status":"3","big_img":"/Uploads/Uploads/Pond/1476236163_7256.jpg","juli":606.84},{"pon_id":"12","theme":"这是神器","price":"666","lng":"115.906716","lat":"28.665549","status":"1","big_img":"/Uploads/Uploads/Pond/1476238114_3242.jpg","juli":606.84}]
     */

    private int status;
    private String message;
    /**
     * pon_id : 6
     * theme : adsadasdasdas
     * price : 200/小时
     * lng : 121.311100
     * lat : 31.200300
     * status : 3
     * big_img : /Uploads/Uploads/Pond/1476233585_6209.jpeg
     * juli : 10.17
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
        private String lng;
        private String lat;
        private String status;
        private String big_img;
        private double juli;

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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getBig_img() {
            return big_img;
        }

        public void setBig_img(String big_img) {
            this.big_img = big_img;
        }

        public double getJuli() {
            return juli;
        }

        public void setJuli(double juli) {
            this.juli = juli;
        }
    }
}
