package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecordsActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.records);
        TextView textView2 = findViewById(R.id.textView2);
        DbAdapter adapter = new DbAdapter(this);
        adapter.open();
        Cursor c=adapter.getAllRecords();
        StringBuilder sb = new StringBuilder();
        textView2.setText("STUDENT INFORMATION \n");
        while (c.moveToNext()){
            sb.append("Name: ").append(c.getString(0)).append("\n");
            sb.append("Department: ").append(c.getString(1)).append("\n");
            sb.append("Phone: ").append(c.getString(2)).append("\n");
            sb.append("ID: ").append(c.getString(3)).append("\n\n");
        }
        c.close();
        adapter.close();
        textView2.setText(sb.toString());
    }
}
