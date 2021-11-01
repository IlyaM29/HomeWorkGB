package ru.geekbrains.hw.level2.lesson1;

public class Human implements Member {
    @Override
    public void run() {
        System.out.println("Человек пробежал");
    }
    @Override
    public void jump() {
        System.out.println("Человек прыгнул");
    }
}
