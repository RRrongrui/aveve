package spfworld.spfworld.entity;

import java.util.List;

/**
 * Created by guozhengke on 2016/9/26.
 * 商品详情页实体类
 */
public class StoreDetail {


    /**
     * status : 200
     * message : 获取数据成功
     * data : [{"id":"1","name":"神器啊哈哈哈哈","pay":"999.00","price":"666.00","url":"https://detail.tmall.com/item.htm?id=41251836123&ali_refid=a3_430583_1006:1106075910:N:%E9%92%93%E9%B1%BC:5210472af952388e195a5b6c27c08dd7&ali_trackid=1_5210472af952388e195a5b6c27c08dd7&spm=a230r.1.14.1.xymV3Z","status":"0","activity_begin":"0000-00-00 00:00:00","activity_end":"0000-00-00 00:00:00","is_top":"0","content":"<p>气温气温<\/p><p><img src=\"/Uploads/Ueditor/image/20160914/57d8fe53602e4.jpg\" style=\"\"/><\/p><p><img src=\"/Uploads/Ueditor/image/20160914/57d8fd715c2bc.jpg\" style=\"\"/><\/p><p><br/><\/p>","images_url":null,"collection":"0"}]
     */

    private int status;
    private String message;
    /**
     * id : 1
     * name : 神器啊哈哈哈哈
     * pay : 999.00
     * price : 666.00
     * url : https://detail.tmall.com/item.htm?id=41251836123&ali_refid=a3_430583_1006:1106075910:N:%E9%92%93%E9%B1%BC:5210472af952388e195a5b6c27c08dd7&ali_trackid=1_5210472af952388e195a5b6c27c08dd7&spm=a230r.1.14.1.xymV3Z
     * status : 0
     * activity_begin : 0000-00-00 00:00:00
     * activity_end : 0000-00-00 00:00:00
     * is_top : 0
     * content : <p>气温气温</p><p><img src="/Uploads/Ueditor/image/20160914/57d8fe53602e4.jpg" style=""/></p><p><img src="/Uploads/Ueditor/image/20160914/57d8fd715c2bc.jpg" style=""/></p><p><br/></p>
     * images_url : null
     * collection : 0
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
        private String url;
        private String status;
        private String activity_begin;
        private String activity_end;
        private String is_top;
        private String content;
        private List<String> images_url;
        private String collection;

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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<String> getImages_url() {
            return images_url;
        }

        public void setImages_url(List<String> images_url) {
            this.images_url = (List<String>) images_url;
        }

        public String getCollection() {
            return collection;
        }

        public void setCollection(String collection) {
            this.collection = collection;
        }
    }
}
