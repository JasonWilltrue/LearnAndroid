package com.example.jason.imtao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jason.imtao.LoginActivity;
import com.example.jason.imtao.R;

/**
 *  我的
 */
public class MeFragment extends Fragment {
    private Button mBtnLogin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me,container,false);
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBtnLogin = (Button)getActivity().findViewById(R.id.login_btn);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转登陆界面
                Intent login = new Intent(getActivity(), LoginActivity.class);
                startActivity(login);
            }
        });
    }
}
