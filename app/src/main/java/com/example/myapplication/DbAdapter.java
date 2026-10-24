package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.myapplication.myDbHelper;

public class DbAdapter {
    private final myDbHelper dbHelper;
    private SQLiteDatabase db;

    public DbAdapter(Context context){
        dbHelper = new myDbHelper(context);
    }
    public void open(){
        db = dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }
    public long insertRecord(String name, String dept, String phone, String id){
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("dept", dept);
        cv.put("phone", phone);
        cv.put("id", id);
        return db.insert("student", null, cv);
    }
    public Cursor getAllRecords(){
        return db.query("student", null, null, null, null, null, null);
    }
    public int update(String name, String dept, String phone, String id){
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("dept", dept);
        cv.put("phone", phone);
        return db.update("student", cv, "id = ?", new String[]{id});
    }
    public int delete(String id){
        return db.delete("student", "id = ?", new String[]{id});
    }
}
