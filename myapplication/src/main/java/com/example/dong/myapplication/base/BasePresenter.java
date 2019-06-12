package com.example.dong.myapplication.base;

public class BasePresenter <V extends BaseView,M extends BaseModel> {
    protected V myView;
    protected M myModel;

    public  void addView(V view) {
        this.myView=view;
    }

    public  void addModel(M model) {
        this.myModel=model;
    }
}
