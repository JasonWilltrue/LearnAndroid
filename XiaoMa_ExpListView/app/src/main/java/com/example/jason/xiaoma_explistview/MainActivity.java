package com.example.jason.xiaoma_explistview;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {
    //2.设置全局
    private ExpandableListView mExpLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.获取ui控件
        mExpLv = (ExpandableListView) findViewById(R.id.explv);

        //4.获取主数据
        //初始化一个集合
        ArrayList<String> groupNames = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            groupNames.add("第" + i + "组");
        }
        //创建完成组视图，再创建子视图  《KEY代表组名,子内容》
        HashMap<String, ArrayList<String>> childNames = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < groupNames.size(); i++) {
            ArrayList<String> children = new ArrayList<String>();
            for (int j = 0; j < 5; j++) {
                children.add("子内容" + j);
            }
            //遍历下的组名 key就是组名  值就是成员队列
            childNames.put(groupNames.get(i), children);
        }

        // 3把adapter构造器 插入ui控件
//        MyAdatper adapter = new MyAdatper(groupNames);
        //5 创建子 数据之后 加入childnames
        MyAdatper adapter = new MyAdatper(groupNames, childNames);
        mExpLv.setAdapter(adapter);


        //折叠
//		mExpLv.setOnGroupCollapseListener(onGroupCollapseListener)
        //展开
//		mExpLv.setOnGroupExpandListener(onGroupExpandListener)
        //点击
//		mExpLv.setOnGroupClickListener(onGroupClickListener)
//		mExpLv.setOnChildClickListener(onChildClickListener)

        // 点击事件
        mExpLv.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(MainActivity.this, groupPosition + "被展开", Toast.LENGTH_SHORT).show();
            }
        });


    }


}
