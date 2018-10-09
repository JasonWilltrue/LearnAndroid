package com.example.jason.imtao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.jason.imtao.fragment.FindFragment;
import com.example.jason.imtao.fragment.MainFragment;
import com.example.jason.imtao.fragment.MeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //声明fragment
    protected MainFragment mMainFragment = new MainFragment();
    protected FindFragment mFindFragment = new FindFragment();
    protected MeFragment mMeFragment = new MeFragment();

    //功能点击按钮
    private LinearLayout mMainBtn;
    private LinearLayout mFindBtn;
    private LinearLayout mMeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //获取管理类
        //事物的添加  默认首页 其他隐藏
        this.getSupportFragmentManager().beginTransaction()
                .add(R.id.container_content,mMainFragment)
                .add(R.id.container_content,mFindFragment).hide(mFindFragment)
                .add(R.id.container_content,mMeFragment).hide(mMeFragment)
                //提交
                .commit();

    }

    /**
     * 初始化视图
     */
    private void initView(){
         mMainBtn = (LinearLayout)findViewById(R.id.menu_main);
         mFindBtn = (LinearLayout)findViewById(R.id.menu_find);
         mMeBtn = (LinearLayout)findViewById(R.id.menu_me);
         mMainBtn.setOnClickListener(this);
        mMainBtn.setOnClickListener(this);
        mMainBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_main:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(mMainFragment)
                        .hide(mFindFragment)
                        .hide(mMeFragment)
                        .commit();
                break;
            case R.id.menu_find:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mMainFragment)
                        .show(mFindFragment)
                        .hide(mMeFragment)
                        .commit();
                break;
            case R.id.menu_me:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mMainFragment)
                        .hide(mFindFragment)
                        .show(mMeFragment)
                        .commit();
                break;
        }
    }
}
