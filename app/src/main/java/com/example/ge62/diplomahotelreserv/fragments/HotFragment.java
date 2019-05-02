package com.example.ge62.diplomahotelreserv.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ge62.diplomahotelreserv.R;
import com.example.ge62.diplomahotelreserv.models.HotDealHotels;

import java.util.ArrayList;
import java.util.List;

public class HotFragment extends Fragment {


    private List<HotDealHotels> hotelsList = new ArrayList<>();
    private RecyclerView recyclerView;
//    private HotDealsEditListAdapter hotDealsListAdapter;
    HotDealHotels hottel;

    private Toolbar toolbar;
    private TabLayout tabLayout;


    public HotFragment(){

    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hot, container, false);
    }












}
