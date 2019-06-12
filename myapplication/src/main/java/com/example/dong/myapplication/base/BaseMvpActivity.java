package com.example.dong.myapplication.base;

public abstract class BaseMvpActivity<P extends BasePresenter,V extends BaseView,M extends BaseModel> extends BaseActivity {
    protected P mPresenter;
    @Override
    protected void initMvp() {
        mPresenter=initPresenter();
        if (mPresenter!=null){
            mPresenter.addView(view());
            mPresenter.addModel(model());
        }

    }

    protected abstract M model();

    protected abstract V view();

    protected abstract P initPresenter();
}
