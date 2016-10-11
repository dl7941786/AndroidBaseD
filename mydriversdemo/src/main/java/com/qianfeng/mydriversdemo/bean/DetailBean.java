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
public class DetailBean {

    /**
     * code : 1
     * msg : success
     * data : {"news":[{"article_id":495934,"article_content":"<p>北京时间今天上午8点，《守望先锋》正式结束了竞技比赛第一赛季的赛程，并为所有参加过竞技比赛的玩家发放了赛季奖励。<\/p><p>赛季奖励方面，<strong>如果玩家在第一赛季完成了定级赛，那么就会获得下图中的竞技比赛头像与竞技比赛喷漆。<\/strong><\/p><p align=\"center\"><img onclick=\"javascript:window.news.setImages(setimageswwghttp://img1.mydrivers.com/img/20160818/s_c2ac7e98f7784f9894c4eeb07468ab7b.jpgsetimageswwg)\" src=\"http://img1.mydrivers.com/img/20160818/s_c2ac7e98f7784f9894c4eeb07468ab7b.jpg\"/><\/p><p><\/p><p align=\"center\"><img onclick=\"javascript:window.news.setImages(setimageswwghttp://img1.mydrivers.com/img/20160818/s_59b708a4aed74f62a6493ff1ae155c2d.jpgsetimageswwg)\" src=\"http://img1.mydrivers.com/img/20160818/s_59b708a4aed74f62a6493ff1ae155c2d.jpg\"/><\/p><p>而如果玩家在第一赛季的任意时间段内，排名达到了所在区服的前500名，那么暴雪还将<strong>额外奖励玩家下图中的这款动态喷漆<\/strong>。<\/p><p align=\"center\"><img onclick=\"javascript:window.news.setImages(setimageswwghttp://img1.mydrivers.com/img/20160818/s_42947401c5d74444a1e0d9d076c754aa.jpgsetimageswwg)\" src=\"http://img1.mydrivers.com/img/20160818/s_42947401c5d74444a1e0d9d076c754aa.jpg\"/><\/p><p>除了喷漆和头像奖励以外，<strong>系统还会根据玩家在第一赛季所达到的最高竞技等级来奖励相对应的竞技点数。<\/strong><\/p><p>以下是第一赛季竞技等级与竞技点数的奖励换算信息：<\/p><p>0-39等级：10竞技点数；<\/p><p>40-45等级：20竞技点数；<\/p><p>46-49等级：40竞技点数；<\/p><p>50-52等级：60竞技点数；<\/p><p>53-55等级：80竞技点数；<\/p><p>56-59等级：120竞技点数；<\/p><p>60-64等级：200竞技点数；<\/p><p><strong>65+等级：300竞技点数。<\/strong><\/p><p>也就是说，<span style=\"color:#ff0000;\"><strong>如果你在竞技比赛第一赛季达到了竞技等级65以上，便可直接获得足够兑换黄金武器皮肤的竞技点数。<\/strong><\/span><\/p><p align=\"center\"><img onclick=\"javascript:window.news.setImages(setimageswwghttp://img1.mydrivers.com/img/20160818/s_d6279d51373143bd93b17d1032282014.jpgsetimageswwg)\" src=\"http://img1.mydrivers.com/img/20160818/s_d6279d51373143bd93b17d1032282014.jpg\"/><\/p><p>此外，竞技比赛<strong>第二赛季目前计划将于9月7日正式开启<\/strong>。<\/p>"}]}
     */

    private int code;
    private String msg;
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
        /**
         * article_id : 495934
         * article_content : <p>北京时间今天上午8点，《守望先锋》正式结束了竞技比赛第一赛季的赛程，并为所有参加过竞技比赛的玩家发放了赛季奖励。</p><p>赛季奖励方面，<strong>如果玩家在第一赛季完成了定级赛，那么就会获得下图中的竞技比赛头像与竞技比赛喷漆。</strong></p><p align="center"><img onclick="javascript:window.news.setImages(setimageswwghttp://img1.mydrivers.com/img/20160818/s_c2ac7e98f7784f9894c4eeb07468ab7b.jpgsetimageswwg)" src="http://img1.mydrivers.com/img/20160818/s_c2ac7e98f7784f9894c4eeb07468ab7b.jpg"/></p><p></p><p align="center"><img onclick="javascript:window.news.setImages(setimageswwghttp://img1.mydrivers.com/img/20160818/s_59b708a4aed74f62a6493ff1ae155c2d.jpgsetimageswwg)" src="http://img1.mydrivers.com/img/20160818/s_59b708a4aed74f62a6493ff1ae155c2d.jpg"/></p><p>而如果玩家在第一赛季的任意时间段内，排名达到了所在区服的前500名，那么暴雪还将<strong>额外奖励玩家下图中的这款动态喷漆</strong>。</p><p align="center"><img onclick="javascript:window.news.setImages(setimageswwghttp://img1.mydrivers.com/img/20160818/s_42947401c5d74444a1e0d9d076c754aa.jpgsetimageswwg)" src="http://img1.mydrivers.com/img/20160818/s_42947401c5d74444a1e0d9d076c754aa.jpg"/></p><p>除了喷漆和头像奖励以外，<strong>系统还会根据玩家在第一赛季所达到的最高竞技等级来奖励相对应的竞技点数。</strong></p><p>以下是第一赛季竞技等级与竞技点数的奖励换算信息：</p><p>0-39等级：10竞技点数；</p><p>40-45等级：20竞技点数；</p><p>46-49等级：40竞技点数；</p><p>50-52等级：60竞技点数；</p><p>53-55等级：80竞技点数；</p><p>56-59等级：120竞技点数；</p><p>60-64等级：200竞技点数；</p><p><strong>65+等级：300竞技点数。</strong></p><p>也就是说，<span style="color:#ff0000;"><strong>如果你在竞技比赛第一赛季达到了竞技等级65以上，便可直接获得足够兑换黄金武器皮肤的竞技点数。</strong></span></p><p align="center"><img onclick="javascript:window.news.setImages(setimageswwghttp://img1.mydrivers.com/img/20160818/s_d6279d51373143bd93b17d1032282014.jpgsetimageswwg)" src="http://img1.mydrivers.com/img/20160818/s_d6279d51373143bd93b17d1032282014.jpg"/></p><p>此外，竞技比赛<strong>第二赛季目前计划将于9月7日正式开启</strong>。</p>
         */

        private List<NewsBean> news;

        public List<NewsBean> getNews() {
            return news;
        }

        public void setNews(List<NewsBean> news) {
            this.news = news;
        }

        public static class NewsBean {
            private int article_id;
            private String article_content;

            public int getArticle_id() {
                return article_id;
            }

            public void setArticle_id(int article_id) {
                this.article_id = article_id;
            }

            public String getArticle_content() {
                return article_content;
            }

            public void setArticle_content(String article_content) {
                this.article_content = article_content;
            }
        }
    }
}
