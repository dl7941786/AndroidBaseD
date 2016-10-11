package com.qianfeng.mydriversdemo.bean;

//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖镇楼                  BUG辟易  
//          佛曰:  
//                  写字楼里写字间，写字间里程序员；  
//                  程序人员写程序，又拿程序换酒钱。  
//                  酒醒只在网上坐，酒醉还来网下眠；  
//                  酒醉酒醒日复日，网上网下年复年。  
//                  但愿老死电脑间，不愿鞠躬老板前；  
//                  奔驰宝马贵者趣，公交自行程序员。  
//                  别人笑我忒疯癫，我笑自己命太贱；  
//                  不见满街漂亮妹，哪个归得程序员？  

import java.util.List;

/**
 * Created by jackiechan on 16/8/25.
 */
public class RecommentBean {

    /**
     * code : 1
     * msg : success
     * data : {"news":[{"article_id":496729,"title":"八达岭动物园：\u201c杀人虎\u201d将圈养 不会被处置","summary":"","article_type":244,"ban_review":0,"source":"原创新闻","flag":1,"tag_id":0,"display_title":"","article_url":"","source_url":"","share_url":"","review_count":4,"digg_count":2,"bury_count":0,"is_digg":0,"is_bury":0,"is_repin":0,"editor":"小路","imgs":["http://img1.mydrivers.com/img/20160825/14f7d93ec39b4555b645acbc2fad17e7.jpg"],"show_time":1472091842,"pub_time":1472091222,"showtype":1},{"article_id":496728,"title":"实力坑妈！日本论坛用户呼吁网友恶搞母亲照片","summary":"","article_type":226,"ban_review":0,"source":"原创新闻","flag":1,"tag_id":0,"display_title":"","article_url":"","source_url":"","share_url":"","review_count":4,"digg_count":1,"bury_count":0,"is_digg":0,"is_bury":0,"is_repin":0,"editor":"刘艺","imgs":["http://img1.mydrivers.com/img/20160825/ff612691313048ddb507443a190c39bb.jpg","http://img1.mydrivers.com/img/20160825/0a7a8f9d8142460faaab619b3082b297.jpg","http://img1.mydrivers.com/img/20160825/0836b8f122af4a499ede2334e95216a5.jpg"],"show_time":1472091328,"pub_time":1472091030,"showtype":3},{"article_id":496727,"title":"9月5日！魅族又要发布新机：邀请函如此经典","summary":"","article_type":288,"ban_review":0,"source":"原创新闻","flag":3,"tag_id":0,"display_title":"","article_url":"","source_url":"","share_url":"","review_count":7,"digg_count":1,"bury_count":2,"is_digg":0,"is_bury":0,"is_repin":0,"editor":"雪花","imgs":["http://img1.mydrivers.com/img/20160825/55dc1a795c7c4cc9a43d397702ee6932.jpg","http://img1.mydrivers.com/img/20160825/437488cf3dda40419b9068fe5827754f.jpg","http://img1.mydrivers.com/img/20160825/0be4d76920f6442db3496faad897e899.jpg"],"show_time":1472090814,"pub_time":1472090947,"showtype":3},{"article_id":496726,"title":"凤姐自曝在纽约的日子：一个月挣6000美元","summary":"","article_type":62,"ban_review":0,"source":"原创新闻","flag":1,"tag_id":0,"display_title":"","article_url":"","source_url":"","share_url":"","review_count":7,"digg_count":2,"bury_count":0,"is_digg":0,"is_bury":0,"is_repin":0,"editor":"随心","imgs":["http://img1.mydrivers.com/img/20160825/cc171abc4da546bb9698be6be8fbf293.jpg"],"show_time":1472090300,"pub_time":1472090808,"showtype":1},{"article_id":496725,"title":"豪华旗舰也熄火：奥迪宣布召回A8轿车","summary":"","article_type":258,"ban_review":0,"source":"原创新闻","flag":1,"tag_id":0,"display_title":"","article_url":"","source_url":"","share_url":"","review_count":2,"digg_count":1,"bury_count":0,"is_digg":0,"is_bury":0,"is_repin":0,"editor":"小路","imgs":["http://img1.mydrivers.com/img/20160825/078ae3ea2e304a538c994fa51810cec9.jpg"],"show_time":1472089786,"pub_time":1472090627,"showtype":1},{"article_id":496724,"title":"央视曝光：我们常吃的雪糕可能有毒","summary":"","article_type":301,"ban_review":0,"source":"现代快报","flag":1,"tag_id":0,"display_title":"http://mp.weixin.qq.com/s?__biz=MTYzMTE3Njk2MQ==&mid=2651780169&idx=1&sn=7ef83d6c1104e218c36311c821b4fe34&scene=1&srcid=0825DpLJDq2FZ2KweO5ruCGB#rd","article_url":"http://mp.weixin.qq.com/s?__biz=MTYzMTE3Njk2MQ==&mid=2651780169&idx=1&sn=7ef83d6c1104e218c36311c821b4fe34&scene=1&srcid=0825DpLJDq2FZ2KweO5ruCGB#rd","source_url":"http://mp.weixin.qq.com/s?__biz=MTYzMTE3Njk2MQ==&mid=2651780169&idx=1&sn=7ef83d6c1104e218c36311c821b4fe34&scene=1&srcid=0825DpLJDq2FZ2KweO5ruCGB#rd","share_url":"","review_count":10,"digg_count":1,"bury_count":6,"is_digg":0,"is_bury":0,"is_repin":0,"editor":"随心","imgs":["http://img1.mydrivers.com/img/20160825/519c8c30560b4b28930f08587f2cf0a3.jpg","http://img1.mydrivers.com/img/20160825/458f9f1fb6374b2ab25aca95648605cc.jpg","http://img1.mydrivers.com/img/20160825/a0240026e52d499984b232188d996eeb.jpg"],"show_time":1472089272,"pub_time":1472089691,"showtype":3},{"article_id":496723,"title":"巡航神器！哈雷新引擎发布：震动减75% 扭矩增10%","summary":"","article_type":316,"ban_review":0,"source":"原创新闻","flag":1,"tag_id":0,"display_title":"","article_url":"","source_url":"","share_url":"","review_count":7,"digg_count":2,"bury_count":1,"is_digg":0,"is_bury":0,"is_repin":0,"editor":"小路","imgs":["http://img1.mydrivers.com/img/20160825/92e2adeb914346cfb0597e5493e8e520.jpg"],"show_time":1472088758,"pub_time":1472089425,"showtype":1}],"next_show_time":1472088242}
     */

    private int code;
    private String msg;
    /**
     * news : [{"article_id":496729,"title":"八达岭动物园：\u201c杀人虎\u201d将圈养 不会被处置","summary":"","article_type":244,"ban_review":0,"source":"原创新闻","flag":1,"tag_id":0,"display_title":"","article_url":"","source_url":"","share_url":"","review_count":4,"digg_count":2,"bury_count":0,"is_digg":0,"is_bury":0,"is_repin":0,"editor":"小路","imgs":["http://img1.mydrivers.com/img/20160825/14f7d93ec39b4555b645acbc2fad17e7.jpg"],"show_time":1472091842,"pub_time":1472091222,"showtype":1},{"article_id":496728,"title":"实力坑妈！日本论坛用户呼吁网友恶搞母亲照片","summary":"","article_type":226,"ban_review":0,"source":"原创新闻","flag":1,"tag_id":0,"display_title":"","article_url":"","source_url":"","share_url":"","review_count":4,"digg_count":1,"bury_count":0,"is_digg":0,"is_bury":0,"is_repin":0,"editor":"刘艺","imgs":["http://img1.mydrivers.com/img/20160825/ff612691313048ddb507443a190c39bb.jpg","http://img1.mydrivers.com/img/20160825/0a7a8f9d8142460faaab619b3082b297.jpg","http://img1.mydrivers.com/img/20160825/0836b8f122af4a499ede2334e95216a5.jpg"],"show_time":1472091328,"pub_time":1472091030,"showtype":3},{"article_id":496727,"title":"9月5日！魅族又要发布新机：邀请函如此经典","summary":"","article_type":288,"ban_review":0,"source":"原创新闻","flag":3,"tag_id":0,"display_title":"","article_url":"","source_url":"","share_url":"","review_count":7,"digg_count":1,"bury_count":2,"is_digg":0,"is_bury":0,"is_repin":0,"editor":"雪花","imgs":["http://img1.mydrivers.com/img/20160825/55dc1a795c7c4cc9a43d397702ee6932.jpg","http://img1.mydrivers.com/img/20160825/437488cf3dda40419b9068fe5827754f.jpg","http://img1.mydrivers.com/img/20160825/0be4d76920f6442db3496faad897e899.jpg"],"show_time":1472090814,"pub_time":1472090947,"showtype":3},{"article_id":496726,"title":"凤姐自曝在纽约的日子：一个月挣6000美元","summary":"","article_type":62,"ban_review":0,"source":"原创新闻","flag":1,"tag_id":0,"display_title":"","article_url":"","source_url":"","share_url":"","review_count":7,"digg_count":2,"bury_count":0,"is_digg":0,"is_bury":0,"is_repin":0,"editor":"随心","imgs":["http://img1.mydrivers.com/img/20160825/cc171abc4da546bb9698be6be8fbf293.jpg"],"show_time":1472090300,"pub_time":1472090808,"showtype":1},{"article_id":496725,"title":"豪华旗舰也熄火：奥迪宣布召回A8轿车","summary":"","article_type":258,"ban_review":0,"source":"原创新闻","flag":1,"tag_id":0,"display_title":"","article_url":"","source_url":"","share_url":"","review_count":2,"digg_count":1,"bury_count":0,"is_digg":0,"is_bury":0,"is_repin":0,"editor":"小路","imgs":["http://img1.mydrivers.com/img/20160825/078ae3ea2e304a538c994fa51810cec9.jpg"],"show_time":1472089786,"pub_time":1472090627,"showtype":1},{"article_id":496724,"title":"央视曝光：我们常吃的雪糕可能有毒","summary":"","article_type":301,"ban_review":0,"source":"现代快报","flag":1,"tag_id":0,"display_title":"http://mp.weixin.qq.com/s?__biz=MTYzMTE3Njk2MQ==&mid=2651780169&idx=1&sn=7ef83d6c1104e218c36311c821b4fe34&scene=1&srcid=0825DpLJDq2FZ2KweO5ruCGB#rd","article_url":"http://mp.weixin.qq.com/s?__biz=MTYzMTE3Njk2MQ==&mid=2651780169&idx=1&sn=7ef83d6c1104e218c36311c821b4fe34&scene=1&srcid=0825DpLJDq2FZ2KweO5ruCGB#rd","source_url":"http://mp.weixin.qq.com/s?__biz=MTYzMTE3Njk2MQ==&mid=2651780169&idx=1&sn=7ef83d6c1104e218c36311c821b4fe34&scene=1&srcid=0825DpLJDq2FZ2KweO5ruCGB#rd","share_url":"","review_count":10,"digg_count":1,"bury_count":6,"is_digg":0,"is_bury":0,"is_repin":0,"editor":"随心","imgs":["http://img1.mydrivers.com/img/20160825/519c8c30560b4b28930f08587f2cf0a3.jpg","http://img1.mydrivers.com/img/20160825/458f9f1fb6374b2ab25aca95648605cc.jpg","http://img1.mydrivers.com/img/20160825/a0240026e52d499984b232188d996eeb.jpg"],"show_time":1472089272,"pub_time":1472089691,"showtype":3},{"article_id":496723,"title":"巡航神器！哈雷新引擎发布：震动减75% 扭矩增10%","summary":"","article_type":316,"ban_review":0,"source":"原创新闻","flag":1,"tag_id":0,"display_title":"","article_url":"","source_url":"","share_url":"","review_count":7,"digg_count":2,"bury_count":1,"is_digg":0,"is_bury":0,"is_repin":0,"editor":"小路","imgs":["http://img1.mydrivers.com/img/20160825/92e2adeb914346cfb0597e5493e8e520.jpg"],"show_time":1472088758,"pub_time":1472089425,"showtype":1}]
     * next_show_time : 1472088242
     */

    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int next_show_time;
        /**
         * article_id : 496729
         * title : 八达岭动物园：“杀人虎”将圈养 不会被处置
         * summary :
         * article_type : 244
         * ban_review : 0
         * source : 原创新闻
         * flag : 1
         * tag_id : 0
         * display_title :
         * article_url :
         * source_url :
         * share_url :
         * review_count : 4
         * digg_count : 2
         * bury_count : 0
         * is_digg : 0
         * is_bury : 0
         * is_repin : 0
         * editor : 小路
         * imgs : ["http://img1.mydrivers.com/img/20160825/14f7d93ec39b4555b645acbc2fad17e7.jpg"]
         * show_time : 1472091842
         * pub_time : 1472091222
         * showtype : 1
         */

        private List<NewsBean> news;

        public int getNext_show_time() {
            return next_show_time;
        }

        public void setNext_show_time(int next_show_time) {
            this.next_show_time = next_show_time;
        }

        public List<NewsBean> getNews() {
            return news;
        }

        public void setNews(List<NewsBean> news) {
            this.news = news;
        }

        public static class NewsBean {
            private int article_id;
            private String title;
//            private String summary;
            private int article_type;
            private int ban_review;
            private String source;
            private int flag;
            private int tag_id;
//            private String display_title;
//            private String article_url;
//            private String source_url;
//            private String share_url;
            private int review_count;
            private int digg_count;
            private int bury_count;
            private int is_digg;
            private int is_bury;
            private int is_repin;
            private String editor;
            private int show_time;
            private int pub_time;
            private int showtype;
            private List<String> imgs;

            public int getArticle_id() {
                return article_id;
            }

            public void setArticle_id(int article_id) {
                this.article_id = article_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

//            public String getSummary() {
//                return summary;
//            }
//
//            public void setSummary(String summary) {
//                this.summary = summary;
//            }

            public int getArticle_type() {
                return article_type;
            }

            public void setArticle_type(int article_type) {
                this.article_type = article_type;
            }

            public int getBan_review() {
                return ban_review;
            }

            public void setBan_review(int ban_review) {
                this.ban_review = ban_review;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public int getFlag() {
                return flag;
            }

            public void setFlag(int flag) {
                this.flag = flag;
            }

            public int getTag_id() {
                return tag_id;
            }

            public void setTag_id(int tag_id) {
                this.tag_id = tag_id;
            }

//            public String getDisplay_title() {
//                return display_title;
//            }
//
//            public void setDisplay_title(String display_title) {
//                this.display_title = display_title;
//            }
//
//            public String getArticle_url() {
//                return article_url;
//            }
//
//            public void setArticle_url(String article_url) {
//                this.article_url = article_url;
//            }
//
//            public String getSource_url() {
//                return source_url;
//            }
//
//            public void setSource_url(String source_url) {
//                this.source_url = source_url;
//            }
//
//            public String getShare_url() {
//                return share_url;
//            }
//
//            public void setShare_url(String share_url) {
//                this.share_url = share_url;
//            }

            public int getReview_count() {
                return review_count;
            }

            public void setReview_count(int review_count) {
                this.review_count = review_count;
            }

            public int getDigg_count() {
                return digg_count;
            }

            public void setDigg_count(int digg_count) {
                this.digg_count = digg_count;
            }

            public int getBury_count() {
                return bury_count;
            }

            public void setBury_count(int bury_count) {
                this.bury_count = bury_count;
            }

            public int getIs_digg() {
                return is_digg;
            }

            public void setIs_digg(int is_digg) {
                this.is_digg = is_digg;
            }

            public int getIs_bury() {
                return is_bury;
            }

            public void setIs_bury(int is_bury) {
                this.is_bury = is_bury;
            }

            public int getIs_repin() {
                return is_repin;
            }

            public void setIs_repin(int is_repin) {
                this.is_repin = is_repin;
            }

            public String getEditor() {
                return editor;
            }

            public void setEditor(String editor) {
                this.editor = editor;
            }

            public int getShow_time() {
                return show_time;
            }

            public void setShow_time(int show_time) {
                this.show_time = show_time;
            }

            public int getPub_time() {
                return pub_time;
            }

            public void setPub_time(int pub_time) {
                this.pub_time = pub_time;
            }

            public int getShowtype() {
                return showtype;
            }

            public void setShowtype(int showtype) {
                this.showtype = showtype;
            }

            public List<String> getImgs() {
                return imgs;
            }

            public void setImgs(List<String> imgs) {
                this.imgs = imgs;
            }
        }
    }
}
