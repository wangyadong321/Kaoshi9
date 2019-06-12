package com.example.dong.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dong.myapplication.Model.FuModel;
import com.example.dong.myapplication.R;
import com.example.dong.myapplication.adapter.RlvfuAdapter;
import com.example.dong.myapplication.base.BaseMvpFragment;
import com.example.dong.myapplication.bean.FuliBean;
import com.example.dong.myapplication.presenter.FuPresenter;
import com.example.dong.myapplication.view.FuView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FuliFragment extends BaseMvpFragment<FuPresenter, FuView, FuModel> implements FuView {


    @BindView(R.id.rlv)
    RecyclerView rlv;
    Unbinder unbinder;
    private ArrayList<FuliBean.ResultsBean> list;
    private RlvfuAdapter adapter;

    @Override
    protected FuModel model() {
        return new FuModel();
    }

    @Override
    protected FuView view() {
        return this;
    }

    @Override
    protected FuPresenter initPresenter() {
        return new FuPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fuli;
    }

    @Override
    protected void initView(View inflate) {
        list = new ArrayList<>();
        adapter = new RlvfuAdapter(getContext(), list);
        rlv.setAdapter(adapter);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));


    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    public void onSuccess(FuliBean fuliBean) {
        list.addAll(fuliBean.getResults());
        adapter.notifyDataSetChanged();
    }


}
