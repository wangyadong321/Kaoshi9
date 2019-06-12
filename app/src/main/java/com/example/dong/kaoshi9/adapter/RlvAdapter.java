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
import com.example.dong.kaoshi9.bean.ListBean;
import com.example.dong.kaoshi9.presenter.Presenter;

import java.util.ArrayList;

public class RlvAdapter extends RecyclerView.Adapter<RlvAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ListBean.DataBean.DatasBean> list;
    private SparseBooleanArray list1 =  new SparseBooleanArray();
    private int mPos;

    public RlvAdapter(Context context, ArrayList<ListBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        //给选中定一个标记
        viewHolder.cb.setTag(i);
        viewHolder.tv.setText(list.get(i).getTitle());
        viewHolder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //根据标记找到选中的条目
                int mPos = (int) buttonView.getTag();
                ListBean.DataBean.DatasBean datasBean = list.get(i);
                if (isChecked){
                    //判断是否选中
                    list1.put(mPos,true);
                    onClickListener.onCheck(datasBean);
                }else {

                    list1.delete(mPos);
                    onClickListener.onNoCheck(datasBean);

                }

            }
        });
        viewHolder.cb.setChecked(list1.get(i));


    }



    @Override
    public int getItemCount() {
        return list.size();
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
        void onClick(int position);

        //定义一个接口用来接口回调
        void onCheck(ListBean.DataBean.DatasBean bean);
        void onNoCheck(ListBean.DataBean.DatasBean bean);
    }
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
