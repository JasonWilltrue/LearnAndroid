package com.example.jason.activetest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button1) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SenondActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    /**
     * 使用了startActivityForResult
     * 上一个页面销毁后自动调用本页面的onActivityResult方法
     * @param requestCode 启动时候传入的请求吗
     * @param resultCode  处理结果
     * @param data        返回参数
     */
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode)
        {
            case 1:
                if(resultCode == RESULT_OK)
                {
                    String returnedData = data.getStringExtra("data_result");
                    Log.d("firtst数据值:",returnedData);
                }
          break;
            default:
        }


    }
}
