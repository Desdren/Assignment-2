package com.example.assignment_2dec_14;

public class Student {
    public int sid, scode, ssem;
    public String sname, scourse, semail;

    public Student(String sname, String scourse, String semail, int scode, int ssem) {
        this.sname = sname;
        this.scourse = scourse;
        this.semail = semail;
        this.scode = scode;
        this.ssem = ssem;
    }

    public int getScode() {
        return scode;
    }

    public int getSsem() {
        return ssem;
    }

    public String getSname() {
        return sname;
    }

    public String getScourse() {
        return scourse;
    }

    public String getSemail() {
        return semail;
    }
}
