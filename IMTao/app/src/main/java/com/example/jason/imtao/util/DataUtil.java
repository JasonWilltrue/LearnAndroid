package com.example.jason.imtao.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.widget.ImageView;
import com.example.jason.imtao.entity.Menu;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {
    /**
     *
     * @param context
     * @param icons 图片的id
     * @return
     */
    public static List<ImageView> getHeaderAddInfo(Context context,int icons[]){
        List<ImageView> datas = new ArrayList<>();
        for (int i = 0; i <icons.length ; i++) {
            ImageView icon = new ImageView(context);
            icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //传入的是图片的id
            icon.setImageResource(icons[i]);

            datas.add(icon);
        }
        return  datas;
    }

    /**
     * 主餐单
     * @param icons
     * @param names
     * @return
     */
    public  static List<Menu> getMainMenu(int icons[], String names[]){
        List<Menu> menus = new ArrayList<>();
        for (int i = 0; i <icons.length ; i++) {
           Menu menu = new Menu(icons[i],names[i]);
            menus.add(menu);
        }
       return menus;
    }
}
