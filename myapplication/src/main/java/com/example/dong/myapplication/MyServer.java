package com.example.dong.myapplication;

import com.example.dong.myapplication.bean.FuliBean;
import com.example.dong.myapplication.bean.NewsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyServer {
    public String url="http://gank.io/api/data/%E7%A6%8F%E5%88%A9/";
    @GET("20/1")
    Observable<FuliBean> fuData();
    public String zhiurl="http://news-at.zhihu.com/api/4/";
    @GET("news/latest")
    Observable<NewsBean> newsData();

}
