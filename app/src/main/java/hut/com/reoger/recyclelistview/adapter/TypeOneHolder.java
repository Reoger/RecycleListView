package hut.com.reoger.recyclelistview.adapter;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import hut.com.reoger.recyclelistview.Person;
import hut.com.reoger.recyclelistview.R;

/**
 * Created by 24540 on 2017/3/13.
 */

public class TypeOneHolder extends TypeAbstartViewHolder {
    private ImageView avater;
    private TextView name;

    public TypeOneHolder(View itemView) {
        super(itemView);
        avater = (ImageView) itemView.findViewById(R.id.avater);
        name = (TextView) itemView.findViewById(R.id.name);
    }


    //为ViewHolder绑定数据
    @Override
    public void bindHolder(Person person) {
        avater.setBackgroundResource(person.getAvaterColor());
        name.setText(person.getName());
    }
}
