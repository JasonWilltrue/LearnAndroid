package com.example.jason.onecode_fragmenttest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;

public class NewsContentActivity extends AppCompatActivity {
     public static void actionStart(Context context,String newsTitle,String newsContent){
         Intent intent = new Intent(context,NewsContentActivity.class);
         intent.putExtra("news_title",newsTitle);
         intent.putExtra("news_content",newsContent);
         context.startActivity(intent);
     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        String newsTitle = getIntent().getStringExtra("news_title");
        String newsContent = getIntent().getStringExtra("news_content");
        NewsContentFragment newsContentFragment = (NewsContentFragment) getSupportFragmentManager
                ().findFragmentById(R.id.news_content_fragment);
        //调用刷新方法
        newsContentFragment.refresh(newsTitle,newsContent);
    }


}
