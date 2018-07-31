package com.clever.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clever.R;

import java.util.ArrayList;

/**
 * Created by liuhe on 2017/3/23.
 */

public class HeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<String> datas;
    Context mContext;

    public HeaderAdapter(Context context, ArrayList<String> data) {
        mContext = context;
        datas = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rcy_header, parent, false);
        return new ChildHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ChildHolder childHolder = (ChildHolder) holder;
        childHolder.mTextView.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ChildHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        public ChildHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_item_rcy_child_content);
        }
    }
}
