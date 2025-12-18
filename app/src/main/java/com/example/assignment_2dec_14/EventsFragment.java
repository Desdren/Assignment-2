package com.example.assignment_2dec_14;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EventsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EventsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventsFragment newInstance(String param1, String param2) {
        EventsFragment fragment = new EventsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ListView eventsHolder;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events, container, false);

        eventsHolder = view.findViewById(R.id.eventsHolder);
        //dummy data
        ArrayList<Events> eventsList = new ArrayList<>();
        eventsList.add(new Events("Coding Hackathon", "Participate in the 24-hour coding challenge."));
        eventsList.add(new Events("Sports Day", "Annual sports competitions on campus grounds."));
        eventsList.add(new Events("Guest Lecture", "Lecture on Robotics by Dr. Smith at 3 PM."));
        eventsList.add(new Events("Music Concert", "Live music event in the auditorium at 7 PM."));
        eventsList.add(new Events("Art Exhibition", "Display of student artwork in the main hall."));
        eventsList.add(new Events("Career Fair", "Meet recruiters from top companies."));

        EventsAdapter adapter = new EventsAdapter(getContext(), eventsList);
        eventsHolder.setAdapter(adapter);

        return view;
    }
}