package com.example.dong.kaoshi9.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.dong.kaoshi9.R;
import com.example.dong.kaoshi9.bean.Bean;
import com.example.dong.kaoshi9.bean.ListBean;

import java.util.ArrayList;
import java.util.List;

public class Rlv2Adapter extends RecyclerView.Adapter<Rlv2Adapter.ViewHolder> {
    private Context context;
    private ArrayList<Bean> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final Bean bean = list.get(i);
        viewHolder.tv.setText(list.get(i).getTitle());
        viewHolder.cb.setChecked(bean.getIsCheck());
        viewHolder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener!=null){
                    onClickListener.onClick(bean);
                }
            }
        });



    }



    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addData(List<Bean> list1){
        list.clear();
        list.addAll(list1);
        notifyDataSetChanged();

    }
    public void removeItem(Bean bean){
        list.remove(bean);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private CheckBox cb;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            cb=itemView.findViewById(R.id.cb);

        }
    }
    public interface OnClickListener{
        void onClick(Bean bean);

    }
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }



}
