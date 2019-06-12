package com.example.dong.myapplication2.base;

public  abstract class BaseMvpActivity<P extends BasePresenter,M extends BaseModel,V extends BaseView> extends BaseActivity {
    protected  P mPresenter;

    @Override
    protected void initMvp() {
        super.initMvp();
        mPresenter=initPresenter();
        if (mPresenter!=null){
            mPresenter.initView(view());
            mPresenter.initModel(model());

        }
    }
    protected abstract M model();


    protected abstract V view();

    protected abstract P initPresenter();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.onDestory();
            mPresenter=null;
        }
    }
}
