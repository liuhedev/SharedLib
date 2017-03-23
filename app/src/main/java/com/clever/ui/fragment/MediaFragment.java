package com.clever.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.clever.R;

public class MediaFragment extends Fragment implements View.OnClickListener {

    private Button mAudioPlayBtn;
    private AppCompatButton mPhotoShowBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_media, null);

        initView(view);
        initListener();
        initEvent();

        return view;
    }

    private void initListener() {
        mAudioPlayBtn.setOnClickListener(this);
        mPhotoShowBtn.setOnClickListener(this);
    }

    private void initEvent() {
    }

    private void initView(View view) {
        mAudioPlayBtn = (Button) view.findViewById(R.id.btn_fragment_media_play_audio);
        mPhotoShowBtn = (AppCompatButton) view.findViewById(R.id.btn_fragment_media_show_photos);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_fragment_media_play_audio:
                onClickAudioPlay();
                break;
            case R.id.btn_fragment_media_show_photos:
                break;
        }

    }

    private void onClickAudioPlay() {
        //    http://sherpapreview-standard.s3.cn-north-1.amazonaws.com.cn/Preview/Public/Beta/18307433.m4a
    }
}
