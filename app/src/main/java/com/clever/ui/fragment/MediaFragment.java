package com.clever.ui.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.clever.R;
import com.clever.ui.activity.ImageViewActivity;

public class MediaFragment extends Fragment implements View.OnClickListener {

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 10086;
    private static final String URL = "://www.12306.cn/";
    private Button mAudioPlayBtn;
    private AppCompatButton mPhotoShowBtn;
    private Button mOpenWeb;
    private Button mSwitchHttps;
    private WebView mWebView;

    String urlPrefix = "http";


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
        mOpenWeb.setOnClickListener(this);
        mSwitchHttps.setOnClickListener(this);
    }

    private void initEvent() {
    }

    private void initView(View view) {
        mAudioPlayBtn = (Button) view.findViewById(R.id.btn_fragment_media_play_audio);
        mPhotoShowBtn = (AppCompatButton) view.findViewById(R.id.btn_fragment_media_show_photos);

        mOpenWeb = (Button) view.findViewById(R.id.btn_media_open);
        mSwitchHttps = (Button) view.findViewById(R.id.btn_media_switch_https);
        mWebView = (WebView) view.findViewById(R.id.web_media_content);

        initWebSetting();
    }

    private void initWebSetting() {
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                super.onReceivedSslError(view, handler, error);
                //handler.cancel(); 默认的处理方式，WebView变成空白页
                handler.proceed();//接受证书
                //handleMessage(Message msg); 其他处理
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_fragment_media_play_audio:
                onClickAudioPlay();
                break;
            case R.id.btn_fragment_media_show_photos:
                onClickCallPhone();
                break;

            case R.id.btn_media_open:
                openWeb();
                break;

            case R.id.btn_media_switch_https:
                switchHttps();
                break;
        }

    }

    private void switchHttps() {
        urlPrefix = ("http".equalsIgnoreCase(urlPrefix)) ? "https" : "http";
        Toast.makeText(getContext().getApplicationContext(), "切换为" + urlPrefix, Toast.LENGTH_SHORT).show();
    }

    private void openWeb() {
        Toast.makeText(getContext().getApplicationContext(), (urlPrefix + URL), Toast.LENGTH_SHORT).show();
        mWebView.loadUrl(urlPrefix + URL);
    }

    private void onClickCallPhone() {
        testCall();
    }

    private void onClickAudioPlay() {

        startActivity(new Intent(getActivity(), ImageViewActivity.class));
        //    http://sherpapreview-standard.s3.cn-north-1.amazonaws.com.cn/Preview/Public/Beta/18307433.m4a
    }

    public void testCall() {
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
        } else {
            callPhone();
        }

        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.CALL_PHONE)) {
            Toast.makeText(getActivity(), "你都选了不要在弹出选择框，还想咋地", Toast.LENGTH_SHORT).show();

            // Show an expanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.

        }
    }

    public void callPhone() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + "10086");
        intent.setData(data);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (requestCode == MY_PERMISSIONS_REQUEST_CALL_PHONE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callPhone();
            } else {
                // Permission Denied
                Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
