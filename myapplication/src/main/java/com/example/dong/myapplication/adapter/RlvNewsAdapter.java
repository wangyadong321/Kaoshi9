package com.example.dong.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dong.myapplication.R;
import com.example.dong.myapplication.bean.NewsBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvNewsAdapter extends RecyclerView.Adapter {
       private Context mContext;
           private ArrayList<NewsBean.StoriesBean> mNewsList;
           private ArrayList<NewsBean.TopStoriesBean> mBanners;
           private static final int TYPE_BANNER = 0;
           private static final int TYPE_TIME = 1;
           private static final int TYPE_NEWS = 2;
           private String mDate = "今日新闻";

           public RlvNewsAdapter(Context context,
                                      ArrayList<NewsBean.StoriesBean> newsList,
                                      ArrayList<NewsBean.TopStoriesBean> banners) {

               mContext = context;
               mNewsList = newsList;
               mBanners = banners;
           }

           @Override
           public int getItemViewType(int position) {
               if (mBanners.size()>0){
                   if (position == 0){
                       return TYPE_BANNER;
                   }else if(position == 1){
                       return TYPE_TIME;
                   }else {
                       return TYPE_NEWS;
                   }
               }else {
                   if(position == 0){
                       return TYPE_TIME;
                   }else {
                       return TYPE_NEWS;
                   }
               }
           }

           @NonNull
           @Override
           public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
               LayoutInflater inflater = LayoutInflater.from(mContext);
               if (viewType == TYPE_BANNER){
                   return new BannerVH(inflater.inflate(R.layout.item_banner,null));
               }else if (viewType == TYPE_TIME){
                   return new TimeVH(inflater.inflate(R.layout.item_time,null));
               }else {
                   return new NewsVH(inflater.inflate(R.layout.item,null));
               }
           }

           @Override
           public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
               int viewType = getItemViewType(position);
               if (viewType == TYPE_BANNER){
                  BannerVH bannerVH = (BannerVH) holder;
                  bannerVH.mBanner.setImages(mBanners)
                          .setImageLoader(new ImageLoader() {
                              @Override
                              public void displayImage(Context context, Object path,
                                                       ImageView imageView) {
                                 NewsBean.TopStoriesBean bean = (NewsBean.TopStoriesBean) path;
                                  Glide.with(mContext).load(bean.getImage()).into(imageView);
                              }
                          }).start();
               }else if (viewType == TYPE_TIME){
                   TimeVH timeVH = (TimeVH) holder;
                   timeVH.mTvTime.setText(mDate);
               }else {
                   NewsVH newsVH = (NewsVH) holder;
                   int newPosition = position-1;
                   if (mBanners.size()>0){
                       newPosition -= 1;
                   }
                 NewsBean.StoriesBean storiesBean = mNewsList.get(newPosition);
                   newsVH.mTvTime.setText(storiesBean.getTitle());
                   Glide.with(mContext).load(storiesBean.getImages().get(0)).into(newsVH.img);
               }
           }

           @Override
           public int getItemCount() {
               if (mBanners.size()>0){
                   return mNewsList.size()+1+1;
               }else {
                   return mNewsList.size()+1;
               }
           }



           class BannerVH extends RecyclerView.ViewHolder{
               @BindView(R.id.ban)
               Banner mBanner;
               public BannerVH(View itemView) {
                   super(itemView);
                   ButterKnife.bind(this,itemView);
               }
           }
           class TimeVH extends RecyclerView.ViewHolder{
               @BindView(R.id.tv)
               TextView mTvTime;
               public TimeVH(View itemView) {
                   super(itemView);
                   ButterKnife.bind(this,itemView);
               }
           }
           class NewsVH extends RecyclerView.ViewHolder{
               @BindView(R.id.tv)
               TextView mTvTime;
               @BindView(R.id.img)
               ImageView img;
               public NewsVH(View itemView) {
                   super(itemView);
                   ButterKnife.bind(this,itemView);
               }
           }


}
