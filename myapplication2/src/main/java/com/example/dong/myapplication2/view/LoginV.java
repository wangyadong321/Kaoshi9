package com.example.dong.myapplication2.view;

import com.example.dong.myapplication2.base.BaseView;
import com.example.dong.myapplication2.bean.LoginBean;

public interface LoginV extends BaseView {
    String getName();
    String getPsw();

    void onFail(String string);
    void onSuccess(LoginBean loginBean);
}
