package com.example.jason.onecode_notifitest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNotic_Btn(View view) {
        //创建通知跳转的意图
        Intent intent = new Intent(this,NotificationActivity.class);
        //创建延迟 意图  第三个参数intet
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
        //获取NotificationManager的实例  需要勇到get方法 传入系统的NOTIFICATION_SERVICE参数
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //build构造器来创建Notification对象
        Notification notification = new Notification.Builder(this)
                .setContentTitle("通知标题")
                .setContentText("通知内容xxxxx你说什么就是什么")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                //如果没有下面这种退出弹窗消息会一直显示在下拉菜单中(第一种方法）
                .setAutoCancel(true)
                .setContentIntent(pi)
                .build();
        //让通知显示出来 参数id  notic对象
        manager.notify(1,notification);





    }
}
