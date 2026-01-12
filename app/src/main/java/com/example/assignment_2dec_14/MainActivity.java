package com.example.assignment_2dec_14;

import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.*;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String name, programme, semester;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Buttons in Main
        Button b1 = findViewById(R.id.view_info_btn);
        Button b2 = findViewById(R.id.stud_info_btn);

        //View Info Button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewStudent.class);
                startActivity(intent);
            }
        });

        //Add Student Info Button
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_student);
                dialog.setTitle("Add Student Here");
                dialog.show();

                // Widgets
                EditText nameGet = dialog.findViewById(R.id.nameInput);
                EditText programmeGet = dialog.findViewById(R.id.programmeInput);
                EditText emailGet = dialog.findViewById(R.id.emailInput);
                EditText studCodeGet = dialog.findViewById(R.id.stuCodeInput);
                EditText semGet = dialog.findViewById(R.id.semInput);
                Button addStudent = dialog.findViewById(R.id.addStudBtn);

                try {
                    dbHelper = new DatabaseHelper(MainActivity.this);
                } catch (SQLiteException e) {
                    Toast.makeText(MainActivity.this, "DATABASE ERROR :(", Toast.LENGTH_SHORT).show();
                }

                addStudent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = nameGet.getText().toString().trim();
                        String programme = programmeGet.getText().toString().trim();
                        String email = emailGet.getText().toString().trim();
                        Integer codeStr = Integer.valueOf(studCodeGet.getText().toString().trim());
                        Integer semStr = Integer.valueOf(semGet.getText().toString().trim());

                        if (name.isEmpty() || programme.isEmpty() || email.isEmpty() || codeStr==0 || semStr==0) {
                            Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        dbHelper.addStudent(name, programme, email, codeStr, semStr);

                        Toast.makeText(MainActivity.this, "Added Student Successfully!", Toast.LENGTH_SHORT).show();

                        dialog.dismiss();
                    }
                });
            }
        });


        //Action Bar Stuff
        ActionBar myActionBar = getSupportActionBar();

        if (myActionBar != null) {
            myActionBar.setTitle("Home Page");
            myActionBar.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.popup_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.dashboard_optn){
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("name", name);
            i.putExtra("semester", semester);
            i.putExtra("programme", programme);
            startActivity(i);
            return true;
        }
        else if(id == R.id.settings_optn){
            Toast.makeText(this, "Feature Coming Later", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}