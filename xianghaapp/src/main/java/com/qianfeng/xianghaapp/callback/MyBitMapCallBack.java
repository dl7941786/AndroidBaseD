package com.qianfeng.xianghaapp.callback;

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

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.Toast;

import com.qianfeng.xianghaapp.model.MvpModel;
import com.qianfeng.xianghaapp.utils.MyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by jackiechan on 16/8/12.
 */
public class MyBitMapCallBack implements MvpModel.OnLoadCompleteListener {
    private ImageView imageView;

    public MyBitMapCallBack(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public void onLoadComplete(final String path, byte[] bytes) {
        if (bytes == null) {
            return;
        }
        String tag = (String) imageView.getTag();
        if (tag != null && tag.equals(path)&&imageView!=null) {
            final Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            imageView.setImageBitmap(bitmap);
          new Thread(){
              @Override
              public void run() {
                  try {
                      File externalCacheDir = imageView.getContext().getExternalCacheDir();//获取 外部存储Android 目录中的私有 cache
                      if (MyUtils.isEnoughForCache()) {
                          //缓存一下图片
                          //创建文件输出流,将图片转成文件
                          String name = path.replaceAll("/", "");//为了防止网址中的/导致文件名变成文件夹名,所以去掉/
                          FileOutputStream fos = new FileOutputStream(new File(externalCacheDir, name + ".jpg"));//用图片的网址作为文件的名字,来确保大约的唯一性
                          // fos.write(bytes, 0, bytes.length);
//                fos.write(bytes);
//                fos.close();
                          bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);//将图片写成文件
                          fos.close();//关流
                      }else{
                          Toast.makeText(imageView.getContext(),"空间不足,换手机吧",Toast.LENGTH_SHORT).show();
                          MyUtils.deleteFile(externalCacheDir);//清空内部内容
                      }
                  } catch (FileNotFoundException e) {
                      e.printStackTrace();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
          }.start();
        }
    }
}
