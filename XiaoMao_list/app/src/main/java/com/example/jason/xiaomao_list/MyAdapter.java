package com.example.jason.xiaomao_list;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
   //设置一个全局变量接受数据
    public  ArrayList<String> mdatas;
    public   Context mContext;
    //创建构造器
    public MyAdapter(Context c,ArrayList<String> datas) {
          mdatas = datas;
          mContext = c;
    }

    @Override
    public int getCount() {
        Log.d("520it", "getCount: "+mdatas.size());
        return mdatas.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("520it", "getindex"+position);
        //第一种方法
//        String text = mdatas.get(position);
//        TextView tv = new TextView(mContext);

        //每一个view都可以获取context
        TextView tv = new TextView(parent.getContext());
        //容器中的文本内容 获取
        tv.setText(mdatas.get(position));

        //设置宽高
        tv.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,AbsListView.LayoutParams.WRAP_CONTENT));
//        设置字体
        tv.setTextSize(20);
//                设置颜色
//        tv.setTextColor(0xccc);
//        tv.setText(text);
        //返回视图
//        return tv;

//        动态布局文件  布局充气一个类  布局转化成一个类
        LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
//        root询问用户是否添加到某个容器里去
        View view =  layoutInflater.inflate(R.layout.lv_item_layout,parent,false);

         TextView tv1 = (TextView) view.findViewById(R.id.tv);
         tv1.setText(mdatas.get(position));
          return view;




    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
