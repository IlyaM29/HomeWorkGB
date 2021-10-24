package ru.geekbrains.hw.level2.lesson1;

public class Robot implements Member {
    @Override
    public void run() {
        System.out.println("Робот пробежал");
    }
    @Override
    public void jump() {
        System.out.println("Робот прыгнул");
    }
}
