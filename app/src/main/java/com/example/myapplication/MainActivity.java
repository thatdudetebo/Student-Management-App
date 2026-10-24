package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private DbAdapter adapter;
    EditText editname, editdept, editphone, editid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editname = findViewById(R.id.editTextName);
        editdept = findViewById(R.id.editTextDept);
        editphone = findViewById(R.id.editTextPhone);
        editid = findViewById(R.id.editTextIdentity);

        Button btnregister = findViewById(R.id.register);
        Button btnviewall = findViewById(R.id.viewall);
        Button btnupdate = findViewById(R.id.update);
        Button btndelete = findViewById(R.id.delete);

        adapter=new DbAdapter(this);

        btnregister.setOnClickListener(v -> {
            adapter.open();
            long id = adapter.insertRecord(editname.getText().toString(),
                    editdept.getText().toString(),
                    editphone.getText().toString(),
                    editid.getText().toString());
            adapter.close();
            Toast.makeText(this, "STUDENT INFORMATION SAVED SUCCESSFULLY" + id, Toast.LENGTH_SHORT).show();

        });

        btnupdate.setOnClickListener(v -> {
            adapter.open();
            int id = adapter.update(editname.getText().toString(),
                    editdept.getText().toString(),
                    editphone.getText().toString(),
                    editid.getText().toString());
            adapter.close();
            Toast.makeText(this, "STUDENT INFORMATION UPDATED SUCCESSFULLY" + id, Toast.LENGTH_SHORT).show();
        });

        btnviewall.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, RecordsActivity.class);
            startActivity(i);
        });
        btndelete.setOnClickListener(v -> {
            adapter.open();
            int id = adapter.delete(editid.getText().toString());
            adapter.close();
            Toast.makeText(this, "STUDENT INFORMATION DELETED SUCCESSFULLY" + id, Toast.LENGTH_SHORT).show();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });



    }
}