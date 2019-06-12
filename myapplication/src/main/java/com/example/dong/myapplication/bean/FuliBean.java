package com.example.dong.myapplication.bean;

import java.util.List;

public class FuliBean {

    /**
     * error : false
     * results : [{"_id":"56cc6d1d421aa95caa7076e5","createdAt":"2015-06-30T02:09:26.186Z","desc":"6.30","publishedAt":"2015-07-02T03:50:48.82Z","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bgw1etlw75so1hj20qo0hsgpk.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa707862","createdAt":"2015-09-08T01:13:23.791Z","desc":"9.8","publishedAt":"2015-09-08T03:52:03.338Z","type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bgw1evuryc3xumj20qo0hr41d.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d22421aa95caa707935","createdAt":"2015-10-16T03:12:44.667Z","desc":"10.16","publishedAt":"2015-10-16T03:29:59.7Z","type":"福利","url":"http://ww4.sinaimg.cn/large/7a8aed7bjw1ex2sycyh7gj20go0o474w.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa7076eb","createdAt":"2015-07-09T01:49:34.571Z","desc":"7.9","publishedAt":"2015-07-09T04:28:25.196Z","type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bgw1etwa7ayf35j20j60csmzb.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d26421aa95caa70805e","createdAt":"2015-12-23T01:11:02.367Z","desc":"12.23","publishedAt":"2015-12-23T03:52:41.878Z","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bjw1ez9bkpuvipj20dw0kutb9.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa707692","createdAt":"2015-06-12T01:31:07.31Z","desc":"6.12","publishedAt":"2015-06-12T03:48:54.790Z","type":"福利","url":"http://ww4.sinaimg.cn/large/7a8aed7bgw1et11xp5wwij20hs0qotb2.jpg","used":true,"who":"张涵宇"},{"_id":"596ea620421aa90c9203d3bc","createdAt":"2017-07-19T08:21:52.67Z","desc":"7-19","publishedAt":"2017-07-19T13:23:20.375Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fhovjwwphfj20u00u04qp.jpg","used":true,"who":"代码家"},{"_id":"5be14edb9d21223dd50660f8","createdAt":"2018-11-06T08:20:43.656Z","desc":"2018-11-06","publishedAt":"2018-11-06T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fwyf0wr8hhj30ie0nhq6p.jpg","used":true,"who":"lijinshanmx"},{"_id":"58eef016421aa9544b773fd0","createdAt":"2017-04-13T11:27:18.557Z","desc":"4-13","publishedAt":"2017-04-13T11:36:04.435Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-13-17882785_926451654163513_7725522121023029248_n.jpg","used":true,"who":"dmj"},{"_id":"570dc90b6776590f5a0ecbb6","createdAt":"2016-04-13T12:20:27.707Z","desc":"4.13","publishedAt":"2016-04-13T13:49:02.190Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1f2uyg3nvq7j20gy0p6myx.jpg","used":true,"who":"代码家"},{"_id":"56cc6d22421aa95caa707947","createdAt":"2015-10-19T01:26:51.154Z","desc":"10.19","publishedAt":"2015-10-19T03:47:21.647Z","type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bgw1ex66r1sk5wj20et0m8q4q.jpg","used":true,"who":"张涵宇"},{"_id":"584dffdd421aa963eaaee172","createdAt":"2016-12-12T09:39:41.294Z","desc":"12-12","publishedAt":"2016-12-12T11:30:54.254Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1fanrdyaxi6j20u00k1ta9.jpg","used":true,"who":"daimajia"},{"_id":"5b15ec20421aa97e45f15aae","createdAt":"2018-06-05T09:49:20.355Z","desc":"2018-06-05","publishedAt":"2018-06-05T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fs02a9b0nvj30sg10vk4z.jpg","used":true,"who":"lijinshanmx"},{"_id":"5aff4645421aa95f55cab5e7","createdAt":"2018-05-15T00:00:00.0Z","desc":"2018-05-15","publishedAt":"2018-05-15T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1frepqtwifwj30no0ti47n.jpg","used":true,"who":"lijinshanmx"},{"_id":"58d08621421aa95810795ca1","createdAt":"2017-03-21T09:47:13.3Z","desc":"3-21","publishedAt":"2017-03-21T12:19:46.895Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-21-17268102_763630507137257_3620762734536163328_n%20-1-.jpg","used":true,"who":"dmj"},{"_id":"56cc6d29421aa95caa7082cd","createdAt":"2016-02-01T13:47:21.517Z","desc":"2.5","publishedAt":"2016-02-17T04:47:21.644Z","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bgw1f0k67zz05jj20ku0rs0y1.jpg","used":true,"who":"张涵宇"},{"_id":"58cb5f88421aa95810795c80","createdAt":"2017-03-17T12:01:12.88Z","desc":"3-17","publishedAt":"2017-03-17T12:07:03.767Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-17-17332809_1277469728986540_3201752429582352384_n.jpg","used":true,"who":"dmj"},{"_id":"56d3c506421aa93cbc97e25c","createdAt":"2016-02-29T12:11:50.467Z","desc":"2.29-1","publishedAt":"2016-02-29T12:19:00.15Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bjw1f1g2xpx9ehj20ez0mi0vc.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa7078dd","createdAt":"2015-09-27T02:56:10.556Z","desc":"9.30","publishedAt":"2015-09-28T04:00:17.821Z","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bgw1ewgtp8kircj20ht0qodj0.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d22421aa95caa7078fa","createdAt":"2015-10-07T05:43:57.811Z","desc":"10.9","publishedAt":"2015-10-10T03:58:17.761Z","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034gw1ewvwd9zzrjj20hs0qon02.jpg","used":true,"who":"张涵宇"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 56cc6d1d421aa95caa7076e5
         * createdAt : 2015-06-30T02:09:26.186Z
         * desc : 6.30
         * publishedAt : 2015-07-02T03:50:48.82Z
         * type : 福利
         * url : http://ww3.sinaimg.cn/large/7a8aed7bgw1etlw75so1hj20qo0hsgpk.jpg
         * used : true
         * who : 张涵宇
         * source : chrome
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private String source;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }
}
