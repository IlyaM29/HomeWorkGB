package ru.geekbrains.hw.level3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeWorkL1 {

    public static void main(String[] args) {
        System.out.println("Задание 1:");
        String[] strings = new String[] {"0", "1"};
        System.out.println(Arrays.toString(strings));
        replaceTwoElem(strings, 0, 1);
        System.out.println(Arrays.toString(strings));

        System.out.println("Задание 2:");
        ArrayList<String> arr = transformToArrayList(strings);
        System.out.println(arr);

        System.out.println("Задание 3:");
        Box<Apple> appleBox = Box.create();
        System.out.println(appleBox.getWeight());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        System.out.println(appleBox.getWeight());

        Box<Orange> orangeBox1 = Box.create();
        orangeBox1.addFruit(new Orange());
        orangeBox1.addFruit(new Orange());

        System.out.println(appleBox.compare(orangeBox1));

        Box<Orange> orangeBox2 = Box.create();
        orangeBox2.addFruit(new Orange());
        orangeBox1.empty(orangeBox2);

        System.out.println(orangeBox1.getWeight());
        System.out.println(orangeBox2.getWeight());

    }

    public static void replaceTwoElem(String[] strings, int elem1, int elem2) {
        String temp = strings[elem1];
        strings[elem1] = strings[elem2];
        strings[elem2] = temp;
    }

    public static ArrayList<String> transformToArrayList(String[] strings) {
        return new ArrayList<>(Arrays.asList(strings));
    }
}
