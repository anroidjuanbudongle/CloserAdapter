package com.hxz.adapterlib.view;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.hxz.adapterlib.kt.CloserViewHolder;
import com.hxz.adapterlib.R;
import com.hxz.adapterlib.kt.CloserFooterBuilder;


import org.jetbrains.annotations.NotNull;

/**
 * @author Closer  自定义footer加载
 */
public class SimpleFooterBuilder implements CloserFooterBuilder {

    private String normalMsg;
    private String onLoadingMsg;
    private String onLoadingFailureMsg;
    private String onNoMoreDataMsg;


    public SimpleFooterBuilder(String normalMsg, String onLoadingMsg, String onLoadingFailureMsg
            , String onNoMoreDataMsg) {
        this.normalMsg = normalMsg;
        this.onLoadingMsg = onLoadingMsg;
        this.onLoadingFailureMsg = onLoadingFailureMsg;
        this.onNoMoreDataMsg = onNoMoreDataMsg;
    }


    @Override
    public int getFooterLayoutId() {
        return R.layout.view_simple_footer;
    }


    @Override
    public void onNormalView(@NotNull CloserViewHolder holder) {
        holder.<ProgressBar>getView(R.id.footer_progress).setVisibility(View.GONE);
        holder.<TextView>getView(R.id.footer_msg).setText(this.normalMsg);
    }

    @Override
    public void onLoadingView(@NotNull CloserViewHolder holder) {
        holder.<ProgressBar>getView(R.id.footer_progress).setVisibility(View.VISIBLE);
        holder.<TextView>getView(R.id.footer_msg).setText(this.onLoadingMsg);
    }

    @Override
    public void onLoadingFailView(@NotNull CloserViewHolder holder, @NotNull String msg) {
        holder.<ProgressBar>getView(R.id.footer_progress).setVisibility(View.GONE);
        holder.<TextView>getView(R.id.footer_msg).setText(msg == null || msg.equals("") ? this.onLoadingFailureMsg : msg);
    }

    @Override
    public void onNoMoreDataView(@NotNull CloserViewHolder holder) {
        holder.<ProgressBar>getView(R.id.footer_progress).setVisibility(View.GONE);
        holder.<TextView>getView(R.id.footer_msg).setText(this.onNoMoreDataMsg);
    }
}
