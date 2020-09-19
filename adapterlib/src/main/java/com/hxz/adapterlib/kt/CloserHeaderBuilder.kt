package com.hxz.adapterlib.kt

/**
 * @Author:andy
 * @CreateDate:2020/9/19 17:34
 * @Description:CloserHeaderBuilder
 */
interface CloserHeaderBuilder : CloserBuilder {

    fun getHeaderView(): Int


    fun bindHeaderView(holder: CloserViewHolder)
}