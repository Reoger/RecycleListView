package hut.com.reoger.recyclelistview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import hut.com.reoger.recyclelistview.Person;

/**
 * Created by 24540 on 2017/3/13.
 */

public abstract class TypeAbstartViewHolder extends RecyclerView.ViewHolder {
    public TypeAbstartViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(Person person);

}
