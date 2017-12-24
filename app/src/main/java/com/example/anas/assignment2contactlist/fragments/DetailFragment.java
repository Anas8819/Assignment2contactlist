package com.example.anas.assignment2contactlist.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anas.assignment2contactlist.ContactDetailsEvent;
import com.example.anas.assignment2contactlist.R;
import com.example.anas.assignment2contactlist.models.Contact;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    EventBus myEventBus;
    View view;
    Gson gson;
    TextView tvId;
    TextView tvName;
    TextView tvPhoneNo;
    TextView tvGender;


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_detail, container, false);
        gson = new Gson();
        EventBus.getDefault().register(this);
        view = inflater.inflate(R.layout.fragment_detail, container, false);
        tvId = (TextView) view.findViewById(R.id.tvId);
        tvName = (TextView) view.findViewById(R.id.tvName);
        tvPhoneNo = (TextView) view.findViewById(R.id.tvPhone);
        tvGender = (TextView) view.findViewById(R.id.tvGender);

        return view;
    }

    @Subscribe
    public void onEvent(ContactDetailsEvent event) {
        String str = event.getMessage();
        Contact contact = gson.fromJson(str, Contact.class);


        String id = "id = " + contact.getId().toString();
        String name = "Name = " + contact.getName().toString();
        String phone = "Phone = " + contact.getPhone().toString();
        String gender = "Gender = " + contact.getGender().toString();

        tvId.setText(id);
        tvName.setText(name);
        tvPhoneNo.setText(phone);
        tvGender.setText(gender);

    }

}
