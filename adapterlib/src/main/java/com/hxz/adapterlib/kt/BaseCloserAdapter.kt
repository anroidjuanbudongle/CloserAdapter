package com.hxz.adapterlib.kt

import androidx.recyclerview.widget.RecyclerView
import com.hxz.adapterlib.data.LoadDataListener
import java.util.*

/**
 * @Author:andy
 * @CreateDate:2020/9/19 17:07
 * @Description:BaseCloserAdapter
 */
abstract class BaseCloserAdapter : RecyclerView.Adapter<CloserViewHolder>() {

    //多type区别
    protected val typeHead = 1999
    protected val typeFooter = 1998
    private val typeNone = 1997
    protected val typeEmpty = 1996
    protected val loading = 1995
    protected val loadingFailure = 1994
    protected val loadingNoMore = 1993


    // 唯一头部布局id
    protected var mSingleItemViewLayoutId = 0

    // 没有数据时显示的提示视图布局文件id
    protected var mEmptyLayoutId = typeNone

    // 特殊布局计数器，用来记录特殊布局数量
    protected var mSpecialViewBuilder: Set<String> = HashSet()

    // 多类型item 构建器
    protected var mMultiItemViewBuilder: CloserMultiItemViewBuilder<*>? = null

    // 唯一头部视图构建器
    protected var mHeaderBuilder: CloserHeaderBuilder? = null

    // 底部视图构建器
    protected var mFooterBuilder: CloserFooterBuilder? = null

    // 加载更多数据监听器
    protected var mLoadDataListener: LoadDataListener<*>? = null

    /**
     * 获取里列表中特殊控件的数量
     */
    protected open fun getSpecialBuilderNum(): Int {
        return mSpecialViewBuilder.size
    }


    /**
     * 是否为多类型item
     */
    protected open fun isMultiItemView(): Boolean {
        return mMultiItemViewBuilder != null
    }


    /**
     * 是否存在header
     */
    protected open fun hasHeaderView(): Boolean {
        return mHeaderBuilder != null
    }

    /**
     * 是否存在footer
     */
    protected open fun hasFooterView(): Boolean {
        return mFooterBuilder != null
    }

    /**
     * 是否需要加载更多数据
     */
    protected open fun shouldLoadMoreData(): Boolean {
        return hasFooterView() && mLoadDataListener != null
    }

    /**
     * 是否设置过空视图
     */
    protected open fun hasEmptyView(): Boolean {
        return mEmptyLayoutId != typeNone
    }

    /**
     * 重新效验position
     *
     *
     * 当添加了特殊View后会对列表中itemView的position造成错乱，需要重新效验position
     */
    protected open fun checkPosition(position: Int): Int {
        var newPosition = position
        if (hasHeaderView() && position != 0) {
            newPosition = position - 1
        }
        return newPosition
    }

    /**
     * 底部构造器未加载or异常
     */
    class FooterException : RuntimeException("CloserFooterBuilder is not loaded")

}