package com.example.dong.kaoshi9;

import com.example.dong.kaoshi9.bean.ListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Myserver {
    public String url="http://106.13.63.54:8080/sys/xin195yk/";
    @GET("jiekou2.json")
    Observable<ListBean> getData();
}
