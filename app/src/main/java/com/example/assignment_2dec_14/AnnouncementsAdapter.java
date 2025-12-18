package com.example.assignment_2dec_14;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AnnouncementsAdapter extends BaseAdapter {
    final Context context;
    final ArrayList<Announcements> announcementsArrayList;

    public AnnouncementsAdapter(Context context, ArrayList<Announcements> announcementsArrayList) {
        this.context = context;
        this.announcementsArrayList = announcementsArrayList;
    }

    @Override
    public int getCount() {
        return announcementsArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return announcementsArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.announcement_item, viewGroup, false);
        }
        TextView tvAnnTitle, tvAnnData;

        tvAnnTitle = view.findViewById(R.id.ann_title);
        tvAnnData = view.findViewById(R.id.ann_data);

        Announcements announcements = announcementsArrayList.get(i);

        tvAnnTitle.setText(announcements.title);
        tvAnnData.setText(announcements.details);

        return view;
    }
}
