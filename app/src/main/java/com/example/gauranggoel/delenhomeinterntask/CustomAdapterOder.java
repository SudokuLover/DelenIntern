package com.example.gauranggoel.delenhomeinterntask;

import android.app.Activity;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CustomAdapterOder extends ArrayAdapter {

    Activity activity;
    MyOrder order[];
    Integer pic;

    public CustomAdapterOder(Activity activity, MyOrder[] order, Integer pic) {
        super(activity,R.layout.my_order,order);
        this.activity = activity;
        this.order = order;
        this.pic = pic;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = activity.getLayoutInflater();

        View v = layoutInflater.inflate(R.layout.my_order,null);

        TextView textView1=v.findViewById(R.id.workTime);
        TextView textView2=v.findViewById(R.id.trans_Id);
        TextView textView3=v.findViewById(R.id.workerType);
        TextView textView4=v.findViewById(R.id.workerName);
        TextView textView5=v.findViewById(R.id.status);
        TextView textView6=v.findViewById(R.id.cost);

        ImageView img = v.findViewById(R.id.imageView);

        textView1.setText(order[position].time);
        textView2.setText(order[position].id);
        textView3.setText(order[position].workType);
        textView4.setText(order[position].workerName);
        textView5.setText(order[position].status);
        textView6.setText(order[position].cost);

        //Glide.with(activity).load(url)
        return v;
    }
}
