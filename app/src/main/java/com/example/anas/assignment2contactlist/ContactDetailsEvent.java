package com.example.anas.assignment2contactlist;

/**
 * Created by Fahad Shahid on 10/16/2017.
 */

public class ContactDetailsEvent {

    private String message;

    public ContactDetailsEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
