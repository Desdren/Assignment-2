package com.example.assignment_2dec_14;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewStudent extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    ListView listView;
    StudentAdapter adapter;
    ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);

        // Set action bar title
        ActionBar myActionBar = getSupportActionBar();
        if (myActionBar != null) {
            myActionBar.setTitle("STUDENT INFO");
            myActionBar.show();
        }

        listView = findViewById(R.id.dataStudent);
        databaseHelper = new DatabaseHelper(this);

        students = databaseHelper.getStudents();

        adapter = new StudentAdapter(this, students);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, android.view.View view, int position, long id) {

                // Get the student to delete
                Student student = students.get(position);

                // Show confirmation dialog
                new AlertDialog.Builder(ViewStudent.this)
                        .setTitle("Delete Student")
                        .setMessage("Are you sure you want to delete " + student.getSname() + "?")
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                databaseHelper.deleteStudent(student.getScode());

                                students.remove(position);

                                adapter.notifyDataSetChanged();

                                Toast.makeText(ViewStudent.this, "Student deleted!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
                return true;
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Student student = students.get(position); // get clicked student

            Intent intent = new Intent(ViewStudent.this, SecondActivity.class);
            intent.putExtra("scode", student.getScode()); // only pass unique code
            startActivity(intent);
        });

    }
}
