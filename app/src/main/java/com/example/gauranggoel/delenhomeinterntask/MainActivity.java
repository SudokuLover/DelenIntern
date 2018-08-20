package com.example.gauranggoel.delenhomeinterntask;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

  List<MyOrder> orderList;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if(connectivityManager.getActiveNetworkInfo()!=null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected() )
        {
            final ProgressDialog pd = new ProgressDialog(MainActivity.this);
            pd.setCanceledOnTouchOutside(true);
            pd.setMessage("downloading data");
            pd.show();
            recyclerView = findViewById(R.id.recyclerView);

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            orderList=new ArrayList<>();

            databaseReference = FirebaseDatabase.getInstance().getReference(Refrences.DATABASE_REFRENCE);

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for( DataSnapshot postSnapshot :dataSnapshot.getChildren() )
                    {
                        MyOrder order = postSnapshot.getValue(MyOrder.class);
                        orderList.add(order);
                    }
                    customAdapter = new CustomAdapter(MainActivity.this,orderList);

                    customAdapter.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(int itemId, View view) {
                            Intent i = new Intent(MainActivity.this,Main2Activity.class);
                            MyOrder orderItem = orderList.get(itemId);
                            i.putExtra("time",orderItem.getTime());
                            i.putExtra("address",orderItem.getAddress());
                            i.putExtra("status",orderItem.getStatus());
                            i.putExtra("workType",orderItem.getWorkType());
                            i.putExtra("cost",orderItem.getCost());
                            i.putExtra("id",orderItem.getId());
                            i.putExtra("workerName",orderItem.getWorkerName());
                            i.putExtra("url",orderItem.getUrl());

                            startActivity(i);
                            finish();
                        }
                    });

                    recyclerView.setAdapter(customAdapter);
                    pd.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }
        else{
            Toast.makeText(this, "Please check your internet", Toast.LENGTH_SHORT).show();
        }
    }
}
