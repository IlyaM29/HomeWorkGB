package ru.geekbrains.hw.lesson2;

public class HomeWorkL2 {
    public static void main(String[] args) {
        // задание 1 - метод возвращает true, если сумма от 10 до 20 включительно
        System.out.println(within10and20(3, 4));

        // задание 2 - метод печатает положительное или отрицательное число
        isPositiveOrNegative(0);

        // задание 3 - метод возвращает true, если число отрицательное
        System.out.println(isNegative(-1));

        // задание 4 - метод печатает строку указанное число раз
        printWordNTimes("Hello World", 3);

        // задание 5* - возвращает true, если год високосный
        System.out.println(isLeapYear(1));
//        System.out.println(isLeapYear(4));
//        System.out.println(isLeapYear(8));
//        System.out.println(isLeapYear(100));
//        System.out.println(isLeapYear(300));
//        System.out.println(isLeapYear(400));
    }

    public static boolean within10and20(int a, int b)
    {
        int sum = a + b;
        if (sum > 9 && sum < 21) {
            return true;
        } else {
            return false;
        }
    }

    public static void isPositiveOrNegative(int a)
    {
        if (a < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    public static boolean isNegative(int a)
    {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printWordNTimes(String s, int a)
    {
        for (int i = 0; i < a; i++) {
            System.out.println(s);
        }
    }

    public static boolean isLeapYear(int year)
    {
        boolean result;
//        result = year % 4 == 0 ? true : false;
//        if (year % 100 == 0) result = false;
//        if (year % 400 == 0) result = true;
        result = (year % 4 == 0 && year % 100 != 0)||(year % 400 == 0);
        return result;
    }
}
