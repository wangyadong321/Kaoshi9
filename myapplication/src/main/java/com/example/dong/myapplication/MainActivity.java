package com.example.dong.myapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.dong.myapplication.base.BaseActivity;
import com.example.dong.myapplication.fragment.BaiduFragment;
import com.example.dong.myapplication.fragment.FuliFragment;
import com.example.dong.myapplication.fragment.GankFragment;
import com.example.dong.myapplication.fragment.NewsFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.nv)
    NavigationView nv;
    @BindView(R.id.dl)
    DrawerLayout dl;
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments;
    private FragmentManager manager;

//1810A王亚东
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        tab.addTab(tab.newTab().setText("详情"));
        tab.addTab(tab.newTab().setText("百度"));
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl, toolbar, R.string.app_name, R.string.app_name);
        dl.addDrawerListener(toggle);
        toggle.syncState();

        manager = getSupportFragmentManager();
        initTitles();
        initFragments();
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                switch (menuItem.getItemId()) {
                    case R.id.item1:
                        switchFragment(0);

                        break;
                    case R.id.item2:
                        switchFragment(1);
                        break;
                }
                dl.closeDrawer(Gravity.LEFT);
                return false;

            }
        });

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        switchFragment(2);
                        break;
                    case 1:
                        switchFragment(3);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }


        private int mLastType=0;
            private void switchFragment(int type) {
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
                toolbar.setTitle(titles.get(type));

            }



    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new FuliFragment());
        fragments.add(new NewsFragment());
        fragments.add(new GankFragment());
        fragments.add(new BaiduFragment());


    }

    private void initTitles() {
        titles = new ArrayList<>();
        titles.add("福利");
        titles.add("知乎");
        titles.add("详情");
        titles.add("百度");

    }
}
