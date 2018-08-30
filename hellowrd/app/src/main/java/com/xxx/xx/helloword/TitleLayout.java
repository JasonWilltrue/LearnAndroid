package com.xxx.xx.helloword;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.jar.Attributes;

public class TitleLayout extends LinearLayout{


    public  TitleLayout(Context context, Attributes attrs){
         super(context, (AttributeSet) attrs);
         LayoutInflater.from(context).inflate(R.layout.title,this);
         Button buttonback = (Button)findViewById(R.id.title_back);
         Button buttonedit = (Button)findViewById(R.id.title_edit);
         buttonback.setOnClickListener(new OnClickListener() {
             @Override
             public void onClick(View v) {
                 ((Activity).getContext()).finish();
             }
         });
     }



}
