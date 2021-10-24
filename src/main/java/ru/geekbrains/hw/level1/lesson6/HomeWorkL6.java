package ru.geekbrains.hw.level1.lesson6;

import ru.geekbrains.hw.level1.lesson6.animals.Cat;
import ru.geekbrains.hw.level1.lesson6.animals.Dog;

public class HomeWorkL6 {
    public static void main(String[] args) {
        Cat barsik = new Cat("Барсик", 2);
        Dog sharik = new Dog("Шарик", 5);

        barsik.info();
        barsik.run(20);
        barsik.swim(10);
        sharik.info();
        sharik.run(600);
        sharik.swim(10);
        System.out.println(sharik.getCounter());
    }
}
