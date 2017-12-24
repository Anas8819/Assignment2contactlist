package com.example.anas.assignment2contactlist.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.anas.assignment2contactlist.R;
import com.example.anas.assignment2contactlist.adapters.ContactAdapter;
import com.example.anas.assignment2contactlist.models.Contact;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Contact_Fragment extends Fragment {


    RecyclerView recyclerView;
    View view;

    public Contact_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contact, container, false);

        // Custom Data Source

        ArrayList<Contact> arrayList = new ArrayList<Contact>();
        for (int i = 1; i < 1000; i++) {
            arrayList.add(new Contact(i , "Anas "+i, "1234" + i, "Male"));

        }
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);

        ContactAdapter contactAdapter = new ContactAdapter(getActivity(),arrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(contactAdapter);

        return view;
    }
}
