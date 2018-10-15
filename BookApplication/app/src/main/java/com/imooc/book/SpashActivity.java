package com.imooc.book;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.lang.ref.WeakReference;

import cz.msebera.android.httpclient.Header;

public class SpashActivity extends Activity {

    public static final int CODE = 1001;
    public static final int TOTAL_TIME = 3000;    //总共三秒
    public static final int INTERVAL_TIME = 1000;  //间隔时间
    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);

        mTextView = (TextView) findViewById(R.id.time_text_view);

        final MyHandler handler = new MyHandler(this);

        Message message = Message.obtain();
        message.what = CODE;
        message.arg1 = TOTAL_TIME;
        handler.sendMessage(message);

//        mTextView.setOnClickListener(this);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击跳过
               BookListActivity.start(SpashActivity.this);
                SpashActivity.this.finish();
                //必须关闭handler中的服务
                handler.removeMessages(CODE);
            }
        });


        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://www.google.com", new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                // called before request is started
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                // called when response HTTP status is "200 OK"
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }

            @Override
            public void onRetry(int retryNo) {
                // called when request is retried
            }
        });
    }

//    @Override
//    public void onClick(View v) {
//       switch (v.getId()){
//           case R.id.time_text_view:
//               //点击跳过
//               BookListActivity.start(SpashActivity.this);
//               SpashActivity.this.finish();
//               break;
//       }
//    }


    public static class MyHandler extends Handler{
        public final WeakReference<SpashActivity> mWwakReference;

        public MyHandler(SpashActivity activity){
            mWwakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            SpashActivity activity = mWwakReference.get();
            if(msg.what == CODE){
                if(activity != null){
                    //设置textview 更新UI
                    int time = msg.arg1; //第一次就是三秒
                    activity.mTextView.setText(time/INTERVAL_TIME + "秒，点击跳过");

                    //再发送倒计时
                    Message message = Message.obtain();
                    message.what = CODE;
                    message.arg1 = time-INTERVAL_TIME;
                    if(time>0){
                        //倒计时继续
                        sendMessageDelayed(message,INTERVAL_TIME);
                    }else{
                         //TODO:跳转页面
                        Toast.makeText(activity,"跳转到列表",Toast.LENGTH_SHORT).show();
                        BookListActivity.start(activity);
                        activity.finish();
                    }
                }
            }
        }
    }
}
