package com.rawia.whatsup;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CallsFragment extends Fragment {
View sView;
RecyclerView sRecyclerView;
ArrayList<CallCatagory> sArrayList;
SecAdapter sAdapter;
    public CallsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    sView = inflater.inflate(R.layout.fragment_calls, container, false);
        secInitViews();
        return sView;
    }

    private void secInitViews() {
        sRecyclerView = sView.findViewById(R.id.sec_rec);
        sArrayList = new ArrayList<>();
        CallCatagory m1 = new CallCatagory(R.drawable.car3 );
        CallCatagory m2 = new CallCatagory(R.drawable.bird4 );
        CallCatagory m3 = new CallCatagory(R.drawable.backyoga4 );
        CallCatagory m4 = new CallCatagory(R.drawable.car4 );
        CallCatagory m5 = new CallCatagory(R.drawable.profile );

        sArrayList.add(m1);
        sArrayList.add(m2);
        sArrayList.add(m3);
        sArrayList.add(m4);
        sArrayList.add(m5);
        sAdapter = new SecAdapter(sArrayList, getActivity());
        sRecyclerView.setAdapter(sAdapter);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        sRecyclerView.setLayoutManager(layoutManager1);

    }

}
