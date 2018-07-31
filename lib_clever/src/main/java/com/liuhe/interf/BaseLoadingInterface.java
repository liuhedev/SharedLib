package com.liuhe.interf;

/**
 * 加在数据过程的接口类，包含显示，隐藏loading
 *
 * @author liuhea
 * @date 2016-12-25</p>
 */

public interface BaseLoadingInterface {
    /**
     * 显示加载框
     */
    public void showLoading();

    /**
     * 隐藏加载框
     */
    public void hideLoading();

}
