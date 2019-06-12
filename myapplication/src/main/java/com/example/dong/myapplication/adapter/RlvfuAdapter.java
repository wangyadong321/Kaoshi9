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
import com.example.dong.myapplication.bean.FuliBean;

import java.util.ArrayList;

public class RlvfuAdapter extends RecyclerView.Adapter<RlvfuAdapter.ViewHolder> {
    private Context context;
    private ArrayList<FuliBean.ResultsBean> list;

    public RlvfuAdapter(Context context, ArrayList<FuliBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RlvfuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RlvfuAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tv.setText(list.get(i).getDesc());
        Glide.with(context).load(list.get(i).getUrl()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            img=itemView.findViewById(R.id.img);

        }
    }
}
