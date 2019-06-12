package com.example.dong.myapplication2.base;

public abstract class BaseMvpFragment<P extends BasePresenter,M extends BaseModel,V extends BaseView> extends BaseFragment {
    protected P mPresenter;
    @Override
    protected void initMvp() {
        super.initMvp();
        mPresenter=initPresenter();
        if (mPresenter!=null){
            mPresenter.initModel(model());
            mPresenter.initView(view());
        }

    }

    protected abstract V view();

    protected abstract M model();

    protected abstract P initPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.onDestory();
            mPresenter = null;
        }
    }
}
