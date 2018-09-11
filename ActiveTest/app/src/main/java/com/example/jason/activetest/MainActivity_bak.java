package com.example.jason.activetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity_bak extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent intent = new Intent(MainActivity.this,SenondActivity.class);
        Button button = (Button)findViewById(R.id.button1) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "hello second";
//                Intent intent = new Intent("com.example.jason.activetest_ACTION_START");
                Intent intent = new Intent(MainActivity_bak.this,SenondActivity.class);
                startActivityForResult(intent,1);
                //传递数据
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode)
        {
            case 1:
                if(resultCode == RESULT_OK)
                {
                    String returnedData = data.getStringExtra("data_result");
                    Log.d("firtst",returnedData);  String returnData = data.getStringExtra("data_result");

                }
          break;
            default:
        }


    }
}
