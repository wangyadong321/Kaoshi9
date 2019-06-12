package com.example.dong.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dong.myapplication.Model.NewsModel;
import com.example.dong.myapplication.R;
import com.example.dong.myapplication.adapter.RlvNewsAdapter;
import com.example.dong.myapplication.base.BaseMvpFragment;
import com.example.dong.myapplication.bean.NewsBean;
import com.example.dong.myapplication.presenter.NewsPresenter;
import com.example.dong.myapplication.view.NewsView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseMvpFragment<NewsPresenter, NewsView, NewsModel> implements NewsView {


    @BindView(R.id.rlv)
    RecyclerView rlv;
    Unbinder unbinder;
    private ArrayList<NewsBean.StoriesBean> storiesBeans;
    private ArrayList<NewsBean.TopStoriesBean> topStoriesBeans;
    private RlvNewsAdapter rlvNewsAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected NewsModel model() {
        return new NewsModel();
    }

    @Override
    protected NewsView view() {
        return this;
    }

    @Override
    protected NewsPresenter initPresenter() {
        return new NewsPresenter();
    }

    @Override
    protected void initView(View inflate) {
        storiesBeans = new ArrayList<>();
        topStoriesBeans = new ArrayList<>();
        rlvNewsAdapter = new RlvNewsAdapter(getContext(), storiesBeans, topStoriesBeans);
        rlv.setAdapter(rlvNewsAdapter);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getData();
    }

    @Override
    public void onSuccess(NewsBean newsBean) {
        storiesBeans.addAll(newsBean.getStories());
        rlvNewsAdapter.notifyDataSetChanged();
        topStoriesBeans.addAll(newsBean.getTop_stories());
        rlvNewsAdapter.notifyDataSetChanged();
    }
}
