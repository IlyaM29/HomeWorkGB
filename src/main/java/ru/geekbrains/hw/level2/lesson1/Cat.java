package ru.geekbrains.hw.level2.lesson1;

public class Cat implements Member {
    @Override
    public void run() {
        System.out.println("Кот пробежал");
    }
    @Override
    public void jump() {
        System.out.println("Кот прыгнул");
    }
}
