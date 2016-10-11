package com.qianfeng.uidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private LinearLayout linearLayout;
    private RadioGroup radioGroup;
    private ImageView iv;
    private ImageView ivclicp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cliptestlayout);
//        setContentView(R.layout.radiobuttontest);
//        linearLayout = (LinearLayout) findViewById(R.id.lin);
//        TextView textView = new TextView(this);
//        textView.setTextSize(30);
//        textView.setText("这是代码创建的");
//        textView.setTextColor(Color.RED);
//        textView.setOnClickListener(this);
//        textView.setId(R.id.name);
//        linearLayout.addView(textView);
//        //InputStream inputStream = getResources().openRawResource(R.raw.helloworld);//返回一个流,剩下的事情自己搞定
//        try {
////            InputStream open = getAssets().open("aaa.txt");
//            InputStream open = getResources().getAssets().open("aaa.txt");
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
//            Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + bufferedReader.readLine());
//            bufferedReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        radioGroup = (RadioGroup) findViewById(R.id.rg);
//        radioGroup.setOnCheckedChangeListener(this);
        ///-----LEVEL
//        iv = (ImageView) findViewById(R.id.iv);
//        iv.setImageLevel(2);


//        ivclicp = (ImageView) findViewById(R.id.iv);
//        BitmapDrawable clipDrawable = (BitmapDrawable) ClipDrawable.createFromPath(Environment.getExternalStorageDirectory() + "/liuyifei.jpeg");
//        Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/liuyifei.jpeg");
//        ivclicp.setImageBitmap(bitmap);
//        ivclicp.setImageDrawable(clipDrawable);
//        ivclicp.getDrawable().setLevel(0);
    }

    int iclicp = 500;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv1:

                break;
            case R.id.name:
                Log.e("自定义标签", "onClick() called with: " + "view = [" + view + "]");
                break;
            case R.id.commit:
                String num = ((EditText) findViewById(R.id.et)).getText().toString().trim();
                if (!TextUtils.isEmpty(num)) {
                    int number = Integer.parseInt(num);
                    iv.setImageLevel(number);
                }
                break;

            case R.id.clicp://切割
//                if (iclicp < 10000) {
//                    ivclicp.getDrawable().setLevel(iclicp+=500);
//                }

//                ivclicp.getDrawable().setLevel(iclicp);
//                iclicp += 9000;


                break;
        }
    }

    int i = 0;

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.shouye:
                i = 0;

                //加载首页的内容
                break;
            case R.id.redian:
                if (i == 0) {
                    //把首页取消效果
                } else if (i == 2) {

                }
                //更改自己的效果
                //加载热点的内容
                i = 1;//更改标记
                break;
            case R.id.tupian:
                //加载内容
                i = 2;
                break;

        }
    }


}
