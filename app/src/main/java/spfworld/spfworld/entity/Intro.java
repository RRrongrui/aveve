package spfworld.spfworld.entity;

/**
 * Created by guozhengke on 2016/9/19.
 */
public class Intro {

    /**
     * status : 200
     * message : 获取数据成功
     * data : {"content":"<p>阿斯顿撒旦阿萨德<\/p><p><br/><\/p><p><img src=\"/Uploads/Ueditor/image/20160914/57d8fd1fa3919.jpg\" style=\"\" title=\"57d8fd1fa3919.jpg\"/><\/p><p><img src=\"/Uploads/Ueditor/image/20160914/57d8fd1fa66da.jpg\" style=\"\" title=\"57d8fd1fa66da.jpg\"/><\/p><p>撒打算打算<\/p>"}
     */

    private int status;
    private String message;
    /**
     * content : <p>阿斯顿撒旦阿萨德</p><p><br/></p><p><img src="/Uploads/Ueditor/image/20160914/57d8fd1fa3919.jpg" style="" title="57d8fd1fa3919.jpg"/></p><p><img src="/Uploads/Ueditor/image/20160914/57d8fd1fa66da.jpg" style="" title="57d8fd1fa66da.jpg"/></p><p>撒打算打算</p>
     */

    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
