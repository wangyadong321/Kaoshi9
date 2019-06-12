package com.example.dong.myapplication.presenter;

import com.example.dong.myapplication.Model.NewsModel;
import com.example.dong.myapplication.base.BaseCallBack;
import com.example.dong.myapplication.base.BasePresenter;
import com.example.dong.myapplication.bean.NewsBean;
import com.example.dong.myapplication.view.NewsView;

public class NewsPresenter extends BasePresenter<NewsView,NewsModel> {
    public void getData() {
        myModel.getData(new BaseCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {
                myView.onSuccess(newsBean);
            }
        });
    }
}
