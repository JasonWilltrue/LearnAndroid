package com.example.jason.imtao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.jason.imtao.R;
import com.example.jason.imtao.entity.Menu;

import java.util.List;

public class MainMenu2Adapter extends CABaseAdapter<Menu,MainMenu2Adapter.ViewHolder> {

    public MainMenu2Adapter(Context context, List<Menu> datas) {
        super(context, datas);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(getItemView(R.layout.item_main_menu,parent)) ;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         Menu menu = getDatas().get(position);
         menu.setIcon(menu.icon);
         menu.setMenuName(menu.menuName);
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
