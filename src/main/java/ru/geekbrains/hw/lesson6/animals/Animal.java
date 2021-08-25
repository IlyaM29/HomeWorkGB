package ru.geekbrains.hw.lesson6.animals;

public abstract class Animal {
    String name;
    int age;
    static int counter = 0;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
    }

    public void info() {
        System.out.println(name + ", " + age);
    }

    public String getCounter() {
        return "Всего животных " + counter;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}
