package com.clever.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clever.R;

public class RcyFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rcy_parent, null);
//        initView(view);
        initData();

        return view;
    }

    private void initData() {

    }
//
//    private void initView(View view) {
//        RecyclerView parentRcy = (RecyclerView) view.findViewById(R.id.rcy_rcy_parent);
//        RecyclerViewHeader header = (RecyclerViewHeader) view.findViewById(R.id.recycler_header);
//        RecyclerView headerRcy = (RecyclerView) view.findViewById(R.id.rcy_task_child);
//
//        parentRcy.setLayoutManager(new LinearLayoutManager(getActivity()));
//        headerRcy.setLayoutManager(new LinearLayoutManager(getActivity()));
//        ContentAdapter contentAdapter = new ContentAdapter(getActivity(), getTestData("content", 30));
//        HeaderAdapter headerAdapter = new HeaderAdapter(getActivity(), getTestData("header", 4));
//        headerRcy.setAdapter(headerAdapter);
//        parentRcy.setAdapter(contentAdapter);
//
//        header.attachTo(parentRcy);
//
//    }
//
//    ArrayList<String> getTestData(String where, int count) {
//        ArrayList<String> strings = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            strings.add(where + "->测试数据->" + i);
//        }
//        return strings;
//    }
}
