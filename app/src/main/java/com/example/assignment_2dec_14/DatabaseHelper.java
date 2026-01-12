package com.example.assignment_2dec_14;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {
    Context context;
    public DatabaseHelper(Context context){
        super(context, "CollegeCompanion.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String makeStudentTableQuery = "CREATE TABLE " + "student " + "(" +
                "sid" + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                "sname" + " TEXT," +
                "scourse" + " TEXT(5)," +
                "semail" + " VARCHAR(255)," +
                "scode" + " INTEGER(10) UNIQUE," +
                "ssem" + " INTEGER(1))";
        sqLiteDatabase.execSQL(makeStudentTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + " student");
        onCreate(sqLiteDatabase);
        Toast.makeText(context, "Success", Toast.LENGTH_LONG).show();
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + "student", null);

        while (cursor.moveToNext()) {
            list.add(new Student(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getInt(5)
            ));
        }

        cursor.close();
        db.close();
        return list;
    }

    public void addStudent(String name, String course, String email, int code, int sem) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO student (sname, scourse, semail, scode, ssem) VALUES (?, ?, ?, ?, ?)",
                new Object[]{name, course, email, code, sem});
        db.close();
    }

    public void deleteStudent(int code) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM student WHERE scode = ?", new Object[]{code});
        db.close();
    }

    public Student getStudentByCode(int code) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM student WHERE scode = ?",
                new String[]{String.valueOf(code)});
        Student student = null;

        if (cursor.moveToFirst()) {
            student = new Student(
                    cursor.getString(1),   // sname
                    cursor.getString(2),   // scourse
                    cursor.getString(3),   // semail
                    cursor.getInt(4),      // scode
                    cursor.getInt(5)       // ssem
            );
        }

        cursor.close();
        db.close();
        return student;
    }

}
