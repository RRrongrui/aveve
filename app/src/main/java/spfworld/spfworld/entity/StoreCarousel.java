package spfworld.spfworld.entity;

import java.util.List;

/**
 * Created by guozhengke on 2016/9/27.
 * 商城主页轮播实体类
 */
public class StoreCarousel {

    /**
     * status : 200
     * message : 获取数据成功
     * data : [{"id":"11","name":"zassasaas","url":"sa","images_url":"m.yundiaoke.cn/Uploads/Uploads/Goods/57df6574f14f9.jpg"},{"id":"10","name":"vxvxxvssssss","url":"http://e22a.com/h.0M6Ixg?cv=AALhBrUT&sm=a8e1b2","images_url":"m.yundiaoke.cn/Uploads/Uploads/Goods/57de0a811c6ca.jpg"},{"id":"9","name":"鱼竿","url":"https://item.taobao.com/item.htm?spm=a230r.1.14.305.xymV3Z&id=38158283453&ns=1&abbucket=16#detail","images_url":"m.yundiaoke.cn/Uploads/Uploads/Goods/57de0a811c6ca.jpg"}]
     */

    private int status;
    private String message;
    /**
     * id : 11
     * name : zassasaas
     * url : sa
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
        private String url;
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImages_url() {
            return images_url;
        }

        public void setImages_url(String images_url) {
            this.images_url = images_url;
        }
    }
}
