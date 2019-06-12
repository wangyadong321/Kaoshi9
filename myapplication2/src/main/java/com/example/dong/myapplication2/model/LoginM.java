package com.example.dong.myapplication2.model;

import com.example.dong.myapplication2.MyServer;
import com.example.dong.myapplication2.base.BaseCallBack;
import com.example.dong.myapplication2.base.BaseModel;
import com.example.dong.myapplication2.bean.LoginBean;
import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginM extends BaseModel {
    public void login(String name, String psw, final BaseCallBack<LoginBean> baseCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyServer.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        final Observable<LoginBean> login = myServer.login(name, psw);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        if (loginBean!=null){
                            if (loginBean.getCode()==200){

                                baseCallBack.onSuccess(loginBean);
                            }else {
                                baseCallBack.onFail(loginBean.getRet());
                            }

                        }else {
                            baseCallBack.onFail("错误");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    baseCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
