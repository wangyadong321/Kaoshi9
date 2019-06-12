package com.example.dong.myapplication2.model;

import com.example.dong.myapplication2.MyServer;
import com.example.dong.myapplication2.base.BaseCallBack;
import com.example.dong.myapplication2.base.BaseModel;
import com.example.dong.myapplication2.bean.FuliBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FuliM extends BaseModel {
    public void getData(final BaseCallBack<FuliBean> baseCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyServer.fuurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<FuliBean> data = myServer.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FuliBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(FuliBean fuliBean) {
                        baseCallBack.onSuccess(fuliBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
