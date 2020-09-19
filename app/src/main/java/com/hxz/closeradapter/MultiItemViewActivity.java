package com.hxz.closeradapter;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hxz.adapterlib.kt.CloserAdapter;
import com.hxz.adapterlib.kt.CloserMultiItemViewBuilder;
import com.hxz.adapterlib.viewholder.CloserViewHolder;
import com.hxz.closeradapter.adapter.DataModel;
import com.hxz.closeradapter.adapter.TestEntity;



public class MultiItemViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        CloserMultiItemViewBuilder<TestEntity> mBuilder = new CloserMultiItemViewBuilder<TestEntity>() {
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

        CloserAdapter<TestEntity> adapter = new CloserAdapter<TestEntity>(mBuilder) {
            @Override
            public void bindView(CloserViewHolder itemView, TestEntity data, int position) {
                if (data.getType() == 0) {
                    itemView.<TextView>getView(R.id.text_1).setText(data.getTitle());
                } else {
                    itemView.<TextView>getView(R.id.text_2).setText(data.getTitle());
                }
            }
        };

        recyclerView.setAdapter(adapter);
        adapter.setData(DataModel.getData());

    }
}
