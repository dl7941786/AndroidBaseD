package com.qianfeng.intentdemo;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v = (ImageView) findViewById(R.id.iv);
        // Intent intent = new Intent();
//        ComponentName componentName =new ComponentName()//没有必要手动创建,因为通过 setclass 方法内部会自动创建,最终指向目标 activity
//        intent.setClassName(this, "com.qianfeng.intentdemo.Main2Activity");
//        intent.setClassName("com.qianfeng.intentdemo", "com.qianfeng.intentdemo.Main2Activity");//第二个参数,必须是全限定类名,最终相当于下面的效果
        // Intent intent1 = new Intent(this, Main2Activity.class);
//        startActivity(intent);
        //我要干什么,目标分类(action) 我的目标需不需要传递数据,Uri 就是一个字符串,通过Uri.parse(字符串) 得到,是不是有类型限制,需要类型的话,就只创建带 action的意图,然后通过 setdataandtype的方式传递数据过去
//        Intent intent2 = new Intent();
//        intent2.setAction("wohensuibian");//一个意图只能有一个 action,等同于 Intent intent2 = new Intent("wohensuibian");
//        startActivity(intent2);
        /////跳转拨号页面
//        Uri uri = Uri.parse("tel:10010");//action 需要携带的数据
//        Intent intent = new Intent(Intent.ACTION_DIAL,uri);//跳转到拨号页面
//        startActivity(intent);
        ///////////打电话
//        Uri uri = Uri.parse("tel:10010");
//        Intent intent = new Intent(Intent.ACTION_CALL, uri);
//        startActivity(intent);
        ///打开网页
//        Uri uri = Uri.parse("http://www.baidu.com");
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(uri);
//        startActivity(intent);
        ///////////
//        Uri uri = Uri.parse("http://www.baidu.com");
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(uri);
//        startActivity(intent);
//        String path= Environment.getExternalStorageDirectory() + "/liuyifei.jpeg";
//        Uri uri = Uri.parse(path);
//        Intent intent = new Intent(Intent.ACTION_VIEW);
////      intent.setType("image/*");
//        intent.setData(uri);
//        intent.setDataAndType(uri, "image/*");//MIME TYPE,  setdata和 settype data会覆盖 type, type会覆盖 data
//        startActivity(intent);
//        Uri uri = Uri.parse(Environment.getExternalStorageDirectory() + "/ch.txt");
//        Intent intent = new Intent(Intent.ACTION_VIEW);
////        intent.setData(uri);
//        intent.setDataAndType(uri, "text/*");
//        startActivity(intent);
//        Intent i = new Intent(
//                Intent.ACTION_PICK,
//                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//
//        startActivityForResult(i, 100);
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_WEB_SEARCH);
//        intent.putExtra(SearchManager.QUERY, "android123");
//        startActivity(intent);
        ///安装程序
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        //安装哪个程序
//        Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory() + File.separator + "mianshi.apk"));
//        intent.setDataAndType(uri, "application/vnd.android.package-archive");
//        startActivity(intent);
//        Intent intent = new Intent(Intent.ACTION_DELETE);
//        //卸载哪个程序
//        Uri uri = Uri.parse("package:com.mianshibang.main");
//        intent.setData(uri);
//        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            v.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
}
