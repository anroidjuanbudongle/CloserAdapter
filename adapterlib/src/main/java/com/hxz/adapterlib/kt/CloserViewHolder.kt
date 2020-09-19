package com.hxz.adapterlib.kt

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @Author:andy
 * @CreateDate:2020/9/19 17:09
 * @Description:改写Kotlin,通用ViewHolder
 */
class CloserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    //存放View
    private var mViews: SparseArray<View>? = null

    //根View
    private var mRootView: View? = null


    init {
        mRootView = itemView
        mViews = SparseArray()
    }

    /**
     * 绑定item view布局，生成view holder
     */
    fun bindView(mViewGroup: ViewGroup, mLayoutId: Int): CloserViewHolder? {

        return CloserViewHolder(LayoutInflater.from(mViewGroup.context).inflate(mLayoutId, mViewGroup, false))
    }


    /**
     *  通过id 获取item view中的view 控件
     */
    fun <T : View?> getView(mViewId: Int): T {
        var mView = mViews!![mViewId]
        if (mView == null) {
            mView = mRootView!!.findViewById(mViewId)
            mViews!!.put(mViewId, mView)
        }
        return mView as T
    }


}