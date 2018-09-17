package com.example.jason.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Arrays;

public class BootCompleteReceiver extends BroadcastReceiver {
    private static final String TAG = "BootCompleteReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcas
        // throw new UnsupportedOperationException("Not yet implemented");
        int[] array = {1,2,3,4,5};
        String str = Arrays.toString(array);
        Log.d(TAG, "onReceive: "+str);
        Toast.makeText(context, "欢迎回来！！！Boot complete", Toast.LENGTH_SHORT).show();
    }
}
