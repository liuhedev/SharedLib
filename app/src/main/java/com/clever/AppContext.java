package com.clever;

import com.cleverlib.base.BaseApplication;
import com.cleverlib.utils.LogUtils;
import com.cleverlib.utils.ProcessUtils;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;

/**
 * @author liuhea .
 * @created 16-11-25 .
 */
public class AppContext extends BaseApplication {
    private static final String TAG = AppContext.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.i(TAG, "startApplication");

        initEasemob();
    }

    /**
     * 配置环信
     */
    private void initEasemob() {

        int pid = android.os.Process.myPid();
        String processAppName = ProcessUtils.getAppName(pid);
        // 如果APP启用了远程的service，此application:onCreate会被调用2次
        // 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
        // 默认的APP会在以包名为默认的process name下运行，如果查到的process name不是APP的process name就立即返回

        if (processAppName == null || !processAppName.equalsIgnoreCase(this.getPackageName())) {
            LogUtils.e(TAG, "enter the service process!");

            // 则此application::onCreate 是被service 调用的，直接返回
            return;
        }

        EMOptions options = new EMOptions();
        // 默认添加好友时，是不需要验证的，改成需要验证
//        options.setAcceptInvitationAlways(false);
        //初始化
        EMClient.getInstance().init(this, options);
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true);
    }
}
