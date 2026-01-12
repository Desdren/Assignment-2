package com.example.assignment_2dec_14;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        //intent data get
        Intent i = getIntent();
        int scode = i.getIntExtra("scode", -1);

        dbHelper = new DatabaseHelper(this);
        Student student = null;
        if (scode != -1) {
            student = dbHelper.getStudentByCode(scode);
        }

        //Action Bar
        ActionBar myActionBar = getSupportActionBar();
        if (myActionBar != null) {
            myActionBar.setTitle("CAMPUS COMPANION");
            myActionBar.show();
        }

        TextView nameBar = findViewById(R.id.nameData);
        TextView progBar = findViewById(R.id.programmeData);
        TextView semBar = findViewById(R.id.semData);

        if (student != null) {
            nameBar.append(student.getSname());
            progBar.setText("Programme: " + student.getScourse());
            semBar.setText("Semester: " + student.getSsem());
        }

        //fragments
        FragmentManager myManager = getSupportFragmentManager();
        FragmentTransaction transaction = myManager.beginTransaction();

        AnnouncementsFragment af = new AnnouncementsFragment();
        EventsFragment ef = new EventsFragment();

        transaction.add(R.id.announcements, af);
        transaction.add(R.id.events, ef);

        transaction.commit();
    }
}