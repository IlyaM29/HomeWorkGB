package ru.geekbrains.hw.level2.lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class HomeWorkL3 {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(
                "один", "два", "три", "четыре", "пять",
                "шесть", "семь", "восемь", "девять", "десять",
                "один", "два", "три", "четыре", "пять",
                "шесть", "семь", "восемь", "девять", "десять"
        ));
        Set<String> set = new LinkedHashSet<>(arrayList);
        System.out.println(set);
        count(arrayList);

        Phonebook phonebook = new Phonebook();
        phonebook.add(new Contact("Иванов", 123));
        phonebook.add(new Contact("Петров", 432));
        phonebook.add(new Contact("Иванов", 345));
        phonebook.add(new Contact("Иванов", 234));
        phonebook.add(new Contact("Петров", 321));

        //phonebook.get("Иванов");
        // не смог осуществить поиск через метод get()

    }

    public static void count(ArrayList arrayList) {
        Set<String> set = new LinkedHashSet<>(arrayList);
        for (String s : set) {
            int count = 0;
            for (Object arr : arrayList) {
                if (s == arr) count++;
            }
            System.out.println("Слово \"" + s + "\" встетилось " + count + " раз");
        }
    }
}
