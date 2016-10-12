package spfworld.spfworld.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9.
 */
public class ColtComm {

    /**
     * status : 200
     * message : 获取数据成功
     * data : [{"id":"38","pid":"38","userid":"8","is_del":"0","name":"西部风老坛五谷杂粮窝料","price":"10.00","is_top":"1","images_url":"m.yundiaoke.cn/Uploads/Uploads/Goods/1475899891_4026.jpg"},{"id":"13","pid":"13","userid":"8","is_del":"0","name":"宝飞龙银龙鲤二代","price":"808.00","is_top":"1","images_url":"m.yundiaoke.cn/Uploads/Uploads/Goods/1475218010_9835.jpg"},{"id":null,"pid":"9","userid":"8","is_del":null,"name":null,"price":null,"is_top":null,"images_url":"m.yundiaoke.cn"},{"id":"10","pid":"10","userid":"8","is_del":"0","name":"鱼竿鱼钩","price":"1.00","is_top":"2","images_url":"m.yundiaoke.cn/Uploads/Uploads/Goods/57de0a811c6ca.jpg"}]
     */

    private int status;
    private String message;
    /**
     * id : 38
     * pid : 38
     * userid : 8
     * is_del : 0
     * name : 西部风老坛五谷杂粮窝料
     * price : 10.00
     * is_top : 1
     * images_url : m.yundiaoke.cn/Uploads/Uploads/Goods/1475899891_4026.jpg
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
        private String name;
        private String price;
        private String is_top;
        private String images_url;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
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
