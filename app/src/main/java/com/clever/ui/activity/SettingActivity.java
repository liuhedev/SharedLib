package com.clever.ui.activity;

import android.widget.TextView;
import android.widget.Toast;

import com.clever.R;
import com.clever.base.AppBaseActivity;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingActivity extends AppBaseActivity {
    @BindView(R.id.tv_cache_size)
    TextView mTvCacheSize;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initData() {
        super.initData();
        calculateCacheSize();

    }

    @OnClick(R.id.rl_clean_cache)
    public void onClick() {
        cleanCache();
        Toast.makeText(mContext, "clean cache", Toast.LENGTH_SHORT).show();
    }

    private void cleanCache() {
//        DialogUtils.getConfirmDialog(this, "是否清空缓存?", new DialogInterface.OnClickListener
//                () {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                UIHelper.clearAppCache(true);
//                mTvCacheSize.setText("0KB");
//            }
//        }).show();
    }

    /**
     * 计算缓存的大小
     */
    private void calculateCacheSize() {
        long fileSize = 0;
        String cacheSize = "0KB";
        File filesDir = getFilesDir();
        File cacheDir = getCacheDir();

        fileSize += FileUtils.getDirSize(filesDir);
        fileSize += FileUtils.getDirSize(cacheDir);
        // 2.2版本才有将应用缓存转移到sd卡的功能
//        if (AppContext.isMethodsCompat(android.os.Build.VERSION_CODES.FROYO)) {
//            File externalCacheDir = MethodsCompat
//                    .getExternalCacheDir(this);
//            fileSize += FileUtils.getDirSize(externalCacheDir);
//        }
        if (fileSize > 0)
            cacheSize = FileUtils.formatFileSize(fileSize);
        mTvCacheSize.setText(cacheSize);
    }

}
