package com.clever.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * 通知信息服务类
 *
 * @author liuhea
 * @date 2016/12/25
 *  
 */
public class NoticeService extends Service {
    public NoticeService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
