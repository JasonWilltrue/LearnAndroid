package com.example.jason.imtao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jason.imtao.R;
import com.example.jason.imtao.entity.Menu;

import java.util.List;

/**
 *
 */
//新建MainMenuAdapter继承RecyclerView.Adapter
public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.MainMenuViewholder>{

    protected Context context;
    protected  List<Menu> menus;
    //3.MainMenuAdapter内部的构造函数代表数据源传进来
    public MainMenuAdapter(Context context, List<Menu> menus){
        this.context=context;
        this.menus=menus;
    }
    //4.创建viewholder的实例 并将布局item_main_menu传入 返回一个holder的实例
    @Override
    public MainMenuViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_menu,
                null);
        MainMenuViewholder holder = new MainMenuViewholder(view);
        return holder;
    }
    //5.对子项的数据进行赋值  每个子项被滚动到屏幕内的时候执行 position代表当前项的实例
    //5.让后将当前数据设置到holder的imagev 和 textview当中去
    @Override
    public void onBindViewHolder(MainMenuViewholder holder, int position) {
        Menu menu=menus.get(position);
        holder.mImgMenuIcon.setImageResource(menu.icon);
        holder.mTxtMenuName.setText(menu.menuName);
    }
    //告诉recycelerview一共有多少个子项
    @Override
    public int getItemCount() {
        return null!=menus?menus.size():0;
    }


    // 2.定义一个类构造函数中传入View参数
   public class  MainMenuViewholder extends RecyclerView.ViewHolder{

        public ImageView mImgMenuIcon;
        public TextView mTxtMenuName;
        public MainMenuViewholder(View itemView) {
            super(itemView);
            mImgMenuIcon= (ImageView) itemView.findViewById(R.id.img_menu_icon);
            mTxtMenuName= (TextView) itemView.findViewById(R.id.txt_menu_name);
        }
    }
}

