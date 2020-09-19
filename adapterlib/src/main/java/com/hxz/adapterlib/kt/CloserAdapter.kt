package com.hxz.adapterlib.kt

import android.view.View

/**
 * @Author:andy
 * @CreateDate:2020/9/19 17:05
 * @Description: 入口直接继承使用
 */

val TAG = "CloserAdapter"

abstract class CloserAdapter<T> : BaseCloserAdapter(), View.OnClickListener, View.OnLongClickListener {

    //数据源
    private var mData = arrayListOf<T>()
    // 点击事件监听器
    private var mOnItemClickListener: OnItemClickListener<T>? = null

    // 长按事件监听器
    private var mOnItemLongClickListener: OnItemLongClickListener<T>? = null

    // 分页加载数据锁，列表滑动到底部时关闭锁防止重复加载数据，请求结束时打开锁
    private var mLoadingLock = true

    // 分页加载数据时的当前页数
    private var mCurrentPage = 1

    // 分页加载数据的状态
    private var mLoadingStatus: Int = loading

    // 分页加载数据时加载错误提示的信息
    private var mLoadingFailureMsg = "分页加载数据时加载错误提示的信息"

    /**
     * 点击事件监听器
     */
    interface OnItemClickListener<T> {
        fun onClick(position: Int, data: T)
    }

    /**
     * 长按事件监听器
     */
    interface OnItemLongClickListener<T> {
        fun onLongClick(position: Int, data: T)
    }


}

