package com.example.gauranggoel.delenhomeinterntask;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Main2Activity extends AppCompatActivity {

    TextView workType,status1,status2,time,address,rate;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle b= getIntent().getExtras();
        workType = findViewById(R.id.workerType1);
        status1=findViewById(R.id.status1);
        status2=findViewById(R.id.status2);
        time=findViewById(R.id.time1);
        address=findViewById(R.id.address1);
        rate=findViewById(R.id.rate);
        img=findViewById(R.id.imageView1);

        workType.setText(b.getString("workType"));

        status1.setText(b.getString("status"));
        status2.setText(b.getString("status"));
        time.setText(b.getString("time"));
        address.setText(b.getString("address"));
        rate.setText(b.getString("cost"));

        if(!b.getString("url").equals("")) {
            Glide.with(this).load(b.getString("url")).into(img);
        }
    }
}
