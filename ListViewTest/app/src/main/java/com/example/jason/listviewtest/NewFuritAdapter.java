package com.example.jason.listviewtest;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NewFuritAdapter extends BaseAdapter {
    //1 设置一个全局变量
    private ArrayList<Fruit> mDatas;

    public NewFuritAdapter(ArrayList<Fruit> fruitList) {
        this.mDatas = fruitList;
    }

    @Override
    public int getCount() {
        Log.d("520it", "getCount: 这里有几个值啊" + mDatas);
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * @param position
     * @param convertView
     * @param parent      容器
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //每一个view都可以获取它的空context v.getContext
        Log.d("520it", "getView: sss" + position);
        Fruit fruit = (Fruit) getItem(position);
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        //找到容器
        View view = layoutInflater.inflate(R.layout.fruit_item, null);

        //容器下的findViewById
        ImageView iv = (ImageView) view.findViewById(R.id.fruit_image);
        TextView name = (TextView) view.findViewById(R.id.fruit_name);

        //传入变量
        iv.setImageResource(fruit.getImageId());
        name.setText(fruit.getName());
        return view;

    }


}
