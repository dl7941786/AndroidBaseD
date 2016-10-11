package com.qianfeng.xianghaapp.bean;

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

/**这是学做菜页面除了 listview 之外的数据
 * Created by jackiechan on 16/8/12.
 */
public class BaseData {
    /**
     * res : 2
     * data : {"recommend":[{"title":"早餐食谱","date":"八月二十四日","type":1,"time":"2","url":"http://appweb.xiangha.com/app5/dishList.app?type=typeRecommend&g1=1","img":"http://s1.cdn.xiangha.com/caipu/201608/0723/171056253993.jpg/MTAwMHgw","list":[{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/0723/171056253993.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1616/161615229235.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/2023/2023065751.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/1915/191530576922.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/2110/211002365035.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/0809/080943119262.jpg/MTAwMHgw"}]},{"title":"中餐食谱","date":"八月二十四日","type":2,"time":"2","url":"http://appweb.xiangha.com/app5/dishList.app?type=typeRecommend&g1=2","img":"http://s1.cdn.xiangha.com/caipu/201608/1817/18173323404.jpg/MTAwMHgw","list":[{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1817/18173323404.jpg/MTAwMHgw"},{"hasVideo":"2","video":[{"id":"322","name":"清蒸草鱼","vu":"11ddefa22e","img":"http://s1.cdn.xiangha.com/videoImg/201604/2815/5721b6efe6581.JPG/MTAwMHgw","uu":"grpbim18nn"}],"img":"http://s1.cdn.xiangha.com/videoImg/201604/2815/5721b6efe6581.JPG/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/2115/211608014312.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1913/191357425320.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1912/191351047223.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1000/100019153494.jpg/MTAwMHgw"}]},{"title":"晚餐食谱","date":"八月二十四日","type":3,"time":"2","url":"http://appweb.xiangha.com/app5/dishList.app?type=typeRecommend&g1=3","img":"http://s1.cdn.xiangha.com/caipu/201608/1816/181635077659.jpg/MTAwMHgw","list":[{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1816/181635077659.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1717/171717346757.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1816/181602221773.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1822/182230231357.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1722/172210312954.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1311/131151414240.jpg/MTAwMHgw"}]}],"slide":[],"activeUser":[{"code":73501344690,"nickName":"bluegirl_","img":"http://s1.cdn.xiangha.com/i/201606/0220/5750211b736ab.jpg/NTB4NTA","hotNum":3648,"isGourmet":"2"},{"code":37914324450,"nickName":"毓玲珑","img":"http://s1.cdn.xiangha.com/i/201608/1316/57aee0daa8883.jpg/NTB4NTA","hotNum":2886,"isGourmet":"2"},{"code":36832289061,"nickName":"刘佳","img":"http://s1.cdn.xiangha.com/i/201607/2513/57959fb242edd.jpg/NTB4NTA","hotNum":2517,"isGourmet":"2"},{"code":37378891461,"nickName":"枫叶346","img":"http://s1.cdn.xiangha.com/i/201608/1716/57b4255d77e6b.jpg/NTB4NTA","hotNum":2275,"isGourmet":"2"},{"code":5855102497,"nickName":"琴琴一佛宣","img":"http://s1.cdn.xiangha.com/i/201608/2220/57baebd4e4752.jpg/NTB4NTA","hotNum":1918,"isGourmet":1},{"code":73158692910,"nickName":"KMa叶子","img":"http://s1.cdn.xiangha.com/i/201608/2311/57bbc512b2162.jpg/NTB4NTA","hotNum":1827,"isGourmet":"2"},{"code":63642553831,"nickName":"窈-窈","img":"http://s1.cdn.xiangha.com/i/201608/1720/57b456ea40fb8.jpg/NTB4NTA","hotNum":1654,"isGourmet":"2"},{"code":64412537420,"nickName":"壹個--吃貨","img":"http://s1.cdn.xiangha.com/i/201607/2109/57901ed0c1e3b.jpg/NTB4NTA","hotNum":1649,"isGourmet":"2"},{"code":5513084041,"nickName":"我家的胖娃娃","img":"http://s1.cdn.xiangha.com/i/201607/0508/577afb2a83515.jpg/NTB4NTA","hotNum":1582,"isGourmet":"2"},{"code":55041993441,"nickName":"欣绿","img":"http://s1.cdn.xiangha.com/i/201608/1419/57b058c745f6e.jpg/NTB4NTA","hotNum":1423,"isGourmet":"2"}],"nous":[{"code":236638,"title":"爱吃咸菜、烫食易患食道癌？预防有方法。","allClick":"2999","classifyname":"健康养生","commentCount":"13","img":"http://s1.cdn.xiangha.com/zhishi/201608/191218157098.jpg/OTgweDA","isUrl":"nousList.app?type=new"},{"code":236644,"title":"\u201c营养之王\u201d排毒稳压，现在吃最好啦！","allClick":"2100","classifyname":"美食精选","commentCount":"8","img":"http://s1.cdn.xiangha.com/zhishi/201608/191225173163.jpg/OTgweDA","isUrl":"nousList.app?type=new"}],"topic":[{"title":"活动 | 月饼 征集令","subtitle":"15道菜谱","desc":"活动来了！！！\r\n\r\n备战中秋，传月饼菜谱，赢积分啦！！！\r\n\r\n请点击查看，参与活动的正确姿势！！！\r\n\r\n点击展开，查看活动详情\u2026\u2026&gt;&gt;\r\n\r\n自从开始亲自动手制作，就知道了外边的月饼简直弱爆了。自己做不仅真材实料，制作过程更干净卫生，吃着放心，口味也能随心所欲。大写的合口味~\r\n月是故乡明，饼表思乡情，今年的中秋节你想好做什么月饼了吗？\r\n\r\n一、活动时间：\r\n\r\n8月17日12点\u2014\u20148月31日24点\r\n\r\n二、参与方式及要求：\r\n\r\n1.上传有关月饼的菜谱，菜谱名前【添加#月饼#标签】，且【#号为英文状态】，例如：#月饼#冰皮月饼。注意：【没有添加标签】、【标签输入错误】和【#号输入错误】的，视为该菜谱放弃参加本次活动。\r\n2. 活动只限【首次审核】的菜谱，提交二次审核的不算参与活动。注意：在没有发放活动积分之前，请不要提交二次审核（提交二次审核后，标签不会保留,视为没有参与活动）。\r\n3. 菜谱必须是月饼的菜谱，或者是由月饼做成的菜谱。\r\n4. 参与活动的菜谱：个数不限；必须原创；必须独家；禁止重复。\r\n5. 活动的最终解释权归香哈所有。\r\n6. 社区会置顶[ 活动答疑贴 ]，实时更新和答疑，请及时查看和反馈在该帖下，或者及时联系管理员。\r\n\r\n三、 奖励积分：\r\n\r\n1. 首次审核为优质菜谱：额外奖励50积分\r\n2. 首次审核为精华菜谱：额外奖励100积分\r\n3. 发放时间：\r\n   活动结束后，统一发放（9月2日或者9月5日）","url":"caidanDetail.app?type=caidan&g1=2314","imgs":"http://s1.cdn.xiangha.com/caipu/201509/2023/202330256519.jpg/MTAwMHgw"},{"title":"活动 | 月饼馅 征集令","subtitle":"10道菜谱","desc":"活动来了！！！\r\n\r\n上传有关月饼馅料的菜谱，赢积分啦！！！\r\n\r\n请点击查看，参与活动的正确姿势！！！\r\n\r\n点击展开，查看活动详情\u2026\u2026&gt;&gt;\r\n\r\n中秋节就快要到啦，大卖场超市里，现在已经能看到各种馅料的月饼琳琅满目。你还保留着中秋节吃月饼的习惯吗？是钟爱各色甜馅儿还是对鲜肉月饼情有独钟？\r\n买的月饼馅儿不是太甜就是太腻？香哈邀你一起为中秋节做准备，你的月饼馅你做主。\r\n\r\n一、活动时间：\r\n\r\n8月17日12点\u2014\u20148月31日24点\r\n\r\n二、参与方式及要求：\r\n\r\n1.上传有关【月饼馅料】的菜谱，菜谱名前【添加#月饼馅#标签】，且【#号为英文状态】，例如：#月饼馅#红豆沙馅。注意：【没有添加标签】、【标签输入错误】和【#号输入错误】的，视为该菜谱放弃参加本次活动。\r\n2. 活动只限【首次审核】的菜谱，提交二次审核的不算参与活动。注意：在没有发放活动积分之前，请不要提交二次审核（提交二次审核后，标签不会保留,视为没有参与活动）。\r\n3. 菜谱必须是有关月饼馅料的菜谱。\r\n4. 参与活动的菜谱：个数不限；必须原创；必须独家；禁止重复。\r\n5. 活动的最终解释权归香哈所有。\r\n6. 社区会置顶[ 活动答疑贴 ]，实时更新和答疑，请及时查看和反馈在该帖下，或者及时联系管理员。\r\n\r\n三、 奖励积分：\r\n\r\n1. 首次审核为优质菜谱：额外奖励50积分\r\n2. 首次审核为精华菜谱：额外奖励100积分\r\n3. 发放时间：\r\n   活动结束后，统一发放（9月2日或者9月5日）","url":"caidanDetail.app?type=caidan&g1=2307","imgs":"http://s1.cdn.xiangha.com/caipu/201605/1910/191029253371.jpg/MTAwMHgw"},{"title":"这口榴莲酥 真的会上瘾\t","subtitle":"皮薄馅儿多，满口果肉，36.8元/箱还包邮\t","desc":"皮薄馅儿多，满口果肉，36.8元/箱还包邮\t","imgs":"http://s1.cdn.xiangha.com/www/201608/240947308599.png/MTAwMHgw","url":"http://m.ds.xiangha.com/v1/topic/getTopicInfo?topic_code=2652&fr1=_share"}],"adDishInfo":[""],"adTieInfo":{"name":"中国好菜谱第二期","img":"http://s1.cdn.xiangha.com/www/201608/222141516203.jpg/MTAwMHgw","url":"http://appweb.xiangha.com/zj/introduce"},"proBitPage":{"name":"中国好菜谱第二期","img":"http://s1.cdn.xiangha.com/www/201608/222141516203.jpg/MTAwMHgw","url":"http://appweb.xiangha.com/zj/introduce?pageFrom=home"},"proBitBox":[]}
     * append : []
     */

    private int res;
    /**
     * recommend : [{"title":"早餐食谱","date":"八月二十四日","type":1,"time":"2","url":"http://appweb.xiangha.com/app5/dishList.app?type=typeRecommend&g1=1","img":"http://s1.cdn.xiangha.com/caipu/201608/0723/171056253993.jpg/MTAwMHgw","list":[{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/0723/171056253993.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1616/161615229235.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/2023/2023065751.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/1915/191530576922.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/2110/211002365035.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/0809/080943119262.jpg/MTAwMHgw"}]},{"title":"中餐食谱","date":"八月二十四日","type":2,"time":"2","url":"http://appweb.xiangha.com/app5/dishList.app?type=typeRecommend&g1=2","img":"http://s1.cdn.xiangha.com/caipu/201608/1817/18173323404.jpg/MTAwMHgw","list":[{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1817/18173323404.jpg/MTAwMHgw"},{"hasVideo":"2","video":[{"id":"322","name":"清蒸草鱼","vu":"11ddefa22e","img":"http://s1.cdn.xiangha.com/videoImg/201604/2815/5721b6efe6581.JPG/MTAwMHgw","uu":"grpbim18nn"}],"img":"http://s1.cdn.xiangha.com/videoImg/201604/2815/5721b6efe6581.JPG/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/2115/211608014312.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1913/191357425320.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1912/191351047223.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1000/100019153494.jpg/MTAwMHgw"}]},{"title":"晚餐食谱","date":"八月二十四日","type":3,"time":"2","url":"http://appweb.xiangha.com/app5/dishList.app?type=typeRecommend&g1=3","img":"http://s1.cdn.xiangha.com/caipu/201608/1816/181635077659.jpg/MTAwMHgw","list":[{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1816/181635077659.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1717/171717346757.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1816/181602221773.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1822/182230231357.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1722/172210312954.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1311/131151414240.jpg/MTAwMHgw"}]}]
     * slide : []
     * activeUser : [{"code":73501344690,"nickName":"bluegirl_","img":"http://s1.cdn.xiangha.com/i/201606/0220/5750211b736ab.jpg/NTB4NTA","hotNum":3648,"isGourmet":"2"},{"code":37914324450,"nickName":"毓玲珑","img":"http://s1.cdn.xiangha.com/i/201608/1316/57aee0daa8883.jpg/NTB4NTA","hotNum":2886,"isGourmet":"2"},{"code":36832289061,"nickName":"刘佳","img":"http://s1.cdn.xiangha.com/i/201607/2513/57959fb242edd.jpg/NTB4NTA","hotNum":2517,"isGourmet":"2"},{"code":37378891461,"nickName":"枫叶346","img":"http://s1.cdn.xiangha.com/i/201608/1716/57b4255d77e6b.jpg/NTB4NTA","hotNum":2275,"isGourmet":"2"},{"code":5855102497,"nickName":"琴琴一佛宣","img":"http://s1.cdn.xiangha.com/i/201608/2220/57baebd4e4752.jpg/NTB4NTA","hotNum":1918,"isGourmet":1},{"code":73158692910,"nickName":"KMa叶子","img":"http://s1.cdn.xiangha.com/i/201608/2311/57bbc512b2162.jpg/NTB4NTA","hotNum":1827,"isGourmet":"2"},{"code":63642553831,"nickName":"窈-窈","img":"http://s1.cdn.xiangha.com/i/201608/1720/57b456ea40fb8.jpg/NTB4NTA","hotNum":1654,"isGourmet":"2"},{"code":64412537420,"nickName":"壹個--吃貨","img":"http://s1.cdn.xiangha.com/i/201607/2109/57901ed0c1e3b.jpg/NTB4NTA","hotNum":1649,"isGourmet":"2"},{"code":5513084041,"nickName":"我家的胖娃娃","img":"http://s1.cdn.xiangha.com/i/201607/0508/577afb2a83515.jpg/NTB4NTA","hotNum":1582,"isGourmet":"2"},{"code":55041993441,"nickName":"欣绿","img":"http://s1.cdn.xiangha.com/i/201608/1419/57b058c745f6e.jpg/NTB4NTA","hotNum":1423,"isGourmet":"2"}]
     * nous : [{"code":236638,"title":"爱吃咸菜、烫食易患食道癌？预防有方法。","allClick":"2999","classifyname":"健康养生","commentCount":"13","img":"http://s1.cdn.xiangha.com/zhishi/201608/191218157098.jpg/OTgweDA","isUrl":"nousList.app?type=new"},{"code":236644,"title":"\u201c营养之王\u201d排毒稳压，现在吃最好啦！","allClick":"2100","classifyname":"美食精选","commentCount":"8","img":"http://s1.cdn.xiangha.com/zhishi/201608/191225173163.jpg/OTgweDA","isUrl":"nousList.app?type=new"}]
     * topic : [{"title":"活动 | 月饼 征集令","subtitle":"15道菜谱","desc":"活动来了！！！\r\n\r\n备战中秋，传月饼菜谱，赢积分啦！！！\r\n\r\n请点击查看，参与活动的正确姿势！！！\r\n\r\n点击展开，查看活动详情\u2026\u2026&gt;&gt;\r\n\r\n自从开始亲自动手制作，就知道了外边的月饼简直弱爆了。自己做不仅真材实料，制作过程更干净卫生，吃着放心，口味也能随心所欲。大写的合口味~\r\n月是故乡明，饼表思乡情，今年的中秋节你想好做什么月饼了吗？\r\n\r\n一、活动时间：\r\n\r\n8月17日12点\u2014\u20148月31日24点\r\n\r\n二、参与方式及要求：\r\n\r\n1.上传有关月饼的菜谱，菜谱名前【添加#月饼#标签】，且【#号为英文状态】，例如：#月饼#冰皮月饼。注意：【没有添加标签】、【标签输入错误】和【#号输入错误】的，视为该菜谱放弃参加本次活动。\r\n2. 活动只限【首次审核】的菜谱，提交二次审核的不算参与活动。注意：在没有发放活动积分之前，请不要提交二次审核（提交二次审核后，标签不会保留,视为没有参与活动）。\r\n3. 菜谱必须是月饼的菜谱，或者是由月饼做成的菜谱。\r\n4. 参与活动的菜谱：个数不限；必须原创；必须独家；禁止重复。\r\n5. 活动的最终解释权归香哈所有。\r\n6. 社区会置顶[ 活动答疑贴 ]，实时更新和答疑，请及时查看和反馈在该帖下，或者及时联系管理员。\r\n\r\n三、 奖励积分：\r\n\r\n1. 首次审核为优质菜谱：额外奖励50积分\r\n2. 首次审核为精华菜谱：额外奖励100积分\r\n3. 发放时间：\r\n   活动结束后，统一发放（9月2日或者9月5日）","url":"caidanDetail.app?type=caidan&g1=2314","imgs":"http://s1.cdn.xiangha.com/caipu/201509/2023/202330256519.jpg/MTAwMHgw"},{"title":"活动 | 月饼馅 征集令","subtitle":"10道菜谱","desc":"活动来了！！！\r\n\r\n上传有关月饼馅料的菜谱，赢积分啦！！！\r\n\r\n请点击查看，参与活动的正确姿势！！！\r\n\r\n点击展开，查看活动详情\u2026\u2026&gt;&gt;\r\n\r\n中秋节就快要到啦，大卖场超市里，现在已经能看到各种馅料的月饼琳琅满目。你还保留着中秋节吃月饼的习惯吗？是钟爱各色甜馅儿还是对鲜肉月饼情有独钟？\r\n买的月饼馅儿不是太甜就是太腻？香哈邀你一起为中秋节做准备，你的月饼馅你做主。\r\n\r\n一、活动时间：\r\n\r\n8月17日12点\u2014\u20148月31日24点\r\n\r\n二、参与方式及要求：\r\n\r\n1.上传有关【月饼馅料】的菜谱，菜谱名前【添加#月饼馅#标签】，且【#号为英文状态】，例如：#月饼馅#红豆沙馅。注意：【没有添加标签】、【标签输入错误】和【#号输入错误】的，视为该菜谱放弃参加本次活动。\r\n2. 活动只限【首次审核】的菜谱，提交二次审核的不算参与活动。注意：在没有发放活动积分之前，请不要提交二次审核（提交二次审核后，标签不会保留,视为没有参与活动）。\r\n3. 菜谱必须是有关月饼馅料的菜谱。\r\n4. 参与活动的菜谱：个数不限；必须原创；必须独家；禁止重复。\r\n5. 活动的最终解释权归香哈所有。\r\n6. 社区会置顶[ 活动答疑贴 ]，实时更新和答疑，请及时查看和反馈在该帖下，或者及时联系管理员。\r\n\r\n三、 奖励积分：\r\n\r\n1. 首次审核为优质菜谱：额外奖励50积分\r\n2. 首次审核为精华菜谱：额外奖励100积分\r\n3. 发放时间：\r\n   活动结束后，统一发放（9月2日或者9月5日）","url":"caidanDetail.app?type=caidan&g1=2307","imgs":"http://s1.cdn.xiangha.com/caipu/201605/1910/191029253371.jpg/MTAwMHgw"},{"title":"这口榴莲酥 真的会上瘾\t","subtitle":"皮薄馅儿多，满口果肉，36.8元/箱还包邮\t","desc":"皮薄馅儿多，满口果肉，36.8元/箱还包邮\t","imgs":"http://s1.cdn.xiangha.com/www/201608/240947308599.png/MTAwMHgw","url":"http://m.ds.xiangha.com/v1/topic/getTopicInfo?topic_code=2652&fr1=_share"}]
     * adDishInfo : [""]
     * adTieInfo : {"name":"中国好菜谱第二期","img":"http://s1.cdn.xiangha.com/www/201608/222141516203.jpg/MTAwMHgw","url":"http://appweb.xiangha.com/zj/introduce"}
     * proBitPage : {"name":"中国好菜谱第二期","img":"http://s1.cdn.xiangha.com/www/201608/222141516203.jpg/MTAwMHgw","url":"http://appweb.xiangha.com/zj/introduce?pageFrom=home"}
     * proBitBox : []
     */

    private DataBean data;
    private List<?> append;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public List<?> getAppend() {
        return append;
    }

    public void setAppend(List<?> append) {
        this.append = append;
    }

    public static class DataBean {
        /**
         * name : 中国好菜谱第二期
         * img : http://s1.cdn.xiangha.com/www/201608/222141516203.jpg/MTAwMHgw
         * url : http://appweb.xiangha.com/zj/introduce
         */

        private AdTieInfoBean adTieInfo;
        /**
         * name : 中国好菜谱第二期
         * img : http://s1.cdn.xiangha.com/www/201608/222141516203.jpg/MTAwMHgw
         * url : http://appweb.xiangha.com/zj/introduce?pageFrom=home
         */

        private ProBitPageBean proBitPage;
        /**
         * title : 早餐食谱
         * date : 八月二十四日
         * type : 1
         * time : 2
         * url : http://appweb.xiangha.com/app5/dishList.app?type=typeRecommend&g1=1
         * img : http://s1.cdn.xiangha.com/caipu/201608/0723/171056253993.jpg/MTAwMHgw
         * list : [{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/0723/171056253993.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/1616/161615229235.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/2023/2023065751.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/1915/191530576922.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/2110/211002365035.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/0809/080943119262.jpg/MTAwMHgw"}]
         */

        private List<RecommendBean> recommend;
        private List<?> slide;
        /**
         * code : 73501344690
         * nickName : bluegirl_
         * img : http://s1.cdn.xiangha.com/i/201606/0220/5750211b736ab.jpg/NTB4NTA
         * hotNum : 3648
         * isGourmet : 2
         */

        private List<ActiveUserBean> activeUser;
        /**
         * code : 236638
         * title : 爱吃咸菜、烫食易患食道癌？预防有方法。
         * allClick : 2999
         * classifyname : 健康养生
         * commentCount : 13
         * img : http://s1.cdn.xiangha.com/zhishi/201608/191218157098.jpg/OTgweDA
         * isUrl : nousList.app?type=new
         */

        private List<NousBean> nous;
        /**
         * title : 活动 | 月饼 征集令
         * subtitle : 15道菜谱
         * desc : 活动来了！！！

         备战中秋，传月饼菜谱，赢积分啦！！！

         请点击查看，参与活动的正确姿势！！！

         点击展开，查看活动详情……&gt;&gt;

         自从开始亲自动手制作，就知道了外边的月饼简直弱爆了。自己做不仅真材实料，制作过程更干净卫生，吃着放心，口味也能随心所欲。大写的合口味~
         月是故乡明，饼表思乡情，今年的中秋节你想好做什么月饼了吗？

         一、活动时间：

         8月17日12点——8月31日24点

         二、参与方式及要求：

         1.上传有关月饼的菜谱，菜谱名前【添加#月饼#标签】，且【#号为英文状态】，例如：#月饼#冰皮月饼。注意：【没有添加标签】、【标签输入错误】和【#号输入错误】的，视为该菜谱放弃参加本次活动。
         2. 活动只限【首次审核】的菜谱，提交二次审核的不算参与活动。注意：在没有发放活动积分之前，请不要提交二次审核（提交二次审核后，标签不会保留,视为没有参与活动）。
         3. 菜谱必须是月饼的菜谱，或者是由月饼做成的菜谱。
         4. 参与活动的菜谱：个数不限；必须原创；必须独家；禁止重复。
         5. 活动的最终解释权归香哈所有。
         6. 社区会置顶[ 活动答疑贴 ]，实时更新和答疑，请及时查看和反馈在该帖下，或者及时联系管理员。

         三、 奖励积分：

         1. 首次审核为优质菜谱：额外奖励50积分
         2. 首次审核为精华菜谱：额外奖励100积分
         3. 发放时间：
         活动结束后，统一发放（9月2日或者9月5日）
         * url : caidanDetail.app?type=caidan&g1=2314
         * imgs : http://s1.cdn.xiangha.com/caipu/201509/2023/202330256519.jpg/MTAwMHgw
         */

        private List<TopicBean> topic;
        private List<String> adDishInfo;
        private List<?> proBitBox;

        public AdTieInfoBean getAdTieInfo() {
            return adTieInfo;
        }

        public void setAdTieInfo(AdTieInfoBean adTieInfo) {
            this.adTieInfo = adTieInfo;
        }

        public ProBitPageBean getProBitPage() {
            return proBitPage;
        }

        public void setProBitPage(ProBitPageBean proBitPage) {
            this.proBitPage = proBitPage;
        }

        public List<RecommendBean> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<RecommendBean> recommend) {
            this.recommend = recommend;
        }

        public List<?> getSlide() {
            return slide;
        }

        public void setSlide(List<?> slide) {
            this.slide = slide;
        }

        public List<ActiveUserBean> getActiveUser() {
            return activeUser;
        }

        public void setActiveUser(List<ActiveUserBean> activeUser) {
            this.activeUser = activeUser;
        }

        public List<NousBean> getNous() {
            return nous;
        }

        public void setNous(List<NousBean> nous) {
            this.nous = nous;
        }

        public List<TopicBean> getTopic() {
            return topic;
        }

        public void setTopic(List<TopicBean> topic) {
            this.topic = topic;
        }

        public List<String> getAdDishInfo() {
            return adDishInfo;
        }

        public void setAdDishInfo(List<String> adDishInfo) {
            this.adDishInfo = adDishInfo;
        }

        public List<?> getProBitBox() {
            return proBitBox;
        }

        public void setProBitBox(List<?> proBitBox) {
            this.proBitBox = proBitBox;
        }

        public static class AdTieInfoBean {
            private String name;
            private String img;
            private String url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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

        public static class ProBitPageBean {
            private String name;
            private String img;
            private String url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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

        public static class RecommendBean {
            private String title;
            private String date;
            private int type;
            private String time;
            private String url;
            private String img;
            /**
             * hasVideo : 1
             * img : http://s1.cdn.xiangha.com/caipu/201608/0723/171056253993.jpg/MTAwMHgw
             */

            private List<ListBean> list;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                private String hasVideo;
                private String img;

                public String getHasVideo() {
                    return hasVideo;
                }

                public void setHasVideo(String hasVideo) {
                    this.hasVideo = hasVideo;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }
            }
        }

        public static class ActiveUserBean {
            private long code;
            private String nickName;
            private String img;
            private int hotNum;
            private String isGourmet;

            public long getCode() {
                return code;
            }

            public void setCode(long code) {
                this.code = code;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getHotNum() {
                return hotNum;
            }

            public void setHotNum(int hotNum) {
                this.hotNum = hotNum;
            }

            public String getIsGourmet() {
                return isGourmet;
            }

            public void setIsGourmet(String isGourmet) {
                this.isGourmet = isGourmet;
            }
        }

        public static class NousBean {
            private int code;
            private String title;
            private String allClick;
            private String classifyname;
            private String commentCount;
            private String img;
            private String isUrl;

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getAllClick() {
                return allClick;
            }

            public void setAllClick(String allClick) {
                this.allClick = allClick;
            }

            public String getClassifyname() {
                return classifyname;
            }

            public void setClassifyname(String classifyname) {
                this.classifyname = classifyname;
            }

            public String getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(String commentCount) {
                this.commentCount = commentCount;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getIsUrl() {
                return isUrl;
            }

            public void setIsUrl(String isUrl) {
                this.isUrl = isUrl;
            }
        }

        public static class TopicBean {
            private String title;
            private String subtitle;
            private String desc;
            private String url;
            private String imgs;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getImgs() {
                return imgs;
            }

            public void setImgs(String imgs) {
                this.imgs = imgs;
            }
        }
    }
//
//    /**
//     * res : 2
//     * data : {"recommend":[{"title":"早餐食谱","date":"八月十二日","type":1,"time":"3","url":"http://appweb.xiangha.com/app5/dishList.app?type=typeRecommend&g1=1","img":"http://s1.cdn.xiangha.com/caipu/201607/3022/311304051418.jpg/MTAwMHgw","list":[{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/3022/311304051418.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/3101/310115498982.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/0613/062204129275.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201507/2409/26112428852.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/2612/261247422982.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/2417/241800571444.jpg/MTAwMHgw"}]},{"title":"中餐食谱","date":"八月十二日","type":2,"time":"3","url":"http://appweb.xiangha.com/app5/dishList.app?type=typeRecommend&g1=2","img":"http://s1.cdn.xiangha.com/caipu/201607/2912/291257146856.jpg/MTAwMHgw","list":[{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/2912/291257146856.jpg/MTAwMHgw"},{"hasVideo":"2","video":[{"id":"188","name":"双耳炒素味","vu":"1b3033b26f","img":"http://s1.cdn.xiangha.com/videoImg/201511/0316/56386fc3c71c6.png/MTAwMHgw","uu":"grpbim18nn"}],"img":"http://s1.cdn.xiangha.com/videoImg/201511/0316/56386fc3c71c6.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/0423/042313511279.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201509/2922/221458066790.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/2213/221404336287.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/0310/031010439453.jpg/MTAwMHgw"}]},{"title":"晚餐食谱","date":"八月十二日","type":3,"time":"3","url":"http://appweb.xiangha.com/app5/dishList.app?type=typeRecommend&g1=3","img":"http://s1.cdn.xiangha.com/caipu/201608/0511/051113528716.jpg/MTAwMHgw","list":[{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/0511/051113528716.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/0212/021245484737.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/0515/051500385338.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/2214/221411218455.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/2114/211454259076.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/3108/310827587981.jpg/MTAwMHgw"}]}],"slide":[],"activeUser":[{"code":36832289061,"nickName":"刘佳","img":"http://s1.cdn.xiangha.com/i/201607/2513/57959fb242edd.jpg/NTB4NTA","hotNum":3480,"isGourmet":"2"},{"code":73501344690,"nickName":"bluegirl_","img":"http://s1.cdn.xiangha.com/i/201606/0220/5750211b736ab.jpg/NTB4NTA","hotNum":2545,"isGourmet":"2"},{"code":8104846811,"nickName":"倾听-小熙","img":"http://s1.cdn.xiangha.com/i/201604/0716/57061f8654c8c.jpg/NTB4NTA","hotNum":2366,"isGourmet":"2"},{"code":5513084041,"nickName":"我家的胖娃娃","img":"http://s1.cdn.xiangha.com/i/201607/0508/577afb2a83515.jpg/NTB4NTA","hotNum":1951,"isGourmet":"2"},{"code":63642553831,"nickName":"窈-窈","img":"http://s1.cdn.xiangha.com/i/201608/0901/57a8bfd2c3b09.jpg/NTB4NTA","hotNum":1677,"isGourmet":"2"},{"code":6192564153,"nickName":"悍匪夫人","img":"http://s1.cdn.xiangha.com/i/201606/2411/576ca77195a08.jpg/NTB4NTA","hotNum":1600,"isGourmet":"2"},{"code":10882396280,"nickName":"琛琛妮妮妈","img":"http://qzapp.qlogo.cn/qzapp/215798/46CA62C6439351439DB40EA4D294EA06/100","hotNum":1566,"isGourmet":1},{"code":55041993441,"nickName":"欣绿","img":"http://s1.cdn.xiangha.com/i/201607/2521/57960f23d6056.jpg/NTB4NTA","hotNum":1424,"isGourmet":"2"},{"code":73158692910,"nickName":"KMa叶子","img":"http://s1.cdn.xiangha.com/i/201607/2723/5798d0d1b2a85.jpg/NTB4NTA","hotNum":1294,"isGourmet":"2"},{"code":37472270350,"nickName":"橘子香味","img":"http://s1.cdn.xiangha.com/i/201608/0213/57a0314fd0f68.jpg/NTB4NTA","hotNum":1189,"isGourmet":"2"}],"nous":[{"code":236500,"title":"它被誉为水中人参， 常吃有助延年益寿。","allClick":"10173","classifyname":"美食精选","commentCount":"22","img":"http://s1.cdn.xiangha.com/zhishi/201608/091751254516.png/OTgweDA","isUrl":"nousList.app?type=new"},{"code":236494,"title":"看奥运、护肝脏，两样都不能误！","allClick":"6148","classifyname":"健康养生","commentCount":"17","img":"http://s1.cdn.xiangha.com/zhishi/201608/091743467099.jpg/OTgweDA","isUrl":"nousList.app?type=new"}],"topic":[{"title":"活动 | 七夕不将就 美食有格调","subtitle":"100道菜谱","desc":"部分优秀作品展示！！！\r\n\r\n---------------------------------\r\n\r\n活动来了！！！\r\n\r\n七夕活动重磅来袭！！！\r\n\r\n请点击查看，参与活动的正确姿势！！！\r\n\r\n点击展开，查看活动详情\u2026\u2026&gt;&gt;\r\n\r\n七夕节到了，你为了心爱的另一半，是要和他/她去吃法餐？看电影还是甜蜜约会？年年过七夕，可送什么礼物，送什么花，给什么惊喜却要一变再变？\r\n不要苦恼，香哈君手把手教学。俗话说留住一个人就要拴住他/她的胃，为了心爱的那个TA，准备一份甜蜜又不失惊喜的温暖餐饭吧。\r\n\r\n一、活动时间：\r\n\r\n8月4日18点\u2014\u20148月14日24点\r\n\r\n二、参与方式及要求：\r\n\r\n1.上传有关七夕的菜谱，菜谱名前【添加#七夕#标签】，且【#号为英文状态】，例如：#七夕#乞巧果。注意：【没有添加标签】、【标签输入错误】和【#号输入错误】的，视为该菜谱放弃参加本次活动。\r\n2. 活动只限【首次审核】的菜谱，提交二次审核的不算参与活动。\r\n3. 菜谱必须与[ 七夕 ]相关，如七夕传统美食，体现浪漫、甜蜜的菜谱都可以，中、西餐不限。\r\n4. 参与活动的菜谱：个数不限；必须原创；必须独家；禁止重复。\r\n5. 活动的最终解释权归香哈所有。\r\n6. 社区会置顶[ 活动答疑贴 ]，实时更新和答疑，请及时查看和反馈在该帖下，或者及时联系小秘书。\r\n\r\n三、 奖励积分：\r\n\r\n1. 首次审核为优质菜谱：额外奖励50积分\r\n2. 首次审核为精华菜谱：额外奖励100积分\r\n3. 发放时间：\r\n   活动结束后，统一发放（8月16日，8月17日）","url":"caidanDetail.app?type=caidan&g1=2300","imgs":"http://s1.cdn.xiangha.com/caipu/201608/1115/11154955160.jpg/MTAwMHgw"},{"title":"入口迷醉，沉溺沙拉的好味","subtitle":"31道菜谱","desc":"沙拉是一种非常营养健康的饮食方法。首先它大多不必加热，这样会最大限度的保持住果蔬中的各种营养不至于被破坏或流失。其次，沙拉大多选择3种以上的果蔬同食，做法十分简单，在营养上也会起到很好的互补作用，也具有很好的减肥、美容、养颜的作用。","url":"caidanDetail.app?type=caidan&g1=2293","imgs":"http://s1.cdn.xiangha.com/caipu/201607/0600/061035293721.jpg/MTAwMHgw"},{"title":"烘焙新店 特价满减\t","subtitle":"新良面粉3.89元 总统淡奶油36.84元\t","desc":"新良面粉3.89元 总统淡奶油36.84元\t","imgs":"http://s1.cdn.xiangha.com/www/201608/111008244075.png/MTAwMHgw","url":"http://m.ds.xiangha.com/v1/topic/getTopicInfo?topic_code=2730&fr1=_share"}],"adDishInfo":[""],"adTieInfo":[""],"proBitPage":"","proBitBox":[]}
//     * append : []
//     */
//
//    private int res;
//    /**
//     * recommend : [{"title":"早餐食谱","date":"八月十二日","type":1,"time":"3","url":"http://appweb.xiangha.com/app5/dishList.app?type=typeRecommend&g1=1","img":"http://s1.cdn.xiangha.com/caipu/201607/3022/311304051418.jpg/MTAwMHgw","list":[{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/3022/311304051418.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/3101/310115498982.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/0613/062204129275.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201507/2409/26112428852.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/2612/261247422982.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/2417/241800571444.jpg/MTAwMHgw"}]},{"title":"中餐食谱","date":"八月十二日","type":2,"time":"3","url":"http://appweb.xiangha.com/app5/dishList.app?type=typeRecommend&g1=2","img":"http://s1.cdn.xiangha.com/caipu/201607/2912/291257146856.jpg/MTAwMHgw","list":[{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/2912/291257146856.jpg/MTAwMHgw"},{"hasVideo":"2","video":[{"id":"188","name":"双耳炒素味","vu":"1b3033b26f","img":"http://s1.cdn.xiangha.com/videoImg/201511/0316/56386fc3c71c6.png/MTAwMHgw","uu":"grpbim18nn"}],"img":"http://s1.cdn.xiangha.com/videoImg/201511/0316/56386fc3c71c6.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/0423/042313511279.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201509/2922/221458066790.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/2213/221404336287.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/0310/031010439453.jpg/MTAwMHgw"}]},{"title":"晚餐食谱","date":"八月十二日","type":3,"time":"3","url":"http://appweb.xiangha.com/app5/dishList.app?type=typeRecommend&g1=3","img":"http://s1.cdn.xiangha.com/caipu/201608/0511/051113528716.jpg/MTAwMHgw","list":[{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/0511/051113528716.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/0212/021245484737.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201608/0515/051500385338.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/2214/221411218455.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/2114/211454259076.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/3108/310827587981.jpg/MTAwMHgw"}]}]
//     * slide : []
//     * activeUser : [{"code":36832289061,"nickName":"刘佳","img":"http://s1.cdn.xiangha.com/i/201607/2513/57959fb242edd.jpg/NTB4NTA","hotNum":3480,"isGourmet":"2"},{"code":73501344690,"nickName":"bluegirl_","img":"http://s1.cdn.xiangha.com/i/201606/0220/5750211b736ab.jpg/NTB4NTA","hotNum":2545,"isGourmet":"2"},{"code":8104846811,"nickName":"倾听-小熙","img":"http://s1.cdn.xiangha.com/i/201604/0716/57061f8654c8c.jpg/NTB4NTA","hotNum":2366,"isGourmet":"2"},{"code":5513084041,"nickName":"我家的胖娃娃","img":"http://s1.cdn.xiangha.com/i/201607/0508/577afb2a83515.jpg/NTB4NTA","hotNum":1951,"isGourmet":"2"},{"code":63642553831,"nickName":"窈-窈","img":"http://s1.cdn.xiangha.com/i/201608/0901/57a8bfd2c3b09.jpg/NTB4NTA","hotNum":1677,"isGourmet":"2"},{"code":6192564153,"nickName":"悍匪夫人","img":"http://s1.cdn.xiangha.com/i/201606/2411/576ca77195a08.jpg/NTB4NTA","hotNum":1600,"isGourmet":"2"},{"code":10882396280,"nickName":"琛琛妮妮妈","img":"http://qzapp.qlogo.cn/qzapp/215798/46CA62C6439351439DB40EA4D294EA06/100","hotNum":1566,"isGourmet":1},{"code":55041993441,"nickName":"欣绿","img":"http://s1.cdn.xiangha.com/i/201607/2521/57960f23d6056.jpg/NTB4NTA","hotNum":1424,"isGourmet":"2"},{"code":73158692910,"nickName":"KMa叶子","img":"http://s1.cdn.xiangha.com/i/201607/2723/5798d0d1b2a85.jpg/NTB4NTA","hotNum":1294,"isGourmet":"2"},{"code":37472270350,"nickName":"橘子香味","img":"http://s1.cdn.xiangha.com/i/201608/0213/57a0314fd0f68.jpg/NTB4NTA","hotNum":1189,"isGourmet":"2"}]
//     * nous : [{"code":236500,"title":"它被誉为水中人参， 常吃有助延年益寿。","allClick":"10173","classifyname":"美食精选","commentCount":"22","img":"http://s1.cdn.xiangha.com/zhishi/201608/091751254516.png/OTgweDA","isUrl":"nousList.app?type=new"},{"code":236494,"title":"看奥运、护肝脏，两样都不能误！","allClick":"6148","classifyname":"健康养生","commentCount":"17","img":"http://s1.cdn.xiangha.com/zhishi/201608/091743467099.jpg/OTgweDA","isUrl":"nousList.app?type=new"}]
//     * topic : [{"title":"活动 | 七夕不将就 美食有格调","subtitle":"100道菜谱","desc":"部分优秀作品展示！！！\r\n\r\n---------------------------------\r\n\r\n活动来了！！！\r\n\r\n七夕活动重磅来袭！！！\r\n\r\n请点击查看，参与活动的正确姿势！！！\r\n\r\n点击展开，查看活动详情\u2026\u2026&gt;&gt;\r\n\r\n七夕节到了，你为了心爱的另一半，是要和他/她去吃法餐？看电影还是甜蜜约会？年年过七夕，可送什么礼物，送什么花，给什么惊喜却要一变再变？\r\n不要苦恼，香哈君手把手教学。俗话说留住一个人就要拴住他/她的胃，为了心爱的那个TA，准备一份甜蜜又不失惊喜的温暖餐饭吧。\r\n\r\n一、活动时间：\r\n\r\n8月4日18点\u2014\u20148月14日24点\r\n\r\n二、参与方式及要求：\r\n\r\n1.上传有关七夕的菜谱，菜谱名前【添加#七夕#标签】，且【#号为英文状态】，例如：#七夕#乞巧果。注意：【没有添加标签】、【标签输入错误】和【#号输入错误】的，视为该菜谱放弃参加本次活动。\r\n2. 活动只限【首次审核】的菜谱，提交二次审核的不算参与活动。\r\n3. 菜谱必须与[ 七夕 ]相关，如七夕传统美食，体现浪漫、甜蜜的菜谱都可以，中、西餐不限。\r\n4. 参与活动的菜谱：个数不限；必须原创；必须独家；禁止重复。\r\n5. 活动的最终解释权归香哈所有。\r\n6. 社区会置顶[ 活动答疑贴 ]，实时更新和答疑，请及时查看和反馈在该帖下，或者及时联系小秘书。\r\n\r\n三、 奖励积分：\r\n\r\n1. 首次审核为优质菜谱：额外奖励50积分\r\n2. 首次审核为精华菜谱：额外奖励100积分\r\n3. 发放时间：\r\n   活动结束后，统一发放（8月16日，8月17日）","url":"caidanDetail.app?type=caidan&g1=2300","imgs":"http://s1.cdn.xiangha.com/caipu/201608/1115/11154955160.jpg/MTAwMHgw"},{"title":"入口迷醉，沉溺沙拉的好味","subtitle":"31道菜谱","desc":"沙拉是一种非常营养健康的饮食方法。首先它大多不必加热，这样会最大限度的保持住果蔬中的各种营养不至于被破坏或流失。其次，沙拉大多选择3种以上的果蔬同食，做法十分简单，在营养上也会起到很好的互补作用，也具有很好的减肥、美容、养颜的作用。","url":"caidanDetail.app?type=caidan&g1=2293","imgs":"http://s1.cdn.xiangha.com/caipu/201607/0600/061035293721.jpg/MTAwMHgw"},{"title":"烘焙新店 特价满减\t","subtitle":"新良面粉3.89元 总统淡奶油36.84元\t","desc":"新良面粉3.89元 总统淡奶油36.84元\t","imgs":"http://s1.cdn.xiangha.com/www/201608/111008244075.png/MTAwMHgw","url":"http://m.ds.xiangha.com/v1/topic/getTopicInfo?topic_code=2730&fr1=_share"}]
//     * adDishInfo : [""]
//     * adTieInfo : [""]
//     * proBitPage :
//     * proBitBox : []
//     */
//
//    private DataBean data;
//   // private List<?> append;
//
//    public int getRes() {
//        return res;
//    }
//
//    public void setRes(int res) {
//        this.res = res;
//    }
//
//    public DataBean getData() {
//        return data;
//    }
//
//    public void setData(DataBean data) {
//        this.data = data;
//    }
//
////    public List<?> getAppend() {
////        return append;
////    }
////
////    public void setAppend(List<?> append) {
////        this.append = append;
////    }
//
//    public static class DataBean {
//        private String proBitPage;
//        /**
//         * title : 早餐食谱
//         * date : 八月十二日
//         * type : 1
//         * time : 3
//         * url : http://appweb.xiangha.com/app5/dishList.app?type=typeRecommend&g1=1
//         * img : http://s1.cdn.xiangha.com/caipu/201607/3022/311304051418.jpg/MTAwMHgw
//         * list : [{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/3022/311304051418.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/3101/310115498982.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/0613/062204129275.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201507/2409/26112428852.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/2612/261247422982.jpg/MTAwMHgw"},{"hasVideo":"1","img":"http://s1.cdn.xiangha.com/caipu/201607/2417/241800571444.jpg/MTAwMHgw"}]
//         */
//
//        private List<RecommendBean> recommend;
//        private List<?> slide;
//        /**
//         * code : 36832289061
//         * nickName : 刘佳
//         * img : http://s1.cdn.xiangha.com/i/201607/2513/57959fb242edd.jpg/NTB4NTA
//         * hotNum : 3480
//         * isGourmet : 2
//         */
//
//        private List<ActiveUserBean> activeUser;
//        /**
//         * code : 236500
//         * title : 它被誉为水中人参， 常吃有助延年益寿。
//         * allClick : 10173
//         * classifyname : 美食精选
//         * commentCount : 22
//         * img : http://s1.cdn.xiangha.com/zhishi/201608/091751254516.png/OTgweDA
//         * isUrl : nousList.app?type=new
//         */
//
//        private List<NousBean> nous;
//        /**
//         * title : 活动 | 七夕不将就 美食有格调
//         * subtitle : 100道菜谱
//         * desc : 部分优秀作品展示！！！
//
//         ---------------------------------
//
//         活动来了！！！
//
//         七夕活动重磅来袭！！！
//
//         请点击查看，参与活动的正确姿势！！！
//
//         点击展开，查看活动详情……&gt;&gt;
//
//         七夕节到了，你为了心爱的另一半，是要和他/她去吃法餐？看电影还是甜蜜约会？年年过七夕，可送什么礼物，送什么花，给什么惊喜却要一变再变？
//         不要苦恼，香哈君手把手教学。俗话说留住一个人就要拴住他/她的胃，为了心爱的那个TA，准备一份甜蜜又不失惊喜的温暖餐饭吧。
//
//         一、活动时间：
//
//         8月4日18点——8月14日24点
//
//         二、参与方式及要求：
//
//         1.上传有关七夕的菜谱，菜谱名前【添加#七夕#标签】，且【#号为英文状态】，例如：#七夕#乞巧果。注意：【没有添加标签】、【标签输入错误】和【#号输入错误】的，视为该菜谱放弃参加本次活动。
//         2. 活动只限【首次审核】的菜谱，提交二次审核的不算参与活动。
//         3. 菜谱必须与[ 七夕 ]相关，如七夕传统美食，体现浪漫、甜蜜的菜谱都可以，中、西餐不限。
//         4. 参与活动的菜谱：个数不限；必须原创；必须独家；禁止重复。
//         5. 活动的最终解释权归香哈所有。
//         6. 社区会置顶[ 活动答疑贴 ]，实时更新和答疑，请及时查看和反馈在该帖下，或者及时联系小秘书。
//
//         三、 奖励积分：
//
//         1. 首次审核为优质菜谱：额外奖励50积分
//         2. 首次审核为精华菜谱：额外奖励100积分
//         3. 发放时间：
//         活动结束后，统一发放（8月16日，8月17日）
//         * url : caidanDetail.app?type=caidan&g1=2300
//         * imgs : http://s1.cdn.xiangha.com/caipu/201608/1115/11154955160.jpg/MTAwMHgw
//         */
//
//        private List<TopicBean> topic;
//        private List<String> adDishInfo;
//        private List<String> adTieInfo;
//        private List<?> proBitBox;
//
//        public String getProBitPage() {
//            return proBitPage;
//        }
//
//        public void setProBitPage(String proBitPage) {
//            this.proBitPage = proBitPage;
//        }
//
//        public List<RecommendBean> getRecommend() {
//            return recommend;
//        }
//
//        public void setRecommend(List<RecommendBean> recommend) {
//            this.recommend = recommend;
//        }
//
//        public List<?> getSlide() {
//            return slide;
//        }
//
//        public void setSlide(List<?> slide) {
//            this.slide = slide;
//        }
//
//        public List<ActiveUserBean> getActiveUser() {
//            return activeUser;
//        }
//
//        public void setActiveUser(List<ActiveUserBean> activeUser) {
//            this.activeUser = activeUser;
//        }
//
//        public List<NousBean> getNous() {
//            return nous;
//        }
//
//        public void setNous(List<NousBean> nous) {
//            this.nous = nous;
//        }
//
//        public List<TopicBean> getTopic() {
//            return topic;
//        }
//
//        public void setTopic(List<TopicBean> topic) {
//            this.topic = topic;
//        }
//
//        public List<String> getAdDishInfo() {
//            return adDishInfo;
//        }
//
//        public void setAdDishInfo(List<String> adDishInfo) {
//            this.adDishInfo = adDishInfo;
//        }
//
//        public List<String> getAdTieInfo() {
//            return adTieInfo;
//        }
//
//        public void setAdTieInfo(List<String> adTieInfo) {
//            this.adTieInfo = adTieInfo;
//        }
//
//        public List<?> getProBitBox() {
//            return proBitBox;
//        }
//
//        public void setProBitBox(List<?> proBitBox) {
//            this.proBitBox = proBitBox;
//        }
//
//        public static class RecommendBean {
//            private String title;
//            private String date;
//            private int type;
//            private String time;
//            private String url;
//            private String img;
//            /**
//             * hasVideo : 1
//             * img : http://s1.cdn.xiangha.com/caipu/201607/3022/311304051418.jpg/MTAwMHgw
//             */
//
//            private List<ListBean> list;
//
//            public String getTitle() {
//                return title;
//            }
//
//            public void setTitle(String title) {
//                this.title = title;
//            }
//
//            public String getDate() {
//                return date;
//            }
//
//            public void setDate(String date) {
//                this.date = date;
//            }
//
//            public int getType() {
//                return type;
//            }
//
//            public void setType(int type) {
//                this.type = type;
//            }
//
//            public String getTime() {
//                return time;
//            }
//
//            public void setTime(String time) {
//                this.time = time;
//            }
//
//            public String getUrl() {
//                return url;
//            }
//
//            public void setUrl(String url) {
//                this.url = url;
//            }
//
//            public String getImg() {
//                return img;
//            }
//
//            public void setImg(String img) {
//                this.img = img;
//            }
//
//            public List<ListBean> getList() {
//                return list;
//            }
//
//            public void setList(List<ListBean> list) {
//                this.list = list;
//            }
//
//            public static class ListBean {
//                private String hasVideo;
//                private String img;
//
//                public String getHasVideo() {
//                    return hasVideo;
//                }
//
//                public void setHasVideo(String hasVideo) {
//                    this.hasVideo = hasVideo;
//                }
//
//                public String getImg() {
//                    return img;
//                }
//
//                public void setImg(String img) {
//                    this.img = img;
//                }
//            }
//        }
//
//        public static class ActiveUserBean {
//            private long code;
//            private String nickName;
//            private String img;
//            private int hotNum;
//            private String isGourmet;
//
//            public long getCode() {
//                return code;
//            }
//
//            public void setCode(long code) {
//                this.code = code;
//            }
//
//            public String getNickName() {
//                return nickName;
//            }
//
//            public void setNickName(String nickName) {
//                this.nickName = nickName;
//            }
//
//            public String getImg() {
//                return img;
//            }
//
//            public void setImg(String img) {
//                this.img = img;
//            }
//
//            public int getHotNum() {
//                return hotNum;
//            }
//
//            public void setHotNum(int hotNum) {
//                this.hotNum = hotNum;
//            }
//
//            public String getIsGourmet() {
//                return isGourmet;
//            }
//
//            public void setIsGourmet(String isGourmet) {
//                this.isGourmet = isGourmet;
//            }
//        }
//
//        public static class NousBean {
//            private int code;
//            private String title;
//            private String allClick;
//            private String classifyname;
//            private String commentCount;
//            private String img;
//            private String isUrl;
//
//            public int getCode() {
//                return code;
//            }
//
//            public void setCode(int code) {
//                this.code = code;
//            }
//
//            public String getTitle() {
//                return title;
//            }
//
//            public void setTitle(String title) {
//                this.title = title;
//            }
//
//            public String getAllClick() {
//                return allClick;
//            }
//
//            public void setAllClick(String allClick) {
//                this.allClick = allClick;
//            }
//
//            public String getClassifyname() {
//                return classifyname;
//            }
//
//            public void setClassifyname(String classifyname) {
//                this.classifyname = classifyname;
//            }
//
//            public String getCommentCount() {
//                return commentCount;
//            }
//
//            public void setCommentCount(String commentCount) {
//                this.commentCount = commentCount;
//            }
//
//            public String getImg() {
//                return img;
//            }
//
//            public void setImg(String img) {
//                this.img = img;
//            }
//
//            public String getIsUrl() {
//                return isUrl;
//            }
//
//            public void setIsUrl(String isUrl) {
//                this.isUrl = isUrl;
//            }
//        }
//
//        public static class TopicBean {
//            private String title;
//            private String subtitle;
//            private String desc;
//            private String url;
//            private String imgs;
//
//            public String getTitle() {
//                return title;
//            }
//
//            public void setTitle(String title) {
//                this.title = title;
//            }
//
//            public String getSubtitle() {
//                return subtitle;
//            }
//
//            public void setSubtitle(String subtitle) {
//                this.subtitle = subtitle;
//            }
//
//            public String getDesc() {
//                return desc;
//            }
//
//            public void setDesc(String desc) {
//                this.desc = desc;
//            }
//
//            public String getUrl() {
//                return url;
//            }
//
//            public void setUrl(String url) {
//                this.url = url;
//            }
//
//            public String getImgs() {
//                return imgs;
//            }
//
//            public void setImgs(String imgs) {
//                this.imgs = imgs;
//            }
//        }
//    }

}
