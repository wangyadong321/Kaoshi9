package com.example.dong.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.dong.myapplication.R;
import com.example.dong.myapplication.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaiduFragment extends BaseFragment {


    @BindView(R.id.web)
    WebView web;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_baidu;
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("https://www.baidu.com");
    }
}
