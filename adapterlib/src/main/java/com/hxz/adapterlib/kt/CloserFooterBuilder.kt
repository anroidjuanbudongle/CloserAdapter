package com.hxz.adapterlib.kt

/**
 * @Author:andy
 * @CreateDate:2020/9/19 17:29
 * @Description:适配器底部局
 */
interface CloserFooterBuilder : CloserBuilder {


    fun getFooterLayoutId(): Int

    fun onNormalView(holder: CloserViewHolder)

    fun onLoadingView(holder: CloserViewHolder)

    fun onLoadingFailView(holder: CloserViewHolder, msg: String)

    fun onNoMoreDataView(holder: CloserViewHolder)

}