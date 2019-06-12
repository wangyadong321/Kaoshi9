package com.example.dong.kaoshi9.presenter;

import com.example.dong.kaoshi9.CallBack;
import com.example.dong.kaoshi9.bean.ListBean;
import com.example.dong.kaoshi9.model.Model;
import com.example.dong.kaoshi9.view.MyView;

import java.util.List;

public class PresenterImp implements Presenter, CallBack {
    private Model model;
    private MyView myView;

    public PresenterImp(Model model, MyView myView) {
        this.model = model;
        this.myView = myView;
    }

    @Override
    public void getData() {
        model.getData(this);
    }


    @Override
    public void onSuccess(List<ListBean.DataBean.DatasBean> bean) {
        myView.onSuccess(bean);
    }
}
