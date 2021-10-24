package ru.geekbrains.hw.level1.lesson7;

public class Plate {
    private int food;
    public Plate(int food) {
        if (food < 0) {
            this.food = 0;
            return;
        }
        this.food = food;
    }
    public void decreaseFood(int n) {
        if (food < n) return;
        food -= n;
    }
    public void info() {
        System.out.println("В тарелке " + food + " еды");
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        if (food < 0) return;
        this.food += food;
        System.out.println("В тарелку добавили " + food + " еды");
    }
}
