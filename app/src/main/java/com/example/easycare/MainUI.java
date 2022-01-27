package com.example.easycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static android.content.Intent.ACTION_CALL;

public class MainUI extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView1,imageView2,imageView3,imageView4;
    RelativeLayout b2,b3,b4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_u_i);
        b2 = (RelativeLayout) findViewById(R.id.doctorId);
        b2.setOnClickListener(this::onClick);
        b3 = (RelativeLayout) findViewById(R.id.emergencyId);
        b3.setOnClickListener(this::onClick);
        b4 = (RelativeLayout) findViewById(R.id.medicineId);
        b4.setOnClickListener(this::onClick);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.medicineId)
        {
            //Toast.makeText(MainUI.this,"Make an Appointment",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainUI.this,medicine.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.doctorId)
        {
            Toast.makeText(MainUI.this,"Make an Appointment",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainUI.this,Appointment.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.emergencyId){
           // Toast.makeText(MainActivity2.this,"An Emergency",Toast.LENGTH_SHORT).show();
            String s = "tel:" + "121";
            Intent intent;
            intent = new Intent(ACTION_CALL);
            intent = intent.setData(Uri.parse(s));
            startActivity(intent);
        }
    }

}