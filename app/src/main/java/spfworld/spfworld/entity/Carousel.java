package spfworld.spfworld.entity;

import java.util.List;

/**
 * Created by guozhengke on 2016/9/27.
 */
public class Carousel {
    /**
     * status : 200
     * message : 数据获取成功
     * data : [{"id":"5","img":"m.yundiaoke.cn/Uploads/Uploads/Pond_carousel/57ea05e3d4e03.jpg","url":"baidu.com"},{"id":"4","img":"m.yundiaoke.cn/Uploads/Uploads/Pond_carousel/57ea05cded5f9.jpg","url":"www.baidu.com"},{"id":"3","img":"m.yundiaoke.cn/Uploads/Uploads/Pond_carousel/57ea05c47871c.jpg","url":"www.baidu.com"}]
     */

    private int status;
    private String message;
    /**
     * id : 5
     * img : m.yundiaoke.cn/Uploads/Uploads/Pond_carousel/57ea05e3d4e03.jpg
     * url : baidu.com
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
        private String img;
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
