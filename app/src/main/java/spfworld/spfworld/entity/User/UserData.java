package spfworld.spfworld.entity.User;

/**
 * Created by Administrator on 2016/9/27.
 */
public class UserData {

    /**
     * status : 200
     * message : 获取用户信息成功
     * data : {"headpic":"m.yundiaoke.cn/Uploads/Notepic/201609131715272notepic.png","nickname":"wzp","sex":"0","birthday":"0000-00-00","prov":"","city":"","area":"","signature":""}
     */

    private int status;
    private String message;
    /**
     * headpic : m.yundiaoke.cn/Uploads/Notepic/201609131715272notepic.png
     * nickname : wzp
     * sex : 0
     * birthday : 0000-00-00
     * prov :
     * city :
     * area :
     * signature :
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
        private String headpic;
        private String nickname;
        private String sex;
        private String birthday;
        private String prov;
        private String city;
        private String area;
        private String signature;

        public String getHeadpic() {
            return headpic;
        }

        public void setHeadpic(String headpic) {
            this.headpic = headpic;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
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

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }
    }
}
