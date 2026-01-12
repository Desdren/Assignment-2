package com.example.assignment_2dec_14;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    final Context context;

    final ArrayList<Student> studentArrayList;

    public StudentAdapter(Context context, ArrayList<Student> studentArrayList) {
        this.context = context;
        this.studentArrayList = studentArrayList;
    }

    @Override
    public int getCount() {
        return studentArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return studentArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.view_student_list_item, viewGroup, false);
        }

        TextView vsName, vsCourse, vsEmail, vsStCode, vsSem;

        vsName = view.findViewById(R.id.s_name);
        vsCourse = view.findViewById(R.id.s_course);
        vsEmail = view.findViewById(R.id.s_email);
        vsStCode = view.findViewById(R.id.s_code);
        vsSem = view.findViewById(R.id.s_sem);

        Student students = studentArrayList.get(i);

        vsName.setText(students.sname);
        vsCourse.setText(students.scourse);
        vsEmail.setText(students.semail);
        vsStCode.setText("Student Code: " + String.valueOf(students.scode));
        vsSem.setText("Semester: " + String.valueOf(students.ssem));

        return view;
    }
}
