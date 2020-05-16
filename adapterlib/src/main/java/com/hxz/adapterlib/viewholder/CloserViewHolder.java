package com.hxz.adapterlib.viewholder;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Closer
 * @deprecated 通用 holder
 */
public class CloserViewHolder extends RecyclerView.ViewHolder {

    // 布局中子view缓存
    private SparseArray<View> mViews;

    // 根布局
    private View mConvertView;


    public CloserViewHolder(@NonNull View itemView) {
        super(itemView);
        mConvertView = itemView;
        mViews = new SparseArray<>();
    }


    /**
     * 绑定item view布局，生成view holder
     */
    public static CloserViewHolder bindView(ViewGroup parent, int layoutId) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new CloserViewHolder(view);
    }

    /**
     * 通过id 获取item view中的view 控件
     *
     * @param <T> 控件类型
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }


}
