package com.example.dong.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dong.myapplication2.base.BaseActivity;
import com.example.dong.myapplication2.base.BaseMvpActivity;
import com.example.dong.myapplication2.bean.LoginBean;
import com.example.dong.myapplication2.model.LoginM;
import com.example.dong.myapplication2.presenter.LoginP;
import com.example.dong.myapplication2.view.LoginV;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseMvpActivity<LoginP, LoginM, LoginV> implements LoginV {


    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_psw)
    EditText etPsw;
    @BindView(R.id.bt1)
    Button bt1;
    @BindView(R.id.bt2)
    Button bt2;

    @Override
    protected LoginM model() {
        return new LoginM();
    }

    @Override
    protected LoginV view() {
        return this;
    }

    @Override
    protected LoginP initPresenter() {
        return new LoginP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @OnClick({R.id.bt1, R.id.bt2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                mPresenter.login();
                break;
            case R.id.bt2:
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public String getName() {
        return etName.getText().toString();
    }

    @Override
    public String getPsw() {
        return etPsw.getText().toString();
    }

    @Override
    public void onFail(String string) {
        Toast.makeText(this, string.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        Toast.makeText(this, loginBean.getRet(), Toast.LENGTH_SHORT).show();

    }
}
