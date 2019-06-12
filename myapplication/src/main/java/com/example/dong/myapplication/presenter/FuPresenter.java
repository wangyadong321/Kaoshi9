package com.example.dong.myapplication.presenter;

import com.example.dong.myapplication.Model.FuModel;
import com.example.dong.myapplication.base.BaseCallBack;
import com.example.dong.myapplication.base.BasePresenter;
import com.example.dong.myapplication.bean.FuliBean;
import com.example.dong.myapplication.view.FuView;

public class FuPresenter extends BasePresenter<FuView,FuModel> {

    public void getData() {
        myModel.getData(new BaseCallBack<FuliBean>() {
            @Override
            public void onSuccess(FuliBean fuliBean) {
                myView.onSuccess(fuliBean);
            }
        });
    }
}
