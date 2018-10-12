package com.example.jason.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class FuritAdapter extends ArrayAdapter<Fruit> {
    private int  resourceId;
    /**
     * 重写父类的构造函数
     * @param context   上下文对象
     * @param textViewResourceId   子项布局的ID
     * @param objects   数据源
     */
    public FuritAdapter(Context context, int textViewResourceId, List<Fruit> objects){
         super(context,textViewResourceId,objects);
         resourceId = textViewResourceId;
    }

    /**
     *这个方法再子项目滚动到屏幕内的时候会被调用，
     * @param position
     * @param convertView  缓存数据的参数
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //获取当前fruit的实例
        Fruit fruit = getItem(position);

        //默认初始化viewHolder类
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            //当convertView刚创建的时候 存储viewholder子控件
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView)convertView.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView)convertView.findViewById(R.id.fruit_name) ;

            //view与setTag绑定 当往下滑动会调用getView的方法
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return convertView;
    }

    class ViewHolder{
        ImageView fruitImage;
        TextView  fruitName;
    }


}
