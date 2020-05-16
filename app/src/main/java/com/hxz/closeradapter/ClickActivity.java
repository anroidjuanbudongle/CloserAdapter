package com.hxz.closeradapter;

import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hxz.adapterlib.CloserAdapter;
import com.hxz.adapterlib.builder.CloserHeaderBuilder;
import com.hxz.adapterlib.builder.CloserMultiItemViewBuilder;
import com.hxz.adapterlib.viewholder.CloserViewHolder;
import com.hxz.closeradapter.adapter.DataModel;
import com.hxz.closeradapter.adapter.TestEntity;

public class ClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        CloserHeaderBuilder mHaderView = new CloserHeaderBuilder() {
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

        CloserMultiItemViewBuilder<TestEntity> multiItemViewBuilder = new CloserMultiItemViewBuilder<TestEntity>() {
            @Override
            public int getLayoutId(int type) {
                if (type == 1) {
                    return R.layout.view_list_item_1;
                }
                return R.layout.view_list_item_2;
            }

            @Override
            public int getItemType(int position, TestEntity data) {
                return data.getType();
            }
        };

        CloserAdapter<TestEntity> adapter = new CloserAdapter<TestEntity>(multiItemViewBuilder) {
            @Override
            public void bindView(CloserViewHolder itemView, TestEntity data, int position) {
                if (data.getType() == 1) {
                    itemView.<TextView>getView(R.id.text_1).setText(data.getTitle());
                } else {
                    itemView.<TextView>getView(R.id.text_2).setText(data.getTitle());
                }
            }
        };


        adapter.addHeader(mHaderView);
        adapter.setData(DataModel.getData());

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new CloserAdapter.OnItemClickListener<TestEntity>() {
            @Override
            public void onClick(int position, TestEntity data) {
                Toast.makeText(ClickActivity.this, "onClick:" + data.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        adapter.setOnItemLongClickListener(new CloserAdapter.OnItemLongClickListener<TestEntity>() {
            @Override
            public void onLongClick(int position, TestEntity data) {
                Toast.makeText(ClickActivity.this, "onLongClick:" + data.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
