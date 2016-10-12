package spfworld.spfworld.entity;

import java.util.List;

/**
 * Created by guozhengke on 2016/9/1.
 */
public class weater {

    /**
     * reason : successed!
     * result : {"data":{"realtime":{"city_code":"101210701","city_name":"温州","date":"2016-09-01","time":"16:00:00","week":4,"moon":"八月初一","dataUptime":1472717841,"weather":{"temperature":"24","humidity":"82","info":"阵雨","img":"3"},"wind":{"direct":"北风","power":"0级","offset":null,"windspeed":null}},"life":{"date":"2016-9-1","info":{"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"],"ganmao":["少发","各项气象条件适宜，无明显降温过程，发生感冒机率较低。"],"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"wuran":["良","气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"]}},"weather":[{"date":"2016-09-01","info":{"day":["3","阵雨","29","南风","微风","05:36"],"night":["8","中雨","25","南风","微风","18:18"]},"week":"四","nongli":"八月初一"},{"date":"2016-09-02","info":{"dawn":["8","中雨","25","南风","微风","18:18"],"day":["3","阵雨","30","北风","微风","05:36"],"night":["2","阴","25","北风","微风","18:17"]},"week":"五","nongli":"八月初二"},{"date":"2016-09-03","info":{"dawn":["2","阴","25","北风","微风","18:17"],"day":["1","多云","32","北风","微风","05:37"],"night":["1","多云","25","东北风","微风","18:16"]},"week":"六","nongli":"八月初三"},{"date":"2016-09-04","info":{"dawn":["1","多云","25","东北风","微风","18:16"],"day":["3","阵雨","32","东北风","微风","05:37"],"night":["3","阵雨","26","东北风","微风","18:15"]},"week":"日","nongli":"八月初四"},{"date":"2016-09-05","info":{"dawn":["3","阵雨","26","东北风","微风","18:15"],"day":["3","阵雨","33","东北风","微风","05:38"],"night":["3","阵雨","26","东北风","微风","18:13"]},"week":"一","nongli":"八月初五"}],"pm25":{"key":"Wenzhou","show_desc":0,"pm25":{"curPm":"71","pm25":"50","pm10":"90","level":2,"quality":"良","des":"可以接受的，除极少数对某种污染物特别敏感的人以外，对公众健康没有危害。"},"dateTime":"2016年09月01日15时","cityName":"温州"},"jingqu":"","date":"","isForeign":"0"}}
     * error_code : 0
     */

    private String reason;
    /**
     * data : {"realtime":{"city_code":"101210701","city_name":"温州","date":"2016-09-01","time":"16:00:00","week":4,"moon":"八月初一","dataUptime":1472717841,"weather":{"temperature":"24","humidity":"82","info":"阵雨","img":"3"},"wind":{"direct":"北风","power":"0级","offset":null,"windspeed":null}},"life":{"date":"2016-9-1","info":{"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"],"ganmao":["少发","各项气象条件适宜，无明显降温过程，发生感冒机率较低。"],"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"wuran":["良","气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"]}},"weather":[{"date":"2016-09-01","info":{"day":["3","阵雨","29","南风","微风","05:36"],"night":["8","中雨","25","南风","微风","18:18"]},"week":"四","nongli":"八月初一"},{"date":"2016-09-02","info":{"dawn":["8","中雨","25","南风","微风","18:18"],"day":["3","阵雨","30","北风","微风","05:36"],"night":["2","阴","25","北风","微风","18:17"]},"week":"五","nongli":"八月初二"},{"date":"2016-09-03","info":{"dawn":["2","阴","25","北风","微风","18:17"],"day":["1","多云","32","北风","微风","05:37"],"night":["1","多云","25","东北风","微风","18:16"]},"week":"六","nongli":"八月初三"},{"date":"2016-09-04","info":{"dawn":["1","多云","25","东北风","微风","18:16"],"day":["3","阵雨","32","东北风","微风","05:37"],"night":["3","阵雨","26","东北风","微风","18:15"]},"week":"日","nongli":"八月初四"},{"date":"2016-09-05","info":{"dawn":["3","阵雨","26","东北风","微风","18:15"],"day":["3","阵雨","33","东北风","微风","05:38"],"night":["3","阵雨","26","东北风","微风","18:13"]},"week":"一","nongli":"八月初五"}],"pm25":{"key":"Wenzhou","show_desc":0,"pm25":{"curPm":"71","pm25":"50","pm10":"90","level":2,"quality":"良","des":"可以接受的，除极少数对某种污染物特别敏感的人以外，对公众健康没有危害。"},"dateTime":"2016年09月01日15时","cityName":"温州"},"jingqu":"","date":"","isForeign":"0"}
     */

    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * realtime : {"city_code":"101210701","city_name":"温州","date":"2016-09-01","time":"16:00:00","week":4,"moon":"八月初一","dataUptime":1472717841,"weather":{"temperature":"24","humidity":"82","info":"阵雨","img":"3"},"wind":{"direct":"北风","power":"0级","offset":null,"windspeed":null}}
         * life : {"date":"2016-9-1","info":{"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"],"ganmao":["少发","各项气象条件适宜，无明显降温过程，发生感冒机率较低。"],"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"wuran":["良","气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"]}}
         * weather : [{"date":"2016-09-01","info":{"day":["3","阵雨","29","南风","微风","05:36"],"night":["8","中雨","25","南风","微风","18:18"]},"week":"四","nongli":"八月初一"},{"date":"2016-09-02","info":{"dawn":["8","中雨","25","南风","微风","18:18"],"day":["3","阵雨","30","北风","微风","05:36"],"night":["2","阴","25","北风","微风","18:17"]},"week":"五","nongli":"八月初二"},{"date":"2016-09-03","info":{"dawn":["2","阴","25","北风","微风","18:17"],"day":["1","多云","32","北风","微风","05:37"],"night":["1","多云","25","东北风","微风","18:16"]},"week":"六","nongli":"八月初三"},{"date":"2016-09-04","info":{"dawn":["1","多云","25","东北风","微风","18:16"],"day":["3","阵雨","32","东北风","微风","05:37"],"night":["3","阵雨","26","东北风","微风","18:15"]},"week":"日","nongli":"八月初四"},{"date":"2016-09-05","info":{"dawn":["3","阵雨","26","东北风","微风","18:15"],"day":["3","阵雨","33","东北风","微风","05:38"],"night":["3","阵雨","26","东北风","微风","18:13"]},"week":"一","nongli":"八月初五"}]
         * pm25 : {"key":"Wenzhou","show_desc":0,"pm25":{"curPm":"71","pm25":"50","pm10":"90","level":2,"quality":"良","des":"可以接受的，除极少数对某种污染物特别敏感的人以外，对公众健康没有危害。"},"dateTime":"2016年09月01日15时","cityName":"温州"}
         * jingqu :
         * date :
         * isForeign : 0
         */

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * city_code : 101210701
             * city_name : 温州
             * date : 2016-09-01
             * time : 16:00:00
             * week : 4
             * moon : 八月初一
             * dataUptime : 1472717841
             * weather : {"temperature":"24","humidity":"82","info":"阵雨","img":"3"}
             * wind : {"direct":"北风","power":"0级","offset":null,"windspeed":null}
             */

            private RealtimeBean realtime;
            /**
             * date : 2016-9-1
             * info : {"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"],"ganmao":["少发","各项气象条件适宜，无明显降温过程，发生感冒机率较低。"],"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"wuran":["良","气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"]}
             */

            private LifeBean life;
            /**
             * key : Wenzhou
             * show_desc : 0
             * pm25 : {"curPm":"71","pm25":"50","pm10":"90","level":2,"quality":"良","des":"可以接受的，除极少数对某种污染物特别敏感的人以外，对公众健康没有危害。"}
             * dateTime : 2016年09月01日15时
             * cityName : 温州
             */

            private Pm25Bean pm25;
            private String jingqu;
            private String date;
            private String isForeign;
            /**
             * date : 2016-09-01
             * info : {"day":["3","阵雨","29","南风","微风","05:36"],"night":["8","中雨","25","南风","微风","18:18"]}
             * week : 四
             * nongli : 八月初一
             */

            private List<WeatherBean> weather;

            public RealtimeBean getRealtime() {
                return realtime;
            }

            public void setRealtime(RealtimeBean realtime) {
                this.realtime = realtime;
            }

            public LifeBean getLife() {
                return life;
            }

            public void setLife(LifeBean life) {
                this.life = life;
            }

            public Pm25Bean getPm25() {
                return pm25;
            }

            public void setPm25(Pm25Bean pm25) {
                this.pm25 = pm25;
            }

            public String getJingqu() {
                return jingqu;
            }

            public void setJingqu(String jingqu) {
                this.jingqu = jingqu;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getIsForeign() {
                return isForeign;
            }

            public void setIsForeign(String isForeign) {
                this.isForeign = isForeign;
            }

            public List<WeatherBean> getWeather() {
                return weather;
            }

            public void setWeather(List<WeatherBean> weather) {
                this.weather = weather;
            }

            public static class RealtimeBean {
                private String city_code;
                private String city_name;
                private String date;
                private String time;
                private int week;
                private String moon;
                private int dataUptime;
                /**
                 * temperature : 24
                 * humidity : 82
                 * info : 阵雨
                 * img : 3
                 */

                private WeatherBean weather;
                /**
                 * direct : 北风
                 * power : 0级
                 * offset : null
                 * windspeed : null
                 */

                private WindBean wind;

                public String getCity_code() {
                    return city_code;
                }

                public void setCity_code(String city_code) {
                    this.city_code = city_code;
                }

                public String getCity_name() {
                    return city_name;
                }

                public void setCity_name(String city_name) {
                    this.city_name = city_name;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public int getWeek() {
                    return week;
                }

                public void setWeek(int week) {
                    this.week = week;
                }

                public String getMoon() {
                    return moon;
                }

                public void setMoon(String moon) {
                    this.moon = moon;
                }

                public int getDataUptime() {
                    return dataUptime;
                }

                public void setDataUptime(int dataUptime) {
                    this.dataUptime = dataUptime;
                }

                public WeatherBean getWeather() {
                    return weather;
                }

                public void setWeather(WeatherBean weather) {
                    this.weather = weather;
                }

                public WindBean getWind() {
                    return wind;
                }

                public void setWind(WindBean wind) {
                    this.wind = wind;
                }

                public static class WeatherBean {
                    private String temperature;
                    private String humidity;
                    private String info;
                    private String img;

                    public String getTemperature() {
                        return temperature;
                    }

                    public void setTemperature(String temperature) {
                        this.temperature = temperature;
                    }

                    public String getHumidity() {
                        return humidity;
                    }

                    public void setHumidity(String humidity) {
                        this.humidity = humidity;
                    }

                    public String getInfo() {
                        return info;
                    }

                    public void setInfo(String info) {
                        this.info = info;
                    }

                    public String getImg() {
                        return img;
                    }

                    public void setImg(String img) {
                        this.img = img;
                    }
                }

                public static class WindBean {
                    private String direct;
                    private String power;
                    private Object offset;
                    private Object windspeed;

                    public String getDirect() {
                        return direct;
                    }

                    public void setDirect(String direct) {
                        this.direct = direct;
                    }

                    public String getPower() {
                        return power;
                    }

                    public void setPower(String power) {
                        this.power = power;
                    }

                    public Object getOffset() {
                        return offset;
                    }

                    public void setOffset(Object offset) {
                        this.offset = offset;
                    }

                    public Object getWindspeed() {
                        return windspeed;
                    }

                    public void setWindspeed(Object windspeed) {
                        this.windspeed = windspeed;
                    }
                }
            }

            public static class LifeBean {
                private String date;
                private InfoBean info;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public InfoBean getInfo() {
                    return info;
                }

                public void setInfo(InfoBean info) {
                    this.info = info;
                }

                public static class InfoBean {
                    private List<String> chuanyi;
                    private List<String> ganmao;
                    private List<String> kongtiao;
                    private List<String> wuran;
                    private List<String> xiche;
                    private List<String> yundong;
                    private List<String> ziwaixian;

                    public List<String> getChuanyi() {
                        return chuanyi;
                    }

                    public void setChuanyi(List<String> chuanyi) {
                        this.chuanyi = chuanyi;
                    }

                    public List<String> getGanmao() {
                        return ganmao;
                    }

                    public void setGanmao(List<String> ganmao) {
                        this.ganmao = ganmao;
                    }

                    public List<String> getKongtiao() {
                        return kongtiao;
                    }

                    public void setKongtiao(List<String> kongtiao) {
                        this.kongtiao = kongtiao;
                    }

                    public List<String> getWuran() {
                        return wuran;
                    }

                    public void setWuran(List<String> wuran) {
                        this.wuran = wuran;
                    }

                    public List<String> getXiche() {
                        return xiche;
                    }

                    public void setXiche(List<String> xiche) {
                        this.xiche = xiche;
                    }

                    public List<String> getYundong() {
                        return yundong;
                    }

                    public void setYundong(List<String> yundong) {
                        this.yundong = yundong;
                    }

                    public List<String> getZiwaixian() {
                        return ziwaixian;
                    }

                    public void setZiwaixian(List<String> ziwaixian) {
                        this.ziwaixian = ziwaixian;
                    }
                }
            }

            public static class Pm25Bean {
                private String key;
                private int show_desc;
                /**
                 * curPm : 71
                 * pm25 : 50
                 * pm10 : 90
                 * level : 2
                 * quality : 良
                 * des : 可以接受的，除极少数对某种污染物特别敏感的人以外，对公众健康没有危害。
                 */

                private Pm25bean pm25;
                private String dateTime;
                private String cityName;

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public int getShow_desc() {
                    return show_desc;
                }

                public void setShow_desc(int show_desc) {
                    this.show_desc = show_desc;
                }

                public Pm25bean getPm25() {
                    return pm25;
                }

                public void setPm25(Pm25bean pm25) {
                    this.pm25 = pm25;
                }

                public String getDateTime() {
                    return dateTime;
                }

                public void setDateTime(String dateTime) {
                    this.dateTime = dateTime;
                }

                public String getCityName() {
                    return cityName;
                }

                public void setCityName(String cityName) {
                    this.cityName = cityName;
                }

                public static class Pm25bean {
                    private String curPm;
                    private String pm25;
                    private String pm10;
                    private int level;
                    private String quality;
                    private String des;

                    public String getCurPm() {
                        return curPm;
                    }

                    public void setCurPm(String curPm) {
                        this.curPm = curPm;
                    }

                    public String getPm25() {
                        return pm25;
                    }

                    public void setPm25(String pm25) {
                        this.pm25 = pm25;
                    }

                    public String getPm10() {
                        return pm10;
                    }

                    public void setPm10(String pm10) {
                        this.pm10 = pm10;
                    }

                    public int getLevel() {
                        return level;
                    }

                    public void setLevel(int level) {
                        this.level = level;
                    }

                    public String getQuality() {
                        return quality;
                    }

                    public void setQuality(String quality) {
                        this.quality = quality;
                    }

                    public String getDes() {
                        return des;
                    }

                    public void setDes(String des) {
                        this.des = des;
                    }
                }
            }

            public static class WeatherBean {
                private String date;
                private InfoBean info;
                private String week;
                private String nongli;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public InfoBean getInfo() {
                    return info;
                }

                public void setInfo(InfoBean info) {
                    this.info = info;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getNongli() {
                    return nongli;
                }

                public void setNongli(String nongli) {
                    this.nongli = nongli;
                }

                public static class InfoBean {
                    private List<String> day;
                    private List<String> night;

                    public List<String> getDay() {
                        return day;
                    }

                    public void setDay(List<String> day) {
                        this.day = day;
                    }

                    public List<String> getNight() {
                        return night;
                    }

                    public void setNight(List<String> night) {
                        this.night = night;
                    }
                }
            }
        }
    }
}
