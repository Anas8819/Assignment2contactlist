package com.example.anas.assignment2contactlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

public class ContactDetails extends AppCompatActivity {
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    String infoString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);


        Gson  gson = new Gson();
        String target = getIntent().getStringExtra("Details");
        ContactDetailsEvent contactDetailsEvent = new ContactDetailsEvent(target);

        EventBus.getDefault().post(contactDetailsEvent);

    }
}
