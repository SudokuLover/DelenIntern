package com.example.gauranggoel.delenhomeinterntask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<MyOrder> orderList;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            recyclerView.setAdapter(customAdapter);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });



    }
}
