package ru.geekbrains.hw.level2.lesson3;

import java.util.TreeSet;

public class Phonebook {
    private final TreeSet<Contact> phb = new TreeSet<>();

    public void add(Contact contact) {
        phb.add(contact);
    }

//    public void get(String surname) {
//        for (int i = 0; i < phb.size(); i++) {
//
//        }
//    }
}
