package com.example.gauranggoel.delenhomeinterntask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Main2Activity extends AppCompatActivity {

    TextView workType,status1,status2,time,address,rate,id;
    ImageView img,backIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        getSupportActionBar().hide();

        Bundle b= getIntent().getExtras();
        workType = findViewById(R.id.workerType1);
        status1=findViewById(R.id.status1);
        status2=findViewById(R.id.status2);
        time=findViewById(R.id.time1);
        address=findViewById(R.id.address1);
        rate=findViewById(R.id.rate);
        id=findViewById(R.id.id);
        img=findViewById(R.id.imageView1);
        backIcon=findViewById(R.id.icon);

        workType.setText(b.getString("workType"));

        status1.setText(b.getString("status"));
        status2.setText(b.getString("status"));
        time.setText(b.getString("time"));
        address.setText(b.getString("address"));
        rate.setText(b.getString("cost"));
        id.setText(b.getString("id"));

        if(!b.getString("url").equals("")) {
            Glide.with(this).load(b.getString("url")).into(img);
        }

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
