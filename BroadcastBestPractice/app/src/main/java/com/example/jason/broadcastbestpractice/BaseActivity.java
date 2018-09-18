package com.example.jason.broadcastbestpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private  ForceOffineReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }


    @Override
    protected void onResume(){
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.jason.broadcastbestpractice.FORCE_OFFINE");
        receiver = new ForceOffineReceiver();
        registerReceiver(receiver,intentFilter);

    }

    @Override
    protected void onPause(){
        super.onPause();
        if(receiver != null){
            unregisterReceiver(receiver);
            receiver = null;
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    class ForceOffineReceiver extends BroadcastReceiver{
        @Override
        public void  onReceive(final Context context, Intent intent){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("警告");
            builder.setMessage("你的账号在别处登陆，本地强制下线\uD83D\uDE48");
            builder.setCancelable(false);
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAll();  //销毁所以活动

                    Intent intent = new Intent(context,LoginActivity.class);
                    context.startActivity(intent);  //重启 Login



                }
            });
            builder.show();
        }
    }
}
