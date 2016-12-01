package com.clever;

/**
 * 应用程序异常：用于捕获异常和提示错误信息
 *
 * @author liuhea .
 * @created 16-12-1 .
 */
public class AppCrashHandler implements Thread.UncaughtExceptionHandler {

    /**
     * 定义异常类型
     */
    public final static byte TYPE_NETWORK = 0x01;
    public final static byte TYPE_SOCKET = 0x02;
    public final static byte TYPE_HTTP_CODE = 0x03;
    public final static byte TYPE_HTTP_ERROR = 0x04;
    public final static byte TYPE_XML = 0x05;
    public final static byte TYPE_IO = 0x06;
    public final static byte TYPE_RUN = 0x07;
    public final static byte TYPE_JSON = 0x08;
    public final static byte TYPE_FILE_NOT_FOUND = 0x09;

    private byte type;    // 异常的类型
    private int code;    // 异常的状态码，这里一般是网络请求的状态码

    @Override
    public void uncaughtException(Thread t, Throwable e) {

    }
}
