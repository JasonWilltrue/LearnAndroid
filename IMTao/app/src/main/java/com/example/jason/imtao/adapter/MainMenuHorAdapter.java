package com.example.jason.imtao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jason.imtao.R;
import com.example.jason.imtao.entity.Menu;

import java.util.List;

public class MainMenuHorAdapter extends RecyclerView.Adapter<MainMenuHorAdapter.ViewHolder> {

    private Context context;
    private List<Menu> menus;

    public MainMenuHorAdapter(Context context,List<Menu> menus) {
        this.context = context;
        this.menus = menus;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImgMenuIcon;
        private TextView mTxtMenuName;
        public ViewHolder(View itemView) {
            super(itemView);
            mImgMenuIcon= (ImageView) itemView.findViewById(R.id.img_menu_hor_icon);
            mTxtMenuName= (TextView) itemView.findViewById(R.id.img_menu_hor_name);
        }
    }


    @Override
    public MainMenuHorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_hormenu,
                null);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(MainMenuHorAdapter.ViewHolder holder, int position) {
        Menu menu = menus.get(position);
        holder.mImgMenuIcon.setImageResource(menu.icon);
        holder.mTxtMenuName.setText(menu.menuName);


    }

    @Override
    public int getItemCount() {
        return null != menus ? menus.size() : 0;
    }
}
