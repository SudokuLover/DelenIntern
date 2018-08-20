package com.example.gauranggoel.delenhomeinterntask;

import android.app.Activity;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    Activity activity;
    List<MyOrder> order;
    MyOrder orderItem;

    public CustomAdapter(Activity activity, List<MyOrder> order) {
        this.activity = activity;
        this.order = order;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_order,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

         orderItem = order.get(position);
        holder.textView1.setText(orderItem.getTime());
        holder.textView2.setText(orderItem.getId());
        holder.textView3.setText(orderItem.getWorkType());
        holder.textView4.setText(orderItem.getWorkerName());
        holder.textView5.setText(orderItem.getStatus());
        //holder.textView6.setText(orderItem.getCost());

        if(orderItem.getStatus().equals("Completed"))
        {
            holder.textView6.setText("Rs.0");
        }
        if(!orderItem.getUrl().equals(""))
        {
            Glide.with(activity).load(orderItem.getUrl()).into(holder.img);
        }
    }

    @Override
    public int getItemCount() {
        return order.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{


        public TextView textView1,textView2,textView3,textView4,textView5,textView6;
        ImageView img;

        public MyViewHolder(View v) {
            super(v);
             textView1=v.findViewById(R.id.workTime);
            textView2=v.findViewById(R.id.trans_Id);
            textView3=v.findViewById(R.id.workerType);
            textView4=v.findViewById(R.id.workerName);
             textView5=v.findViewById(R.id.status);
            textView6=v.findViewById(R.id.cost);

            img = v.findViewById(R.id.imageView);
        }
    }
/*

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

    @Override
    public CustomAdaptor.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CustomAdaptor.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
*/
}
