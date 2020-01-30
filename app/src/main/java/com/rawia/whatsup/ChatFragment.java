package com.rawia.whatsup;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {
    View mview;
    RecyclerView recyclerView;
    ArrayList<ImfCatagory> arrayList;
    Adapter adapter;


    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mview = inflater.inflate(R.layout.fragment_chat, container, false);

        initViews();
        return mview;
    }
    private void initViews() {
        recyclerView = mview.findViewById(R.id.item_rv);
        arrayList = new ArrayList<>();
        ImfCatagory m1 = new ImfCatagory("Rania" , R.drawable.profile );
        ImfCatagory m2 = new ImfCatagory("Shimaa" , R.drawable.backyoga4 );
        ImfCatagory m3 = new ImfCatagory("Mona" , R.drawable.bird4 );
        ImfCatagory m4 = new ImfCatagory("Walaa" , R.drawable.car4 );
        ImfCatagory m5 = new ImfCatagory("Somia" , R.drawable.car3 );

        arrayList.add(m1);
        arrayList.add(m2);
        arrayList.add(m3);
        arrayList.add(m4);
        arrayList.add(m5);
        adapter = new Adapter(arrayList, getActivity());
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

    }
    }

