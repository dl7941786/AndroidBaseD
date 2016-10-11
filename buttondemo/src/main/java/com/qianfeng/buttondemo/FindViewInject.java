package com.qianfeng.buttondemo;

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

import android.app.Activity;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by jackiechan on 16/8/2.
 */
public class FindViewInject {
    public static void inject(Activity activity) {
        try {
            Class<? extends Activity> aClass = activity.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                Log.e("自定义标签", "类名==FindViewInject" + "方法名==inject=====:" + declaredField.getGenericType().toString());
                if (View.class.isAssignableFrom(declaredField.getType())&& !Modifier.isStatic(declaredField.getModifiers())) {//判断当前的变量是不是 view 类型
                    FindView annotation = declaredField.getAnnotation(FindView.class);//获取当前控件身上的FindView类型的注解,可能为空
                    if (annotation != null) {//身上有注解
                        int id = annotation.value();//获取注解的值,值就是 findviewbyid的 id
                        //拿到 id 需要调用 activity 的 findviewbyid 方法
                        Method findViewById = aClass.getMethod("findViewById", int.class);//查找类里面的名字叫findViewById 参数为 int类型的方法
                        Object invoke = findViewById.invoke(activity, id);//通过 findviewbyid 返回的对象,这个对象就是我们遍历到的 field 对象应该的值
                        declaredField.setAccessible(true);//首先为了避免是私有的,设置为允许访问
                        declaredField.set(activity, invoke);//将返回值设置给我们指定对象的指定变量

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
