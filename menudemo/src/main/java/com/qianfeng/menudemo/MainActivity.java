package com.qianfeng.menudemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * optionmenu, 按菜单键出来的菜单,或者是程序右上角的按钮出来的, 1 oncreateOptionsMenu  加载布局进来, 2 onOptionsmenuItemSeletctor 监听条目的选择
 * contextmenu, 需要给具体的控件设置,设置后的效果就是长按弹出,1 oncreateContextMenu 加载布局进来 2. onContextMenuItemSelector 监听条目的选择,adapterview 需要将 menu.getmenuinfo 强转为 adapter的 info
 * popupmenu .通过代码 new 出来的, new的时候需要指定上下文和依附于的控件,然后通过获取它身上的 menuinflater 加载对应的布局, 代码设置条目的监听事件
 * popupwindow  代码 new 出来, new的时候需要指定 依附于的 view和宽高(如果不指定,需要后面再设置,否则不显示),  然后就是一些小的设置,比如可以取消, 以及视图里面的控件的事件监听, show 出来即可
 */
public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private Button button;
    private Button button2;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.bt);
        button2 = (Button) findViewById(R.id.bt2);
    }

    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.bt:
                //点击后弹出菜单
                PopupMenu popupMenu = new PopupMenu(this, button);//创建一个PopupMenu, 参数1 上下文, 参数2 依附于哪个控件
                popupMenu.getMenuInflater().inflate(R.menu.popumenu, popupMenu.getMenu());//将 menu 布局填充进来
                popupMenu.setOnMenuItemClickListener(this);//设置 menu 条目的点击事件
                popupMenu.show();//显示出来
                break;

            case R.id.bt2:
                //弹出 popupwindow
//                popupWindow = new PopupWindow(this);\
//                popupWindow.setContentView(inflate);//给 popupwindow 设置视图
                //创建对象
                if (popupWindow == null) {
                    View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_my, null);//将布局填充为 view
                    popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                }
                //以下两行代码共同使用 就可以让popuwindow 点击它外面的地方就消失
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
                //  popupWindow.setOutsideTouchable(false);//如果弹出来后 ,点击 popupwindow外的任何区域都不响应
                if (!popupWindow.isShowing()) {
                    //popupWindow.showAsDropDown(button2);
                    popupWindow.showAtLocation(button2, Gravity.CENTER, 100, 100);
                }
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.popup1:
                Toast.makeText(this, "你猜", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}
