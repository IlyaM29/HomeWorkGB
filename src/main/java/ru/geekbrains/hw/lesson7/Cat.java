package ru.geekbrains.hw.lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;
    public Cat(String name, int appetite) {
        this.name = name;
        if (appetite < 0) {
            this.appetite = 0;
            return;
        }
        this.appetite = appetite;
    }
    public void eat(Plate plate) {
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            satiety = true;
        }
    }
    public void info() {
        if (satiety) {
            System.out.println(name + " сытый");
            return;
        }
        System.out.println(name + " голодный!");
    }
}
