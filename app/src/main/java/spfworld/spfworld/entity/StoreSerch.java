package spfworld.spfworld.entity;

import java.util.List;

/**
 * Created by guozhengke on 2016/9/27.
 * 商品搜索实体类
 */
public class StoreSerch {
    /**
     * status : 200
     * message : 获取数据成功
     * data : [{"id":"11","name":"zassasaas","pay":"0.00","price":"0.00","quantity":"saas","url":"sa","status":"0","activity_begin":"2016-09-30 00:00:00","activity_end":"2016-10-02 00:00:00","is_top":"3","images_url":"m.yundiaoke.cn/Uploads/Uploads/Goods/57df6574f14f9.jpg"}]
     */

    private int status;
    private String message;
    /**
     * id : 11
     * name : zassasaas
     * pay : 0.00
     * price : 0.00
     * quantity : saas
     * url : sa
     * status : 0
     * activity_begin : 2016-09-30 00:00:00
     * activity_end : 2016-10-02 00:00:00
     * is_top : 3
     * images_url : m.yundiaoke.cn/Uploads/Uploads/Goods/57df6574f14f9.jpg
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
