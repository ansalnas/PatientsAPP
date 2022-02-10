package com.example.patientapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPatient extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5;
    AppCompatButton b1;
    String getpatientcode,getname,getaddress,getmobilenum,getdocname;
    dbhelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        ed1=(EditText) findViewById(R.id.mn);
        ed2=(EditText) findViewById(R.id.name);
        ed3=(EditText) findViewById(R.id.add);
        ed4=(EditText) findViewById(R.id.mn);
        ed5=(EditText) findViewById(R.id.dn);
        b1=(AppCompatButton)findViewById(R.id.submit);
        mydb=new dbhelper(this);
        mydb.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getpatientcode = ed1.getText().toString();
                getname = ed2.getText().toString();
                getaddress= ed3.getText().toString();
                getmobilenum= ed4.getText().toString();
                getdocname= ed4.getText().toString();
                boolean status=mydb.insertpatient(getpatientcode,getname,getaddress,getmobilenum,getdocname);
                if(status==true)
                {
                    Toast.makeText(getApplicationContext(),"Successfully inserted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"something error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}