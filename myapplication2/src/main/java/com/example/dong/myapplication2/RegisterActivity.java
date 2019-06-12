package com.example.dong.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;

import com.example.dong.myapplication2.base.BaseMvpActivity;
import com.example.dong.myapplication2.model.RegistM;
import com.example.dong.myapplication2.presenter.RegistP;
import com.example.dong.myapplication2.view.RegistV;

public class RegisterActivity extends BaseMvpActivity<RegistP,RegistM,RegistV> implements RegistV {


    @Override
    protected RegistM model() {
        return new RegistM();
    }

    @Override
    protected RegistV view() {
        return this;
    }

    @Override
    protected RegistP initPresenter() {
        return new RegistP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }


}
