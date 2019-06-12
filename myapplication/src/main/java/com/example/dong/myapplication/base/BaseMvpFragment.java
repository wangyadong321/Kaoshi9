package com.example.dong.myapplication.base;

public abstract class BaseMvpFragment<P extends BasePresenter,V extends BaseView,M extends BaseModel>  extends BaseFragment {
    protected P mPresenter;
    @Override
    protected void initMvp() {
        super.initMvp();
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
