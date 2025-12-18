package com.example.assignment_2dec_14;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EventsAdapter extends BaseAdapter {
    final Context context;
    final ArrayList<Events> eventsArrayList;

    public EventsAdapter(Context context, ArrayList<Events> eventsArrayList) {
        this.context = context;
        this.eventsArrayList = eventsArrayList;
    }

    @Override
    public int getCount() {
        return eventsArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return eventsArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.event_item, viewGroup, false);
        }

        TextView tvEventTitle, tvEventDetails;

        tvEventTitle = view.findViewById(R.id.ev_title);
        tvEventDetails = view.findViewById(R.id.ev_data);

        Events events = eventsArrayList.get(i);

        tvEventTitle.setText(events.title);
        tvEventDetails.setText(events.details);

        return view;
    }
}
