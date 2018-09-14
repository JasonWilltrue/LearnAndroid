package com.example.jason.uibestpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_bak extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMsgs(); //初始化消息数据
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);

        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        //发送点击事件
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                Log.d(TAG, "content: " + content);
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    Log.d(TAG, "list" + msgList);
                    adapter.notifyItemInserted(msgList.size() - 1);
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);
                    inputText.setText("");
                }
            }
        });

    }


    private void initMsgs() {
        Msg msg1 = new Msg("你好,安卓", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("^_^你是个笨蛋码？", Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("赶紧赚钱去，赚很多钱去", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
        Msg msg4 = new Msg("必须的，再见了", Msg.TYPE_SENT);
        msgList.add(msg4);

    }
}
