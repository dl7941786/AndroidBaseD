package com.qianfeng.sqlitedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase database;
    private EditText editText;
    private MyOpenHelper myOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //数据库的帮助类
        myOpenHelper = new MyOpenHelper(this);
        //获取写的数据库工具类,如果数据库满了,就直接出错挂了
        //database = myOpenHelper.getWritableDatabase();
//        SQLiteDatabase readableDatabase = myOpenHelper.getReadableDatabase();//获取读的数据库工具类,但是也可以写入数据,如果数据库满了,就只能读
        editText = (EditText) findViewById(R.id.et);
    }

    public void onClick(View view) {
        //获取写的数据库工具类,如果数据库满了,就直接出错挂了
        database = myOpenHelper.getWritableDatabase();
        switch (view.getId()) {
            case R.id.add://增加
                database.execSQL("insert into person (name,age,gender) values('五分钱','18','女');");
                break;
            case R.id.delete:
                String trim = editText.getText().toString().trim();
                int id = Integer.parseInt(trim);
                database.execSQL("delete from person where _id =?;", new Object[]{id});
//                database.execSQL("delete from person where _id ="+id+";");//效果同上
                break;
            case R.id.update:
                database.execSQL("update person set name='五分钱,放学别走',age='19' where _id =3 ");
                break;
            case R.id.query:
                //因为execSQL没有返回结果,所以对于查询来说,并没有什么用
                break;
            case R.id.addnew:
                //用新的方式去执行操作
                ContentValues contentValues = new ContentValues();//键值对的对象
                contentValues.put("name","hzz");//键必须是表的中列名
                contentValues.put("age",99);
                contentValues.put("gender","男");
                //返回值,当前插入的数据在表里面是第几行(已经被删除的也算),与导出数据库文件看到的行数可能不一致,失败返回-1
                long insert = database.insert("person", null, contentValues);//将键值对的内容插入到 person中
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + insert);
                break;
            case R.id.deletenew:
                // 记住查询条件后要跟占位符?,否则你就等着炸了(雷炸了)
                //返回值,删除了几条
                int delete = database.delete("person", "name=?", new String[]{"hzz"});
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + delete);
                break;
            case R.id.updatenew:
                ContentValues updateContentValues = new ContentValues();
                updateContentValues.put("name","five fen money,fang school no zou");
                updateContentValues.put("age", 20);
                //返回值,更新了几条
                int update = database.update("person", updateContentValues, "name=?", new String[]{"hzz"});
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + update);
                break;
            case R.id.querynew:
                //查询 person ,返回所有数据
                //参数1 查询的表,2想要返回的列,如果返回全部就写 null, 3 where 条件,如果没有条件,就写 null, 4 查询条件对应的值,
                //Cursor person = database.query("person", null, null, null, null, null, null);
                Cursor person = database.query("person", new String[]{"name"}, "name=?", new String[]{"hzz"}, null, null, null);
                while (person.moveToNext()) {//如果有下一条数据,就移动到下一条的位置
                    int nameIndex = person.getColumnIndex("name");//根据列名获取列的索引值
                    String personName = person.getString(nameIndex);//根据列的索引把列的值取出来
//                    int ageIndex = person.getColumnIndex("age");//如果没有这一列就返回-1
//                    String personAge = person.getString(ageIndex);
//                    int genderIndex = person.getColumnIndex("gender");
//                    String personGender = person.getString(genderIndex);
//                    Log.e("自定义标签", "类名==MainActivity" + "name=:" + personName+"age="+personAge+"gender="+personGender);
                    Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + personName);
                }
                person.close();//用完要关掉,除非是用作显示 listview 数据的时候
                break;
        }
        database.close();//数据库用完要关掉
    }
}
