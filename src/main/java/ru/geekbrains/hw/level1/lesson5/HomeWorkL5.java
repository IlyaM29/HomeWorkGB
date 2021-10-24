package ru.geekbrains.hw.level1.lesson5;

public class HomeWorkL5 {
    public static void main(String[] args) {

        Employee[] employeeArray = {
                new Employee("Иванов Иван", "менеджер", "qwer@mail.ru", 12345, 52000, 30),
                new Employee("Петров Петр", "старший менеджер", "qwerty@mail.ru", 23456, 70000, 42),
                new Employee("Сидоров Сергей", "помощьник менеджера", "asdfg@mail.ru", 34567, 35000, 25),
                new Employee("Давыдов Игнат", "старший менеджер", "zxcvb@mail.ru", 54321, 72000, 47),
                new Employee("Смирнов Виталий", "менеджер", "gfdsa@mail.ru", 65432, 50000, 28)};

        for (int i = 0; i < employeeArray.length; i++) {
            if (employeeArray[i].getAge() >= 40) {
                employeeArray[i].info();
            }
        }
    }
}
