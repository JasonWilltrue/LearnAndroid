package com.example.jason.imtao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


/**
 * 广告apapter
 */

public class MainHeaderAdapter extends PagerAdapter {
    private Context context;
    private List<ImageView> images;
    //定义一个方法主要用来传输数据
    public MainHeaderAdapter(Context context, List<ImageView> images){
        this.context = context;
        this.images = images;
    }


    @Override
    public int getCount() {
        //判断集合不等于空
        return null != images ? images.size() : 0;
    }

    //初始化方法
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(images.get(position));
        return images.get(position);
    }

    //判断是否来自object对象
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    //销毁方法
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView(images.get(position));
    }
}
