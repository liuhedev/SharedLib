package com.clever;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.clever.ui.activity.MainActivity;


/**
 * welcome to Clever
 *
 * @author liuhea
 * @created 16-11-24
 */
public class SplashActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        redirectTo();
//        findViewById(R.id.layout_splash).postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                redirectTo();
//            }
//        }, 800);
    }

    /**
     * 开启服务或者跳转页面
     */
    private void redirectTo() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
