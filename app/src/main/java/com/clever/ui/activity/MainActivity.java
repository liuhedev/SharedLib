package com.clever.ui.activity;


import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.clever.R;
import com.clever.base.BaseActivity;
import com.clever.utils.DialogUtils;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.common_view_list)
    ListView mListView;

    private ArrayList<String> mDataList;

    public static void actionStart() {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initListener() {
        mListView.setOnItemClickListener(this);
    }

    @Override
    protected void initData() {

        mDataList = getTestData();
        mListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return mDataList.size();
            }

            @Override
            public Object getItem(int position) {
                return mDataList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = new TextView(mContext);
                textView.setText(mDataList.get(position));
                textView.setTextSize(20);
                textView.setPadding(0, 20, 0, 20);
                return textView;
            }
        });
    }


    private ArrayList getTestData() {
        ArrayList<String> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dataList.add("测试数据" + i);
        }
        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        DialogUtils.getMessageDialog(mContext, "提示", String.format("点击了第%s个条目", position), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(mContext, "u can u up" + position, Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}
