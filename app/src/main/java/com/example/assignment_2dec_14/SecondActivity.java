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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        ArrayList<Events> events = new ArrayList<>();

        //Action Bar
        ActionBar myActionBar = getSupportActionBar();
        if (myActionBar != null) {
            myActionBar.setTitle("CAMPUS COMPANION");
            myActionBar.show();
        }

        //intent data get
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String programme = i.getStringExtra("programme");
        String semester = i.getStringExtra("semester");

        TextView nameBar = findViewById(R.id.nameData);
        TextView progBar = findViewById(R.id.programmeData);
        TextView semBar = findViewById(R.id.semData);

        //placing data in textviews
        nameBar.append(" " + name);
        progBar.append(" "+programme);
        semBar.append(" "+semester);

        FragmentManager myManager = getSupportFragmentManager();
        FragmentTransaction transaction = myManager.beginTransaction();

        AnnouncementsFragment af = new AnnouncementsFragment();
        EventsFragment ef = new EventsFragment();

        transaction.add(R.id.announcements, af);
        transaction.add(R.id.events, ef);

        transaction.commit();
    }
}