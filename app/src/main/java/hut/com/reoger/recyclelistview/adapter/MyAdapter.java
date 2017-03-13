package hut.com.reoger.recyclelistview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hut.com.reoger.recyclelistview.Person;
import hut.com.reoger.recyclelistview.R;

/**
 * Created by 24540 on 2017/3/13.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mLayoutInflater;

    private List<Person> mList = new ArrayList<>();

    private Context mContext;

    public MyAdapter(Context mContext) {
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    //使用此方法从获取数据
    public void addList(List<Person> list){
        mList.addAll(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //根据不同的viewType，创建并返回影响的ViewHolder
        switch (viewType){
            case Person.TYPE_ONE:
                return new TypeOneHolder(mLayoutInflater.inflate(R.layout.item_type_one,parent,false));
            case Person.TYPE_TWO:
                return new TypeTwoHolder(mLayoutInflater.inflate(R.layout.item_type_two,parent,false));
            case Person.TYPE_THREE:
                return new TypeThreeHolder(mLayoutInflater.inflate(R.layout.item_type_three,parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //抽象出TypeAbstartViewHolder，所以在进行绑定的时候可以直接调用
        ((TypeAbstartViewHolder)holder).bindHolder(mList.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
