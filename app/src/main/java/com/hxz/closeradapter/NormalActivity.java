package com.hxz.closeradapter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hxz.adapterlib.CloserAdapter;
import com.hxz.adapterlib.viewholder.CloserViewHolder;
import com.hxz.closeradapter.adapter.DataModel;
import com.hxz.closeradapter.adapter.TestEntity;

public class NormalActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        CloserAdapter<TestEntity> adapter = new CloserAdapter<TestEntity>(R.layout.view_list_item_1) {
            @Override
            public void bindView(CloserViewHolder itemView, TestEntity data, int position) {
                itemView.<TextView>getView(R.id.text_1).setText(data.getTitle());
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.setData(DataModel.getData());
    }

}
