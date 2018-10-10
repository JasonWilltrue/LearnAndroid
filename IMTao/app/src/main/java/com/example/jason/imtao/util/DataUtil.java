package com.example.jason.imtao.util;

import android.content.Context;
import android.widget.ImageView;

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

}
