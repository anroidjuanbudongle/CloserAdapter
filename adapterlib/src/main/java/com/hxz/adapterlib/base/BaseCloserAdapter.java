package com.hxz.adapterlib.base;

import androidx.recyclerview.widget.RecyclerView;

import com.hxz.adapterlib.builder.CloserFooterBuilder;
import com.hxz.adapterlib.builder.CloserHeaderBuilder;
import com.hxz.adapterlib.builder.CloserMultiItemViewBuilder;
import com.hxz.adapterlib.data.LoadDataListener;
import com.hxz.adapterlib.viewholder.CloserViewHolder;

import java.util.HashSet;
import java.util.Set;

/**
 * @author closer
 * @deprecated 顶级适配器
 */
public abstract class BaseCloserAdapter extends RecyclerView.Adapter<CloserViewHolder> {
    /**
     * header Item
     */
    protected static final int TYPE_HEAD = 1999;
    /**
     * footer  Item
     */
    protected static final int TYPE_FOOTER = 1998;
    /**
     * none  Item
     */
    protected static final int TYPE_NONE = 1997;
    /**
     * empty  Item
     */
    protected static final int TYPE_EMPTY = 1996;
    /**
     * 正在获取数据中
     */
    protected static final int LOADING = 1995;
    /**
     * 获取数据失败
     */
    protected static final int LOADING_FAILURE = 1994;
    /**
     * 没有更多的数据
     */
    protected static final int LOADING_NO_MORE = 1993;
    // 唯一头部布局id
    protected int mSingleItemViewLayoutId;
    // 没有数据时显示的提示视图布局文件id
    protected int mEmptyLayoutId = TYPE_NONE;
    // 特殊布局计数器，用来记录特殊布局数量
    protected Set<String> mSpecialViewBuilder = new HashSet<>();
    // 多类型item 构建器
    protected CloserMultiItemViewBuilder mMultiItemViewBuilder;
    // 唯一头部视图构建器
    protected CloserHeaderBuilder mHeaderBuilder;
    // 底部视图构建器
    protected CloserFooterBuilder mFooterBuilder;
    // 加载更多数据监听器
    protected LoadDataListener mLoadDataListener;


    /**
     * 获取里列表中特殊控件的数量
     */
    protected int getSpecialBuilderNum() {
        return mSpecialViewBuilder.size();
    }


    /**
     * 是否为多类型item
     */
    protected boolean isMultiItemView() {
        return mMultiItemViewBuilder != null;
    }


    /**
     * 是否存在header
     */
    protected boolean hasHeaderView() {
        return mHeaderBuilder != null;
    }

    /**
     * 是否存在footer
     */
    protected boolean hasFooterView() {
        return mFooterBuilder != null;
    }

    /**
     * 是否需要加载更多数据
     */
    protected boolean shouldLoadMoreData() {
        return hasFooterView() && mLoadDataListener != null;
    }

    /**
     * 是否设置过空视图
     */
    protected boolean hasEmptyView() {
        return mEmptyLayoutId != TYPE_NONE;
    }

    /**
     * 重新效验position
     * <p>
     * 当添加了特殊View后会对列表中itemView的position造成错乱，需要重新效验position
     */
    protected int checkPosition(int position) {
        int newPosition = position;

        if (hasHeaderView() && position != 0) {
            newPosition = position - 1;
        }
        return newPosition;
    }

    /**
     * 底部构造器未加载or异常
     */
    public static class FooterBuilderNotLoadedException extends RuntimeException {
        public FooterBuilderNotLoadedException() {
            super("CloserFooterBuilder is not loaded");
        }
    }


}
