package com.example.easycare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
//import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class doctorPage extends AppCompatActivity {

    private ListView list;
    DataSnapshot dataSnapshot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_page);
        list=(ListView)findViewById(R.id.listviewid);
        TextView tt1=(TextView)findViewById(R.id.textviewid2);
        Toast.makeText(doctorPage.this, "Here it is ", Toast.LENGTH_SHORT).show();
        //String [] docName=getResources().getStringArray(R.array.doctorsList);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getInstance().getReference().child("Doctors");

        ArrayList<String> list2=new ArrayList<>();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(doctorPage.this,R.layout.doctorlist_layout,R.id.textviewid2,list2);
        //ArrayAdapter adapter= new ArrayAdapter(this,R.layout.doctorlist_layout,list2);
        // CustomAdapter adapter2= new CustomAdapter(this,)
        list.setAdapter(adapter);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                list2.clear();
                for(DataSnapshot Snapshot: dataSnapshot.getChildren())
                {

                    list2.add(Snapshot.getValue().toString());
                    adapter.notifyDataSetChanged();
                }


                // Log.d(TAG, "Value is: " + value);
                //
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //   Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value= list2.get(position);

                Toast.makeText(doctorPage.this,value,Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent(doctorPage.this,Appointment.class);
                intent2.putExtra("docname",value);
                startActivity(intent2);
            }
        });




    }



}