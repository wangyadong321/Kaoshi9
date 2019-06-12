package com.example.dong.myapplication2.base;

import java.util.ArrayList;






public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {
    protected M myModel;
    protected V myMyView;
    private ArrayList<BaseModel> list=new ArrayList<>();


    public  void initView(V view) {
        this.myMyView=view;
    }



    public  void initModel(M model) {
        this.myModel=model;
        list.add(myModel);

    }


    public void onDestory() {
        if (myModel!=null){
            myModel=null;
        }

        if (list!=null&&list.size()>0){
            for (BaseModel basemodel:list) {
                basemodel.clear();
            }
        }
        if (myMyView!=null){
            myMyView=null;
        }


    }


}
