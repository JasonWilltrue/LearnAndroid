package com.example.jason.activetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SenondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senond);
//        Intent intent = getIntent();
////        接受数据
//        String data = intent.getStringExtra("extra_data");
//        Log.d("data: ",data);

        Button button_2 = (Button)findViewById(R.id.button2);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_result","i am back first");
                setResult(RESULT_OK,intent);
                finish();
            }
        });



    }

//    系统自带方法
    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("data_result","hello firstPage");
        setResult(RESULT_OK,intent);
        finish();
    }
}
