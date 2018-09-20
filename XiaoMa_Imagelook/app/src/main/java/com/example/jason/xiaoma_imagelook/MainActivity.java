package com.example.jason.xiaoma_imagelook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //从网络读取photo.txt 封装成 ArrayList《String》
        //创建一个索引变量
        //根据索引取出某一个字符串  更加网址获取图片显示到控件上来

//        获取ui控件

        mImageView = (ImageView) findViewById(R.id.image_iv);
        Button preBtn = (Button) findViewById(R.id.preBtn);
        Button nextBtn = (Button) findViewById(R.id.nextBtn);


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        preBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    //获取网络地址
    private String getImageUrl() {

    }
}
