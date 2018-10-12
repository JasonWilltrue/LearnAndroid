package com.example.jason.imtao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class CABaseAdapter<T,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private Context context;
    private List<T> datas;

    public CABaseAdapter(Context context, List<T> datas) {
        this.context = context;
        this.datas = datas;
    }
    @Override
    public int getItemCount() {
        return datas.size();
    }

    public Context getContext() {
        return context;
    }

    public View getItemView(int resId,ViewGroup p){
        return LayoutInflater.from(context).inflate(resId,  p,false);
    }


    public void setContext(Context context) {
        this.context = context;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }
}
