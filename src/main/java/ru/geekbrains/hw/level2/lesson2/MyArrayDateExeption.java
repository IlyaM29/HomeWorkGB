package ru.geekbrains.hw.level2.lesson2;

public class MyArrayDateExeption extends Exception {

    public MyArrayDateExeption(int i, int j) {
        super("Невозможно суммировать Array[" + i + "][" + j + "]");
    }

}
