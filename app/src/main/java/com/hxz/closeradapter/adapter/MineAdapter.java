package com.hxz.closeradapter.adapter;


import android.widget.ImageView;
import android.widget.TextView;

import com.hxz.adapterlib.CloserAdapter;
import com.hxz.adapterlib.builder.CloserHeaderBuilder;
import com.hxz.adapterlib.builder.CloserMultiItemViewBuilder;
import com.hxz.adapterlib.view.SimpleFooterBuilder;
import com.hxz.adapterlib.viewholder.CloserViewHolder;
import com.hxz.closeradapter.R;


public class MineAdapter extends CloserAdapter<TestEntity> {


    private static CloserMultiItemViewBuilder<TestEntity> multiItemViewBuilder = new CloserMultiItemViewBuilder<TestEntity>() {

        @Override
        public int getLayoutId(int type) {
            if (type == 0) {
                return R.layout.view_list_item_1;
            } else {
                return R.layout.view_list_item_2;
            }
        }

        @Override
        public int getItemType(int position, TestEntity data) {
            return data.getType();
        }
    };

    public MineAdapter() {
        super(multiItemViewBuilder);
        addHeader();
        addFooter();
    }

    @Override
    public void bindView(CloserViewHolder itemView, TestEntity data, int position) {
        if (data.getType() == 0) {
            itemView.<TextView>getView(R.id.text_1).setText(data.getTitle());
        } else {
            itemView.<TextView>getView(R.id.text_2).setText(data.getTitle());
        }
    }

    private void addHeader() {
        this.addHeader(new CloserHeaderBuilder() {
            @Override
            public int getHeaderView() {
                return R.layout.view_header_single;
            }

            @Override
            public void bindHeaderView(CloserViewHolder mHolder) {
                mHolder.<ImageView>getView(R.id.header_img).setImageResource(R.mipmap.ic_launcher);
                mHolder.<TextView>getView(R.id.header_tv).setText("这是一个头部");
            }
        });
    }


    public void addFooter() {
        this.addFooter(new SimpleFooterBuilder("这是个底部", "正在加载数据中", "加载数据失败", "已经到底啦"));
    }
}
