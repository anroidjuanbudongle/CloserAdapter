package com.hxz.adapterlib.kt

/**
 * @Author:andy
 * @CreateDate:2020/9/19 17:35
 * @Description:多布局
 */
interface CloserMultiItemViewBuilder<T> {

    //通过type 获取item view布局id
    fun getLayoutId(type: Int): Int

    //通过列表的 position 和与 position 对应的数据源获取item type
    fun getItemType(position: Int, data: T): Int





}