package com.example.jason.onecode_notifitest;

import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        //第二种点击消息之后 取消通知图标的方法
//        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //1代表什么 创建通知时候给每条通知指定的id
//        manager.cancel(1);
    }
}
