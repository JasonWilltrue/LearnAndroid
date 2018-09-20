package com.example.jason.xiaomao_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        1.有了ui控件了
         lv = (ListView) findViewById(R.id.lv);

//         2. 创建数据
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datas.add("列表序列"+i);
        }

        //3.控件与数据如何绑定
        MyAdapter myAdapter = new MyAdapter(this,datas);
        lv.setAdapter(myAdapter);
    }
}
