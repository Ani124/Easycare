package com.example.easycare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import android.os.Bundle;

import java.time.Year;
import java.util.Calendar;

public class Appointment extends AppCompatActivity {

    private static final String TAG="Appoinment";
    private DatePickerDialog.OnDateSetListener date;
    private TextView displayDAte;
    TextView timeshow,doc;
    int hour,minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        doc=(TextView)findViewById(R.id.doc_input);
        String docname=getIntent().getStringExtra("docname");
        doc.setText(docname);
        displayDAte=(TextView)findViewById(R.id.setDate);
        timeshow=(TextView)findViewById(R.id.setTime);
        displayDAte.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Calendar c=Calendar.getInstance();
                int year=c.get(Calendar.YEAR);
                int month=c.get(Calendar.MONTH);
                int day=c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog=new DatePickerDialog(Appointment.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,date,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        date=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                Log.d(TAG,"Setting Date"+year+"/"+month+"/"+dayOfMonth);
                String date2=dayOfMonth+"/"+month+"/"+year;
                displayDAte.setText(date2);
            }
        };
        timeshow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final Calendar ct= Calendar.getInstance();
                hour=ct.get(Calendar.HOUR_OF_DAY);
                minute=ct.get(Calendar.MINUTE);
                TimePickerDialog tpd=new TimePickerDialog(Appointment.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        timeshow.setText(hourOfDay+" : "+minute);
                    }
                },hour,minute,false);
                tpd.show();
            }
        });
    }

    public void buttonClicked1(View view)
    {
        Button button=(Button)findViewById(R.id.docButton);
        Intent intent=new Intent(Appointment.this,doctorPage2.class);

        startActivity(intent);
    }
    public void buttonClicked2(View view)
    {

    }
}