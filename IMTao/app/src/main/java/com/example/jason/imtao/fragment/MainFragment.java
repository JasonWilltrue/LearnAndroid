package com.example.jason.imtao.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jason.imtao.R;
import com.example.jason.imtao.adapter.MainHeaderAdapter;
import com.example.jason.imtao.util.DataUtil;

/**
 * 主界面视图
 */
public class MainFragment extends Fragment {


    private int[] icons ={R.mipmap.header_pic_ad1,R.mipmap.header_pic_ad2};

    private ViewPager mViewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewPager = (ViewPager) getActivity().findViewById(R.id.viewpage_main_header_ad);
        MainHeaderAdapter adapter = new MainHeaderAdapter(getActivity(), DataUtil
                .getHeaderAddInfo(getActivity(),icons));
        mViewPager.setAdapter(adapter);
    }
}
