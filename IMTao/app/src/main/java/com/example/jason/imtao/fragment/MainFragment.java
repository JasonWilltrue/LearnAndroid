package com.example.jason.imtao.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jason.imtao.R;
import com.example.jason.imtao.adapter.MainHeaderAdapter;
import com.example.jason.imtao.adapter.MainMenu2Adapter;
import com.example.jason.imtao.adapter.MainMenuAdapter;
import com.example.jason.imtao.adapter.MainMenuHorAdapter;
import com.example.jason.imtao.util.DataUtil;

/**
 * 主界面视图
 */
public class MainFragment extends Fragment {


    private int[] icons ={R.mipmap.header_pic_ad1,R.mipmap.header_pic_ad2,R.mipmap
            .find_hot_jiangnan,R.mipmap.find_hot_home};

    private ViewPager mViewPager;

    //菜单图标
    protected  int [] menuIons={R.mipmap.menu_airport,R.mipmap.menu_car
            ,R.mipmap.menu_course,R.mipmap.menu_hatol,
            R.mipmap.menu_nearby,R.mipmap.me_menu_go,
            R.mipmap.menu_ticket,R.mipmap.menu_train};
    protected  String [] menus;
    private RecyclerView mRecycleViewMenu;
    private RecyclerView mRecycleViewMenu2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //获取文字描述
        menus = this.getActivity().getResources().getStringArray(R.array.main_menu);
        //轮播图
        mViewPager = (ViewPager) getActivity().findViewById(R.id.viewpage_main_header_ad);
        //菜单栏1
        mRecycleViewMenu = (RecyclerView)getActivity().findViewById(R.id.recyclerview_main_menu);



        MainHeaderAdapter adapter = new MainHeaderAdapter(getActivity(), DataUtil
                .getHeaderAddInfo(getActivity(),icons));
        mViewPager.setAdapter(adapter);

        //菜单
        //设置布局样式
        mRecycleViewMenu.setLayoutManager(new GridLayoutManager(getActivity(),4));
        MainMenu2Adapter mainMenuAdapter=new MainMenu2Adapter(getActivity(),DataUtil.getMainMenu(menuIons,
                menus));
        mRecycleViewMenu.setAdapter(mainMenuAdapter);


        //获取
        mRecycleViewMenu2 = (RecyclerView)getActivity().findViewById(R.id.recyclerview_main_menu2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecycleViewMenu2.setLayoutManager(layoutManager);
        //设置布局样式2
        MainMenuHorAdapter mainMenuHorAdapter = new MainMenuHorAdapter(getActivity(),DataUtil.getMainMenu(menuIons,menus));
        mRecycleViewMenu2.setAdapter(mainMenuHorAdapter);




    }


}
