package com.clever.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.clever.R;
import com.clever.ui.adapter.HeaderAdapter;
import com.clever.ui.adapter.ParentAdapter;
import com.clever.ui.adapter.RecyclerViewHeader;

import java.util.ArrayList;

public class RcyFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rcy_parent, null);
        initView(view);
        initData();

        return view;
    }

    private void initData() {

    }

    private void initView(View view) {
        RecyclerView parentRcy = (RecyclerView) view.findViewById(R.id.rcy_rcy_parent);
        parentRcy.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerViewHeader header = (RecyclerViewHeader) view.findViewById(R.id.recycler_header);
        FrameLayout fl = (FrameLayout) view.findViewById(R.id.fl_header);

        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_rcy_header, null);
        RecyclerView headerRcy = (RecyclerView) headerView.findViewById(R.id.rcy_task_child);
        headerRcy.setLayoutManager(new LinearLayoutManager(getActivity()));

        fl.addView(headerView);
//        RecyclerView headerRcy = (RecyclerView) view.findViewById(R.id.rcy_task_child);
//        headerRcy.setLayoutManager(new LinearLayoutManager(getActivity()));
        header.attachTo(parentRcy);

        ParentAdapter parentAdapter = new ParentAdapter(getActivity(), getTestData("child", 30));
        HeaderAdapter headerAdapter = new HeaderAdapter(getActivity(), getTestData("header", 4));

        headerRcy.setAdapter(headerAdapter);
        parentRcy.setAdapter(parentAdapter);
    }

    ArrayList<String> getTestData(String where, int count) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            strings.add(where + "->测试数据->" + i);
        }
        return strings;
    }
}
