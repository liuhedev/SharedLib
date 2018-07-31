package com.clever.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clever.R;

import java.util.ArrayList;

public class TypefaceFragment extends Fragment {
    private RecyclerView mPhotosView;
        private ArrayList<String> mDatas = new ArrayList<>();
    private View mInflater;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mInflater = inflater.from(getActivity()).inflate(R.layout.fragment_typeface, null);
        initView();
        initData();
        return mInflater;
    }

    private void initView() {
        mPhotosView = (RecyclerView) mInflater.findViewById(R.id.rcy_photos);
    }

    private void initData() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        mPhotosView.setLayoutManager(gridLayoutManager);
        // （可选）如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mPhotosView.setHasFixedSize(true);
        for (int i = 0; i < 7; i++) {
            mDatas.add("测试" + i);
        }
        PhotoAdapter photoAdapter = new PhotoAdapter(mDatas);
        mPhotosView.setAdapter(photoAdapter);
    }

    class PhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private ArrayList<String> datas;

        public PhotoAdapter(ArrayList<String> datas) {
            this.datas = datas;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_typeface, parent, false);
            return new VH(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            VH viewHolder = (VH) holder;
            viewHolder.mTypeFaceView.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }
    }

    private static class VH extends RecyclerView.ViewHolder {
        private TextView mTypeFaceView;

        public VH(View itemView) {
            super(itemView);
            mTypeFaceView = (TextView) itemView.findViewById(R.id.tv_typeface);
        }
    }
}
