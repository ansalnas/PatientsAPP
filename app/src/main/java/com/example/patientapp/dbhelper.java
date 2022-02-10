package com.example.patientapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {
    static String DBname="patientApp.db";
    static String Tablename="Patient";
    static String col1="id";
    static String col2="patcode";
    static String col3="patname";
    static String col4="pataddress";
    static String col5="mobilenumber";
    static String col6="doctorname";
    public dbhelper(Context context) {
        super(context,DBname , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table "+Tablename+"("+col1+" integer primary key autoincrement,"+col2+" text,"+col3+" text,"+col4+" text,"+col5+" text,"+col6+" text)";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="drop table if exists "+Tablename;
        db.execSQL(query);
        onCreate(db);

    }
    public boolean insertpatient(String patcode,String patname,String pataddress,String mobilenumber,String doctorname)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put(col2,patcode);
        content.put(col3,patname);
        content.put(col4,pataddress);
        content.put(col5,mobilenumber);
        content.put(col6,doctorname);
        long status=db.insert(Tablename,null,content);
        if(status==-1)
        {
            return false;
        }
        else{
            return true;
        }
    }
    public Cursor searchpatient(String mobilenumber){
        SQLiteDatabase db=this.getWritableDatabase();
        String query ="select * from "+ Tablename+" where "+ col5+"="+"'"+mobilenumber+"'";
        Cursor c=db.rawQuery(query,null);
        return c;
    }}