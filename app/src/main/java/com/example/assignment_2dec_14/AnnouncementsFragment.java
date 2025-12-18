package com.example.assignment_2dec_14;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnnouncementsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnnouncementsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnnouncementsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment announcements.
     */
    // TODO: Rename and change types and number of parameters
    public static AnnouncementsFragment newInstance(String param1, String param2) {
        AnnouncementsFragment fragment = new AnnouncementsFragment();
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

    ListView announcementHolder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_announcements, container, false);

        announcementHolder = view.findViewById(R.id.announcementHolder);
        //dummy data
        ArrayList<Announcements> announcementsList = new ArrayList<>();
        announcementsList.add(new Announcements("Semester Exams", "Exams start next week."));
        announcementsList.add(new Announcements("Library Update", "New books have arrived."));
        announcementsList.add(new Announcements("Guest Lecture", "AI lecture on Friday."));
        announcementsList.add(new Announcements("Festival Registration", "Campus festival registrations open."));

        AnnouncementsAdapter adapter = new AnnouncementsAdapter(getContext(), announcementsList);
        announcementHolder.setAdapter(adapter);

        return view;
    }
}