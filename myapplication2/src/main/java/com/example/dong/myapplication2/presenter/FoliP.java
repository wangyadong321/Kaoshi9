package com.example.dong.myapplication2.presenter;

import com.example.dong.myapplication2.base.BaseCallBack;
import com.example.dong.myapplication2.base.BasePresenter;
import com.example.dong.myapplication2.bean.FuliBean;
import com.example.dong.myapplication2.model.FuliM;
import com.example.dong.myapplication2.view.FuliV;

public class FoliP extends BasePresenter<FuliV,FuliM> {

    public void getData() {

            myModel.getData(new BaseCallBack<FuliBean>() {
                @Override
                public void onSuccess(FuliBean fuliBean) {
                    if (myMyView!=null){
                        myMyView.onSuccess(fuliBean);
                    }


                }

                @Override
                public void onFail(String msg) {

                }
            });

        }


    }

