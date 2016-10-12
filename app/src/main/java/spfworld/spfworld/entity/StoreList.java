package spfworld.spfworld.entity;

import java.util.List;

/**
 * Created by guozhengke on 2016/9/26.
 */
public class StoreList {


    /**
     * status : 200
     * message : 获取数据成功
     * data : [{"id":"25","name":"维卡莱林硬壳竞技竿包","pay":"0.00","price":"399.00","quantity":"","url":"http://e22a.com/h.0KgWdK?cv=AALzZybZ&sm=b5aa91","status":"0","activity_begin":"0000-00-00 00:00:00","activity_end":"0000-00-00 00:00:00","is_top":"0","images_url":"m.yundiaoke.cn"},{"id":"24","name":"维卡莱林玉行双面超薄子线盒","pay":"0.00","price":"59.00","quantity":"","url":"http://e22a.com/h.0K5DbG?cv=AALzYlGI&sm=a34937","status":"0","activity_begin":"0000-00-00 00:00:00","activity_end":"0000-00-00 00:00:00","is_top":"1","images_url":"m.yundiaoke.cn"},{"id":"23","name":"维卡莱林钓鱼服","pay":"0.00","price":"262.00","quantity":"","url":"http://e22a.com/h.0K5QrB?cv=AALzWqSB&sm=73f020","status":"0","activity_begin":"0000-00-00 00:00:00","activity_end":"0000-00-00 00:00:00","is_top":"1","images_url":"m.yundiaoke.cn"},{"id":"22","name":"光威赤刃碳素台钓竿","pay":"0.00","price":"89.00","quantity":"","url":"http://e22a.com/h.0KUWj5?cv=AALzRbVh&sm=e03bcc","status":"0","activity_begin":"0000-00-00 00:00:00","activity_end":"0000-00-00 00:00:00","is_top":"1","images_url":"m.yundiaoke.cn"},{"id":"21","name":"钓鱼王木制浮漂盒","pay":"0.00","price":"89.00","quantity":"","url":"http://e22a.com/h.0KX3Vq?cv=AALyiZtn&sm=a26090","status":"0","activity_begin":"0000-00-00 00:00:00","activity_end":"0000-00-00 00:00:00","is_top":"1","images_url":"m.yundiaoke.cn"},{"id":"20","name":"阿卢LPC01立式芦苇浮漂","pay":"0.00","price":"120.00","quantity":"","url":"http://e22a.com/h.0Kct0s?cv=AALyhKDZ&sm=b29ed1","status":"0","activity_begin":"0000-00-00 00:00:00","activity_end":"0000-00-00 00:00:00","is_top":"0","images_url":"m.yundiaoke.cn"},{"id":"19","name":"炫鲨万向超轻钓鱼伞","pay":"0.00","price":"285.00","quantity":"","url":"http://e22a.com/h.0Kci3w?cv=AALyfRTG&sm=28013b","status":"0","activity_begin":"0000-00-00 00:00:00","activity_end":"0000-00-00 00:00:00","is_top":"1","images_url":"m.yundiaoke.cn"},{"id":"18","name":"龙王恨蓝鲫X5","pay":"0.00","price":"6.00","quantity":"","url":"http://e22a.com/h.0K1dYK?cv=AALyZkWA&sm=ff3962","status":"0","activity_begin":"0000-00-00 00:00:00","activity_end":"0000-00-00 00:00:00","is_top":"0","images_url":"m.yundiaoke.cn"},{"id":"17","name":"老鬼2016版大野战九一八","pay":"0.00","price":"12.00","quantity":"","url":"http://e22a.com/h.0KYrRF?cv=AALyYDLz&sm=7cb82c","status":"0","activity_begin":"0000-00-00 00:00:00","activity_end":"0000-00-00 00:00:00","is_top":"1","images_url":"m.yundiaoke.cn"},{"id":"16","name":"钓鱼王疯钓鲫","pay":"0.00","price":"3.00","quantity":"","url":"http://e22a.com/h.0KYWyB?cv=AALyVoTQ&sm=73729b","status":"0","activity_begin":"0000-00-00 00:00:00","activity_end":"0000-00-00 00:00:00","is_top":"1","images_url":"m.yundiaoke.cn"}]
     */

    private int status;
    private String message;
    /**
     * id : 25
     * name : 维卡莱林硬壳竞技竿包
     * pay : 0.00
     * price : 399.00
     * quantity :
     * url : http://e22a.com/h.0KgWdK?cv=AALzZybZ&sm=b5aa91
     * status : 0
     * activity_begin : 0000-00-00 00:00:00
     * activity_end : 0000-00-00 00:00:00
     * is_top : 0
     * images_url : m.yundiaoke.cn
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
        private String name;
        private String pay;
        private String price;
        private String quantity;
        private String url;
        private String status;
        private String activity_begin;
        private String activity_end;
        private String is_top;
        private String images_url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPay() {
            return pay;
        }

        public void setPay(String pay) {
            this.pay = pay;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getActivity_begin() {
            return activity_begin;
        }

        public void setActivity_begin(String activity_begin) {
            this.activity_begin = activity_begin;
        }

        public String getActivity_end() {
            return activity_end;
        }

        public void setActivity_end(String activity_end) {
            this.activity_end = activity_end;
        }

        public String getIs_top() {
            return is_top;
        }

        public void setIs_top(String is_top) {
            this.is_top = is_top;
        }

        public String getImages_url() {
            return images_url;
        }

        public void setImages_url(String images_url) {
            this.images_url = images_url;
        }
    }
}
