package com.example.dong.kaoshi9;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dong.kaoshi9.fragmetn.AFragment;
import com.example.dong.kaoshi9.fragmetn.BFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fl;
    /**
     * 首页
     */
    private RadioButton rb1;
    /**
     * 收藏
     */
    //1809A王亚东正在考试
    private RadioButton rb2;
    private RadioGroup rg;
    private Toolbar toolbar;
    private FragmentManager manager;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        fl = (FrameLayout) findViewById(R.id.fl);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rg = (RadioGroup) findViewById(R.id.rg);

//获取管理器类

        manager = getSupportFragmentManager();
        initFragments();
        addFragment();
        //选中监听
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1:
                        switchFragment(0);
                        break;
                    case R.id.rb2:
                        switchFragment(1);
                        break;


                }
            }
        });

    }

    private void addFragment() {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fl,fragments.get(0));
        transaction.commit();
    }


    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new AFragment());
        fragments.add(new BFragment());



    }

    private int mLastType=0;
        private void switchFragment(int type) {
            //动态添加
            FragmentTransaction transaction = manager.beginTransaction();
            Fragment fragment = fragments.get(type);
            if (!fragment.isAdded()){
                transaction.add(R.id.fl,fragment);
            }
            Fragment lastFragment = fragments.get(mLastType);
            transaction.hide(lastFragment);

            transaction.show(fragment);
            transaction.commit();
            mLastType=type;


        }
}
