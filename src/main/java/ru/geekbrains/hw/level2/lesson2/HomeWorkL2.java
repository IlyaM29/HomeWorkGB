package ru.geekbrains.hw.level2.lesson2;

public class HomeWorkL2 {
    public static void main(String[] args) {
        String[][] mas = {
                {"2", "3", "4", "1"},
                {"3", "2", "5", "0"},
                {"6", "0", "2", "2"},
                {"4", "1", "3", "2"}
        };
        try {
            System.out.println(sumMas(mas));
        } catch (MyArraySizeException e) {
            System.out.println("Неверная размерность массива! " + e);
        } catch (MyArrayDateExeption e) {
            System.out.println(e);
        }
    }

    public static int sumMas(String[][] mas) throws  MyArraySizeException, MyArrayDateExeption {
        if (mas.length != 4 || mas[0].length != 4) {
            throw new MyArraySizeException();
        }
        int sum = 0;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (isNumber(mas[i][j])) {
                    sum += Integer.parseInt(mas[i][j]);
                } else {
                    throw new MyArrayDateExeption(i, j);
                }
            }
        }
        return sum;
    }

    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
