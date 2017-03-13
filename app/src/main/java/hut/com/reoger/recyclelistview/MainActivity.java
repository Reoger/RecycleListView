package hut.com.reoger.recyclelistview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import hut.com.reoger.recyclelistview.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;


    private int colors[] = {android.R.color.holo_blue_bright, android.R.color.black, android.R.color.holo_red_dark};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerView);

        //构造参数里面的2表示的是一行有两列
        final GridLayoutManager manager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(manager);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = mRecyclerView.getAdapter().getItemViewType(position);
                //若是TYPE_THREE，占用两列，否则占用一列
                if (type == Person.TYPE_THREE) {
                    return manager.getSpanCount();
                } else {
                    return 1;
                }
            }
        });
        mMyAdapter = new MyAdapter(this);

        //给布局里的子view添加边距
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = layoutParams.getSpanSize();
                int spanIndex = layoutParams.getSpanIndex();
                outRect.top = 20;
                if (spanSize != manager.getSpanCount()) {
                    if (spanIndex == 0) {
                        outRect.right = 0;
                    } else {
                        outRect.right = 10;
                    }
                }
            }
        });
        mRecyclerView.setAdapter(mMyAdapter);


    }

    private void initData() {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Person p = new Person();
            int type = (int) (Math.random() * 3 + 1);
            p.type = type;
            p.content = "content" + 1;
            p.avaterColor = colors[type - 1];
            p.name = "name" + i;
            list.add(p);
        }
        mMyAdapter.addList(list);
        mMyAdapter.notifyDataSetChanged();
    }
}
