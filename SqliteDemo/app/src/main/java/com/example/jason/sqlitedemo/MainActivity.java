package com.example.jason.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            File file = new File(getFilesDir(),"haha.txt");
            //           第二种方式创建输出流
//            FileOutputStream fos = new FileOutputStream(file);
            //写入数据库文件
            file.createNewFile();
            //创建数据库文件
            DbOpenHelper helper = new DbOpenHelper(this);
            helper.getReadableDatabase();




        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
