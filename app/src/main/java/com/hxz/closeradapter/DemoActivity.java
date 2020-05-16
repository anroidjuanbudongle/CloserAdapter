package com.hxz.closeradapter;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hxz.adapterlib.CloserAdapter;
import com.hxz.adapterlib.data.LoadDataListener;
import com.hxz.adapterlib.data.LoadDataStatus;
import com.hxz.closeradapter.adapter.DataModel;
import com.hxz.closeradapter.adapter.MineAdapter;
import com.hxz.closeradapter.adapter.TestEntity;

public class DemoActivity extends AppCompatActivity {

    MineAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        adapter = new MineAdapter();
        recyclerView.setAdapter(adapter);

        // 设置空数据视图
        adapter.setEmptyDataView(R.layout.activity_empty_view);

        // 点击事件
        adapter.setOnItemClickListener(new CloserAdapter.OnItemClickListener<TestEntity>() {
            @Override
            public void onClick(int position, TestEntity data) {
                Toast.makeText(DemoActivity.this, "onClick:" + data.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        // 长按事件
        adapter.setOnItemLongClickListener(new CloserAdapter.OnItemLongClickListener<TestEntity>() {
            @Override
            public void onLongClick(int position, TestEntity data) {
                Toast.makeText(DemoActivity.this, "onLongClick:" + data.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn).setVisibility(View.VISIBLE);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData();
            }
        });
    }

    // 分页加载数据
    private void setData() {
        adapter.clearData();
        adapter.setPaginationData(0, new LoadDataListener() {
            @Override
            public void onLoadingData(final int loadPage, final LoadDataStatus loadDataStatus) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadDataStatus.onNoMoreData();
                    }
                }, 2000);
            }
        });
    }

}

