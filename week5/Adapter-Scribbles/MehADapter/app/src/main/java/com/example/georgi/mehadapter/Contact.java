package com.example.georgi.mehadapter;

/**
 * Created by georgi on 11/19/14.
 */
public class Contact {
    private final String name;

    private final String number;

    private final long id;

    public Contact(String name, String number, long id) {
        this.name = name;
        this.number = number;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public long getId() {
        return id;
    }
}
