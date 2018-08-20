package com.example.gauranggoel.delenhomeinterntask;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    Activity activity;
    List<MyOrder> order;
    MyOrder orderItem;
    private OnItemClickListener onItemClickListener;
    //static RecyclerViewClickListener itemListener;

    public CustomAdapter(Activity activity, List<MyOrder> order/*,RecyclerViewClickListener itemListener*/) {
        this.activity = activity;
        this.order = order;
     //   this.itemListener=itemListener;
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_order,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(v);
            return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

         orderItem = order.get(position);
        holder.textView1.setText(orderItem.getTime());
        holder.textView2.setText(orderItem.getId());
        holder.textView3.setText(orderItem.getWorkType());
        holder.textView4.setText(orderItem.getWorkerName());
        holder.textView5.setText(orderItem.getStatus());

        if(orderItem.getStatus().equals("Completed"))
        {
            holder.textView6.setText("Rs.0");
        }
        if(!orderItem.getUrl().equals(""))
        {
            Glide.with(activity).load(orderItem.getUrl()).into(holder.img);
        }

        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position, view);
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return order.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{


        public TextView textView1,textView2,textView3,textView4,textView5,textView6;
        ImageView img;
        View thisView;

        public MyViewHolder(View v) {
            super(v);
             textView1=v.findViewById(R.id.workTime);
            textView2=v.findViewById(R.id.trans_Id);
            textView3=v.findViewById(R.id.workerType);
            textView4=v.findViewById(R.id.workerName);
             textView5=v.findViewById(R.id.status);
            textView6=v.findViewById(R.id.cost);

            img = v.findViewById(R.id.imageView);

            thisView=v;
        }

    }

}
