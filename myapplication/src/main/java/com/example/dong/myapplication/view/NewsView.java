package com.example.dong.myapplication.view;

import com.example.dong.myapplication.base.BaseView;
import com.example.dong.myapplication.bean.NewsBean;

public interface NewsView extends BaseView {
    void onSuccess(NewsBean newsBean);
}
