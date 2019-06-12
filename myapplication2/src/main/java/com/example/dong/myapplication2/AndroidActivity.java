package com.example.dong.myapplication2;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dong.myapplication2.adapter.RlvAdapter;
import com.example.dong.myapplication2.base.BaseMvpActivity;
import com.example.dong.myapplication2.bean.FuliBean;
import com.example.dong.myapplication2.model.FuliM;
import com.example.dong.myapplication2.presenter.FoliP;
import com.example.dong.myapplication2.view.FuliV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AndroidActivity extends BaseMvpActivity<FoliP, FuliM, FuliV> implements FuliV {

    @BindView(R.id.rlv)
    RecyclerView rlv;
    private ArrayList<FuliBean.ResultsBean> resultsBeans;
    private RlvAdapter rlvAdapter;

    @Override
    protected FuliM model() {
        return new FuliM();
    }

    @Override
    protected FuliV view() {
        return this;
    }

    @Override
    protected FoliP initPresenter() {
        return new FoliP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_android;
    }


    @Override
    protected void initView() {
        resultsBeans = new ArrayList<>();
        rlvAdapter = new RlvAdapter(this, resultsBeans);
        rlv.setAdapter(rlvAdapter);
        rlv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    public void onSuccess(FuliBean fuliBean) {
        resultsBeans.addAll(fuliBean.getResults());
        rlvAdapter.notifyDataSetChanged();

    }
}
