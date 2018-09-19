package com.example.jason.xiaoma_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        1.有了ui控件了
        Spinner sp = (Spinner) findViewById(R.id.sp);

//         2. 创建数据
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add("列表"+i);
        }

        //3.控件与数据如何绑定
        MyAdapter myAdapter = new MyAdapter(this,datas);
        sp.setAdapter(myAdapter);
    }
}
