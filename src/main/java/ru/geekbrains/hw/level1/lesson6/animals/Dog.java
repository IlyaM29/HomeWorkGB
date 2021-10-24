package ru.geekbrains.hw.level1.lesson6.animals;

public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println(name + " пробежал 500 метров и устал!");
            return;
        }
        System.out.println(name + " пробежал " + distance + " м.");
    }

    @Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println(name + " проплыл 10 метров и устал!");
            return;
        }
        System.out.println(name + " проплыл " + distance + " м.");
    }
}
