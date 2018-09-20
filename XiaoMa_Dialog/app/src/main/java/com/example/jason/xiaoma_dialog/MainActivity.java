package com.example.jason.xiaoma_dialog;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    String[] items = new String[]{"美女", "金钱"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openDialog(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("是否退出");
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();
            }
        });
        builder.setNegativeButton("否", null);
        AlertDialog dilog = builder.create();
        dilog.show();
    }

    public void openDialog2(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dilog = builder.setTitle("提示").setMessage("是否退出").setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();
            }
        }).create();
        dilog.show();
    }

    public void openDialog3(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dilog = builder.setTitle("请选择").setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = items[which];
                Toast.makeText(MainActivity.this, "你选择的是" + str, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        }).setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();
            }
        }).create();
        dilog.show();
    }

    String[] multiItems = new String[]{"篮球","足球","排球"};
    boolean[] checkedItems = new boolean[]{false,false,true};
    public void openDialog4(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dilog = builder.setTitle("提示")
                .setMultiChoiceItems(multiItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                        选中什么的改变true
                        //找到当前索引改变值
                        checkedItems[which] = isChecked;
                        Toast.makeText(MainActivity.this,"选择"+which+","+isChecked,Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String toastText = "";
                //改变原有数组中的值
                for (int i = 0; i <checkedItems.length ; i++) {
                    if(checkedItems[i]){
                        toastText += multiItems[i];
                    }
                }
                Toast.makeText(MainActivity.this,"选择:"+toastText,Toast.LENGTH_SHORT).show();

                dialog.dismiss();

            }
        }).create();
        dilog.show();
    }


    public void openDialog5(View v){
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("提示");
        dialog.setMessage("正在更新...请耐心等待");
        dialog.show();
        //创建一个定时器 过5秒消失
        Timer time =new Timer();
        ;
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                //返回主线程
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                });
            }
        },2000);


    }
}
