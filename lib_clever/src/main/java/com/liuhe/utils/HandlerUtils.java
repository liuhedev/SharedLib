package com.liuhe.utils;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * hanlder操作工具类
 * <p>
 * 使用说明：
 * 在Activity或者Activity内部持有类中实现该接口，不要使用匿名类，可能会被GC,即：
 * HandlerHolder handlerHolder = new HandlerUtils.HandlerHolder(this);
 * </p>
 *
 * @author liuhea
 * @date 2016/12/30
 *  
 */
public class HandlerUtils {

    private HandlerUtils() {
        throw new UnsupportedOperationException("you can't instantiate me.");
    }

    public static class HandlerHolder extends Handler {
        WeakReference<OnReceiveMessageListener> mListenerWeakReference;

        /**
         * @param listener 收到消息回调接口
         */
        public HandlerHolder(OnReceiveMessageListener listener) {
            mListenerWeakReference = new WeakReference<>(listener);
        }

        @Override
        public void handleMessage(Message msg) {
            if (mListenerWeakReference != null && mListenerWeakReference.get() != null) {
                mListenerWeakReference.get().handlerMessage(msg);
            }
        }
    }

    /**
     * 收到消息回调接口
     */
    public interface OnReceiveMessageListener {
        void handlerMessage(Message msg);
    }
}
