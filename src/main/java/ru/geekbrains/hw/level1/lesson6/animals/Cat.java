package ru.geekbrains.hw.level1.lesson6.animals;

public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println(name + " пробежал 200 метров и устал!");
            return;
        }
        System.out.println(name + " пробежал " + distance + " м.");
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не проплывет " + distance + " м., т.к. он не плавает!");
    }
}
