package com.xxx.xx.helloword;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.sql.BatchUpdateException;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //默认标题栏隐藏
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d("SecondActivity", "传过来的数据: "+data);

//        Button button2 = (Button)findViewById(R.id.button_2);
//        button2.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//               Intent intent = new Intent();
//               intent.putExtra("data_result","i am back first!😝");
//               setResult(RESULT_OK,intent);
//               finish();
//            }
//        });

//       自定义控件时间







    }
}
