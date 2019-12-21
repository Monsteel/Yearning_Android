package appjam.hackathon.project.isaac.momentstory.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import appjam.hackathon.project.isaac.momentstory.R;
import appjam.hackathon.project.isaac.momentstory.view.Date;
import appjam.hackathon.project.isaac.momentstory.view.DateAdapter;


public class fragment2 extends Fragment {

    // View
    Spinner spinner;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_fragment2, container, false);
        
        recyclerView = rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);

        DateAdapter adapter = new DateAdapter();

        adapter.addItems(new Date("일", "1"));
        adapter.addItems(new Date("일", "2"));
        adapter.addItems(new Date("일", "3"));
        adapter.addItems(new Date("일", "4"));
        adapter.addItems(new Date("일", "5"));
        adapter.addItems(new Date("일", "6"));
        adapter.addItems(new Date("일", "7"));
        adapter.addItems(new Date("일", "8"));
        adapter.addItems(new Date("일", "9"));
        adapter.addItems(new Date("일", "10"));
        adapter.addItems(new Date("일", "11"));
        adapter.addItems(new Date("일", "12"));
        adapter.addItems(new Date("일", "13"));
        adapter.addItems(new Date("일", "14"));
        adapter.addItems(new Date("일", "15"));
        adapter.addItems(new Date("일", "16"));
        adapter.addItems(new Date("일", "17"));
        adapter.addItems(new Date("일", "18"));
        adapter.addItems(new Date("일", "19"));
        adapter.addItems(new Date("일", "20"));
        adapter.addItems(new Date("일", "21"));
        adapter.addItems(new Date("일", "22"));

        recyclerView.setAdapter(adapter);
        return rootView;
    }

}
