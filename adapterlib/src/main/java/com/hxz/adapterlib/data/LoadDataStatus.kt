package com.hxz.adapterlib.data

/**
 * @Author:andy
 * @CreateDate:2020/9/19 17:39
 * @Description: LoadDataStatus
 */
interface LoadDataStatus<T> {
    /**
     * 当获取到新加载的数据后调用该方法通知 [com.hxz.adapterlib.CloserAdapter] 将新数据添加到列表中并关闭正在加载数据的状态
     * @param data 获取到数据
     */
    fun onSuccess(data: List<T>?)

    /**
     * 当加载数据失败时调用该方法通知 [com.hxz.adapterlib.CloserAdapter] 关闭正在加载状态并切换到加载数据失败状态
     * @param msg 加载数据失败的原因提示
     */
    fun onFailure(msg: String?)

    /**
     * 当没用更多的数据时调用该方法通知 [com.hxz.adapterlib.CloserAdapter] 关闭正在加载状态并切换到没有更多数据状态
     * 调用该方法后，Adapter将不会自动加载新数据
     */
    fun onNoMoreData()

}