package ru.geekbrains.hw.level2.lesson3;

public class Contact implements Comparable<Contact> {
    private final String surname;
    private final int number;

    public Contact(String surname, int number) {
        this.surname = surname;
        this.number = number;
    }

    @Override
    public int compareTo(Contact o) {
        if (this.surname.compareTo(o.surname) > 0) {
            return 1;
        } else if (this.surname.compareTo(o.surname) < 0) {
            return -1;
        }
        if (this.number > o.number) {
            return 1;
        } else if (this.number < o.number) {
            return -1;
        }
        return 0;
    }
}
