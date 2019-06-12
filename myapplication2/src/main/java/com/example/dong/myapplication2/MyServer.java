package com.example.dong.myapplication2;

import com.example.dong.myapplication2.bean.FuliBean;
import com.example.dong.myapplication2.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyServer {
    public String url="http://yun918.cn/study/public/index.php/";
    @POST("login")
    @FormUrlEncoded
    Observable<LoginBean> login(@Field("username") String username,@Field("password")String password);
    public String fuurl="http://gank.io/api/data/%E7%A6%8F%E5%88%A9/";
    @GET("20/1")
    Observable<FuliBean> getData();
}
