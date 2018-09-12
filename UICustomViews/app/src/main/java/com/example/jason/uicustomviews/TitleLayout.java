package com.example.jason.uicustomviews;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.jar.Attributes;

public class TitleLayout extends LinearLayout{
    public TitleLayout(Context context, AttributeSet attrs){
         super(context,attrs);
//         动态加载布局
        LayoutInflater.from(context).inflate(R.layout.title,this);

//        自定义控件添加点击事件
        Button titleBack = (Button)findViewById(R.id.title_back);
        Button titleEdit = (Button)findViewById(R.id.title_edit);
        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"you clicke edit button",
                Toast.LENGTH_SHORT).show();
            }
        });

    }
}
