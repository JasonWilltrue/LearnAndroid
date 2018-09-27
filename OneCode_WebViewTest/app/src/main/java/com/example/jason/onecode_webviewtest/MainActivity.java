package com.example.jason.onecode_webviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       WebView webView =  (WebView) findViewById(R.id.web_view);
       webView.getSettings().setJavaScriptEnabled(true);
       webView.setWebViewClient(new WebViewClient());//作用 网页之间跳转还是存在同一个webview中
       webView.loadUrl("http://www.baidu.com");
    }
}
