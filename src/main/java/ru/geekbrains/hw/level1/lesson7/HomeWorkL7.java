package ru.geekbrains.hw.level1.lesson7;

public class HomeWorkL7 {
    public static void main(String[] args) {
        Plate plate = new Plate(60);
        plate.info();
        Cat[] cats = {
                new Cat("Мурзик", 20),
                new Cat("Барсик", 10),
                new Cat("Васька", 15),
                new Cat("Кузя", 25),
                new Cat("Бусик", 10)
        };
        for (Cat cat : cats) {
            cat.eat(plate);
            cat.info();
        }
        plate.info();
        plate.setFood(20);
        cats[3].eat(plate);
        cats[3].info();
    }
}
