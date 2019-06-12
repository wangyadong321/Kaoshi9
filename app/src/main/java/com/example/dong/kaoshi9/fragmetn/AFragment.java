package com.example.dong.kaoshi9.fragmetn;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dong.kaoshi9.R;
import com.example.dong.kaoshi9.adapter.Rlv2Adapter;
import com.example.dong.kaoshi9.adapter.RlvAdapter;
import com.example.dong.kaoshi9.bean.Bean;
import com.example.dong.kaoshi9.bean.ListBean;
import com.example.dong.kaoshi9.model.ModelImp;
import com.example.dong.kaoshi9.presenter.PresenterImp;
import com.example.dong.kaoshi9.util.DbUtil;
import com.example.dong.kaoshi9.view.MyView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements MyView {


    private View view;
    private RecyclerView rlv;
    private RlvAdapter rlvAdapter;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_a, container, false);
        initView(inflate);
        initData();
        return inflate;

    }

    private void initData() {
        //回调P曾方法
        PresenterImp presenterImp = new PresenterImp(new ModelImp(), this);
        presenterImp.getData();
    }

    private void initView(View inflate) {
        rlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));

    }


    @Override
    public void onSuccess(List<ListBean.DataBean.DatasBean> bean) {

    }
}
