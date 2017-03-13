package hut.com.reoger.recyclelistview.adapter;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import hut.com.reoger.recyclelistview.Person;
import hut.com.reoger.recyclelistview.R;

/**
 * Created by 24540 on 2017/3/13.
 */

public class TypeThreeHolder extends TypeAbstartViewHolder {
    private ImageView avater;
    private TextView name;
    private TextView content;
    private ImageView iv;

    public TypeThreeHolder(View itemView) {
        super(itemView);
        avater = (ImageView) itemView.findViewById(R.id.avater);
        name = (TextView) itemView.findViewById(R.id.name);
        content = (TextView) itemView.findViewById(R.id.content);
        iv = (ImageView) itemView.findViewById(R.id.content_color);
    }


    //为ViewHolder绑定数据
    @Override
    public void bindHolder(Person person) {
        avater.setBackgroundResource(person.getAvaterColor());
        name.setText(person.getName());
        content.setText(person.getContent());
        iv.setBackgroundResource(person.getAvaterColor());
    }
}
