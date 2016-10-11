package com.qianfeng.mydriversdemo.utils;

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

/**
 * Created by jackiechan on 16/8/25.
 */
public interface GloableInerface {
    String SERVERURL = "http://dt.kkeji.com/api/1/";
    String DATAURL = SERVERURL + "contents?min_pub_time=0&article_type=%d&sign=-477263451&min_show_time=0&xaid=7b920b9704f24c3b&udid=5186261861683913428";
    String MOREPAGE = SERVERURL + "contents?article_type=%d&sign=-477263451&xaid=7b920b9704f24c3b&udid=5186261861683913428&max_show_time=%d";
    String DETAILURL = SERVERURL+"contents/details?sign=-477263451&nids=%d&xaid=7b920b9704f24c3b&udid=5186261861683913428";
}
/*
#快科技
###最新
	http://dt.kkeji.com/api/1/contents?min_pub_time=0&article_type=-1&sign=-477263451&min_show_time=0&xaid=7b920b9704f24c3b&udid=5186261861683913428




###推荐
	http://dt.kkeji.com/api/1/contents?article_type=-2&sign=-477263451&min_show_time=0&xaid=7b920b9704f24c3b&udid=5186261861683913428


##手机
	http://dt.kkeji.com/api/1/contents?article_type=1&sign=-477263451&min_show_time=0&xaid=7b920b9704f24c3b&udid=5186261861683913428
##IT圈
	type=7
##汽车
	5
##科学
	6
##游戏
	4
##电脑
	2
##影音
	8
##软件
	3
##数码
	10
##家电
	9
##详情
	http://dt.kkeji.com/api/1/contents/info?article_id=496625&sign=-477263451&xaid=7b920b9704f24c3b&udid=5186261861683913428
http://dt.kkeji.com/api/1/contents/details?sign=-477263451&nids=496750&xaid=7b920b9704f24c3b&udid=5186261861683913428


##详情相关新闻
	http://dt.kkeji.com/api/1/contents/related?xaid=7b920b9704f24c3b&udid=5186261861683913428&sign=-477263451&article_id=496625
##最新评论
	http://dt.kkeji.com/api/1/comments/newscomments?article_id=496625&sign=-477263451&page=1&xaid=7b920b9704f24c3b&udid=5186261861683913428
##最热评论
	http://dt.kkeji.com/api/1/comments/newscomments?article_id=496625&sign=-477263451&xaid=7b920b9704f24c3b&udid=5186261861683913428&hot=1

##分页
	http://dt.kkeji.com/api/1/contents?article_type=-2&sign=-477263451&xaid=7b920b9704f24c3b&udid=5186261861683913428&max_show_time=1472042739



 */