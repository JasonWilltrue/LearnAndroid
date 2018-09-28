package com.example.jason.onecode_servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private DownloadBinder mBinder = new DownloadBinder();

    class DownloadBinder extends Binder {
        public void startDownload(){
            Log.d("520it", "startDownload: ");

        }

        public int getProgress(){
            Log.d("520it", "getProgress: excuted");
            return 0;
        }

    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        Log.d("520it", "onClick: 绑定服务");
        return mBinder;
    }


    @Override
    public void onCreate(){
        super.onCreate();
        Log.d("520it", "onCreate: 服务创建了");
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Log.d("520it", "onStartCommand: 服务启动了");
        return super.onStartCommand(intent,flags,startId);


    }

   @Override
    public void onDestroy(){
        super.onDestroy();
       Log.d("520it", "onDestroy: 服务销毁了");

   }
}
