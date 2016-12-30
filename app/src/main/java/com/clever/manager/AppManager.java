package com.clever.manager;

/**
 * Activity　堆栈管理类
 *
 * @author liuhea
 * @created 16-11-24
 */
public class AppManager {

    private AppManager() {
    }

    public static AppManager getAppManager() {
        return SingletonHolder.sAppManager;
    }

    private static class SingletonHolder {
        private static AppManager sAppManager = new AppManager();
    }
}
