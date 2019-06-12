package com.example.dong.myapplication.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dong.myapplication.Model.GankM;
import com.example.dong.myapplication.R;
import com.example.dong.myapplication.adapter.VpAdapter;
import com.example.dong.myapplication.base.BaseMvpFragment;
import com.example.dong.myapplication.presenter.GankP;
import com.example.dong.myapplication.view.GankV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GankFragment extends BaseMvpFragment<GankP, GankV, GankM> implements GankV {


    @BindView(R.id.rlv)
    RecyclerView rlv;
    Unbinder unbinder;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder1;
    private ArrayList<String> strings;
    private ArrayList<Fragment> fragments;
    private VpAdapter vpAdapter;

    @Override
    protected GankM model() {
        return new GankM();
    }

    @Override
    protected GankV view() {
        return this;
    }

    @Override
    protected GankP initPresenter() {
        return new GankP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }


    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
    }



}
