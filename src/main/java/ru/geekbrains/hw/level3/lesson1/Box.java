package ru.geekbrains.hw.level3.lesson1;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> fruits;

    private Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        if (fruits.size() != 0) return fruits.size() * fruits.get(0).getWeight();
        return 0.0f;
    }

    public <A extends Fruit> boolean compare(Box<A> otherBox) {
        return this.getWeight() == otherBox.getWeight();
    }

    public void empty (Box<T> intoBox) {
        for (T fruit : fruits) {
            intoBox.addFruit(fruit);
        }
        fruits.clear();
    }

    public static <A extends Fruit> Box<A> create() {
        return new Box<>();
    }
}
