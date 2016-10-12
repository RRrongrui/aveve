package spfworld.spfworld.entity;

import java.util.List;

/**
 * Created by guozhengke on 2016/9/27.
 * 推荐实体类
 */
public class StoreRecommend {

    /**
     * status : 200
     * message : 获取数据成功
     * data : [{"id":"10","name":"vxvxxvssssss","is_top":"2","images_url":"m.yundiaoke.cn/Uploads/Uploads/Goods/57de0a811c6ca.jpg"}]
     */

    private int status;
    private String message;
    /**
     * id : 10
     * name : vxvxxvssssss
     * is_top : 2
     * images_url : m.yundiaoke.cn/Uploads/Uploads/Goods/57de0a811c6ca.jpg
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
