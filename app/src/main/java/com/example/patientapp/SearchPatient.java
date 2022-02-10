package com.example.patientapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchPatient extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    AppCompatButton b1;
    String getmobilenum,getname,getaddress,getdocname;
    dbhelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patient);
        ed1=(EditText) findViewById(R.id.mn);
        ed2=(EditText) findViewById(R.id.name);
        ed3=(EditText) findViewById(R.id.add);
        ed4=(EditText) findViewById(R.id.dn);
        b1=(AppCompatButton) findViewById(R.id.search);
        mydb=new dbhelper(this);
        mydb.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getmobilenum= ed1.getText().toString();
                Cursor c= mydb.searchpatient(getmobilenum);
                if(c.getCount()==0){
                    Toast.makeText(getApplicationContext(),"Patient  not found",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while(c.moveToNext())
                    {
                        getname=c.getString(2);
                        getaddress=c.getString(3);
                        getdocname=c.getString(4);
                    }
                    ed2.setText(getname);
                    ed3.setText(getaddress);
                    ed4.setText(getdocname);

                }
            }
        });
    }
}
