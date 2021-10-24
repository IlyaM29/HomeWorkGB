package ru.geekbrains.hw.level1.lesson5;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private int phoneNumber;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, int phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println(fullName + ", " + position + ", " + email + ", " + phoneNumber + ", " + salary + ", " + age);
    }

    public int getAge() {
        return age;
    }
}
