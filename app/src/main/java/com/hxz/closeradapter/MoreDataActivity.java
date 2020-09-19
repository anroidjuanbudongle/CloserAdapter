package com.hxz.closeradapter;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hxz.adapterlib.kt.CloserAdapter;
import com.hxz.adapterlib.kt.CloserHeaderBuilder;
import com.hxz.adapterlib.data.LoadDataListener;
import com.hxz.adapterlib.view.SimpleFooterBuilder;
import com.hxz.adapterlib.viewholder.CloserViewHolder;

import com.hxz.closeradapter.adapter.TestEntity;

public class MoreDataActivity extends AppCompatActivity {


    CloserAdapter<TestEntity> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new CloserAdapter<TestEntity>(R.layout.view_list_item_1) {
            @Override
            public void bindView(CloserViewHolder itemView, TestEntity data, int position) {
                itemView.<TextView>getView(R.id.text_1).setText(data.getTitle());
            }
        };
        recyclerView.setAdapter(adapter);
        CloserHeaderBuilder builder = new CloserHeaderBuilder() {
            @Override
            public int getHeaderView() {
                return R.layout.view_header_single;
            }

            @Override
            public void bindHeaderView(CloserViewHolder mHolder) {
                mHolder.<ImageView>getView(R.id.header_img).setImageResource(R.mipmap.ic_launcher);
                mHolder.<TextView>getView(R.id.header_tv).setText("这是一个头部");
            }
        };
        adapter.addHeader(builder);
        adapter.addFooter(new SimpleFooterBuilder("这是个底部", "正在加载数据中", "加载数据失败", "已经到底啦"));
        adapter.setEmptyDataView(R.layout.activity_empty_view);
        findViewById(R.id.btn).setVisibility(View.VISIBLE);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData();
            }
        });

        adapter.clearData();
        adapter.setPaginationData(-1, new LoadDataListener() {
            @Override
            public void onLoadingData(final int loadPage, final LoadDataStatus loadDataStatus) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       // loadDataStatus.onSuccess(DataModel.getMoreData(loadPage));
                    }
                }, 2000);
            }
        });

    }

    private void setData() {

    }
}
