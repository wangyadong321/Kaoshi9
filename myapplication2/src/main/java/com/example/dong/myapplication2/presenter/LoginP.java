package com.example.dong.myapplication2.presenter;

import android.text.TextUtils;

import com.example.dong.myapplication2.base.BaseCallBack;
import com.example.dong.myapplication2.base.BasePresenter;
import com.example.dong.myapplication2.bean.LoginBean;
import com.example.dong.myapplication2.model.LoginM;
import com.example.dong.myapplication2.view.LoginV;

public class LoginP extends BasePresenter<LoginV,LoginM> {
    private String name;
    private String psw;
    public void login() {
        if (myMyView!=null){
            name=myMyView.getName();
            if (TextUtils.isEmpty(name)){
                myMyView.onFail("用户名为空");
                return;
            }
        }
         psw = myMyView.getPsw();
        if (TextUtils.isEmpty(psw)){
            myMyView.onFail("密码为空");
            return;
        }

        if (myModel!=null){
            myModel.login(name,psw, new BaseCallBack<LoginBean>() {
                @Override
                public void onSuccess(LoginBean loginBean) {
                    if (myMyView!=null){
                        myMyView.onSuccess(loginBean);
                    }
                }

                @Override
                public void onFail(String msg) {
                    if (myMyView!=null){
                        myMyView.onFail(msg);
                    }
                }
            });
        }


    }

}
