package com.example.dong.myapplication2.base;

public interface BaseCallBack<T> {
    void onSuccess(T t);
    void onFail(String msg);
}
