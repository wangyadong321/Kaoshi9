package com.example.dong.kaoshi9.fragmetn;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dong.kaoshi9.R;
import com.example.dong.kaoshi9.adapter.Rlv2Adapter;
import com.example.dong.kaoshi9.bean.Bean;
import com.example.dong.kaoshi9.util.DbUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment {


    private View view;
    private RecyclerView rlv;
    private ArrayList<Bean> beans= new ArrayList<>();
    private Rlv2Adapter rlv2Adapter;

    public BFragment() {
        // Required empty public constructor
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if (!hidden){
            initData();
        }
        super.onHiddenChanged(hidden);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_b, container, false);
//        initView(inflate);

        return inflate;
    }

    private void initData() {
        beans.clear();
        List<Bean> query = DbUtil.getDbUtil().query();
        beans.addAll(query);

        rlv2Adapter.notifyDataSetChanged();
    }

//    private void initView(View inflate) {
//        rlv = (RecyclerView) inflate.findViewById(R.id.rlv);
//       // rlv2Adapter = new Rlv2Adapter(getContext(), beans);
//        rlv.setAdapter(rlv2Adapter);
//        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
//
//    }

}
