package com.qianfeng.imageviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView iv3, iv4, iv5, iv6, iv7;
    String[] pics = {"http://pic39.nipic.com/20140312/18139764_213952642155_2.jpg", "http://scimg.jb51.net/allimg/150705/14-150F516000V37.jpg", "http://pic27.nipic.com/20130228/4057287_163613380190_2.jpg", "http://f.hiphotos.baidu.com/image/pic/item/80cb39dbb6fd5266fd25a12eac18972bd40736f9.jpg", "http://h.hiphotos.baidu.com/image/pic/item/b7fd5266d0160924842b3f21d30735fae6cd34f9.jpg"};
    ImageView[] iv;
    private EditText picPath;
    private TextView textTips;

    private ImageView resultIv;
    @FindView(R.id.zhujieiv)
    @GetPic("http://pic39.nipic.com/20140312/18139764_213952642155_2.jpg")
    private ImageView zhujieiv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quanzhujie);
        FindViewInject.inject(this);
        this.findViewById(R.id.zhujieiv);
//        iv3 = (ImageView) findViewById(R.id.iv3);//找到图片控件
//        iv4 = (ImageView) findViewById(R.id.iv4);//找到图片控件
//        iv5 = (ImageView) findViewById(R.id.iv5);//找到图片控件
//        iv6 = (ImageView) findViewById(R.id.iv6);//找到图片控件
//        iv7 = (ImageView) findViewById(R.id.iv7);//找到图片控件
//        iv = new ImageView[]{iv3, iv4, iv5, iv6, iv7};
//        for (int i = 0; i < pics.length; i++) {
//            final int finalI = i;
//            Utils.getPic(pics[i], new Utils.handleDataListner() {//上网请求图片展示
//                @Override
//                public void handleData(final byte[] bs) {
//                  runOnUiThread(new Runnable() {
//                      @Override
//                      public void run() {
//                          Bitmap bitmap= BitmapFactory.decodeByteArray(bs,0,bs.length);
//                          iv[finalI].setImageBitmap(bitmap);
//                      }
//                  });
//                }
//            });
//        }
//        Drawable drawable = getResources().getDrawable(R.mipmap.libingbing);
//        iv3.setImageDrawable(drawable);
        //  iv3.setImageResource(R.mipmap.liuyifei);
//        Bitmap mBitmap = Bitmap.createBitmap(100,100, Bitmap.Config.RGB_565);
//        Bitmap mBitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()+"/liuyifei.jpeg");
//        iv3.setImageBitmap(mBitmap);
//        iv3.setDrawingCacheEnabled(true);//设置允许图片缓存
//        iv3.buildDrawingCache();//构建缓存
//        Drawable drawable = iv3.getDrawable();//获取图片控件上面的图片内容
//        iv4.setImageDrawable(drawable);
//        iv3.setDrawingCacheEnabled(false);//用完记得关闭缓存
        //----------综合练习
//        picPath = (EditText) findViewById(R.id.address);//图片地址的输入框
//        textTips = (TextView) findViewById(R.id.texttips);//提示文本的控件
//        resultIv = (ImageView) findViewById(R.id.iv);//显示图片的控件
    }
//综合练习的点击事件
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.download:
//                String path = picPath.getText().toString().trim();//获取下载地址
//                if (!TextUtils.isEmpty(path)) {//判断地址是否为空,不为空才执行
//                    Utils.getPic(path, new Utils.handleDataListner() {
//                        @Override
//                        public void handleData(final byte[] bs) {
//                            final Bitmap bitmap = BitmapFactory.decodeByteArray(bs, 0, bs.length);//放到外面,因为是耗时操作
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    resultIv.setImageBitmap(bitmap);
//                                }
//                            });
//                        }
//
//                        @Override
//                        public void onProgressUpdata(final int totallength, final int currnetLenght) {
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    if (totallength == currnetLenght) {
//                                        textTips.setText("下载完成");
//                                    } else {
//                                        textTips.setText("下载进度" + currnetLenght + "/" + totallength);
//                                    }
//                                }
//                            });
//                        }
//                    });
//                }
//
//                break;
//        }
//    }
}
