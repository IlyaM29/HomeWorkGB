package ru.geekbrains.hw.lesson3;

import java.util.Arrays;

public class HomeWorkL3 {
    public static void main(String[] args) {
        invertArray(); // задание 1
        fillArray(); // задание 2
        changeArray(); // задание 3
        fillDiagonal(); // задание 4

        // задание 5
        int[] arr5 = createArray(4, 5);
        System.out.println(Arrays.toString(arr5));

        arrayMinMax(); //задание 6 *

        // задание 7 **
        int[] arr7 = {1, 1, 1, 3, 6};
        System.out.println(sumLeftAndRight(arr7));

        // задание 8 ***
        int[] arr8 = {1, 2, 3, 4, 5};
        offsetArray(arr8, -2);
    }

    public static void invertArray() // задание 1
    {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i]==0)? 1:0;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillArray() // задание 2
    {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i+1;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void changeArray() // задание 3
    {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillDiagonal() // задание 4
    {
        int k = 6; // размер квадратного массива
        int[][] arr = new int[k][k];
        for (int i = 0; i < k; i++) {
            arr[i][i] = 1;
            arr[i][k-i-1] = 1;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] createArray(int len, int initialValue) // задание 5
    {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    public static void arrayMinMax() //задание 6 *
    {
        int[] arr = {4, 3, 8, 16, 7, 2, 5, 6};
        int min = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }

    public static boolean sumLeftAndRight(int[] arr) // задание 7 **
    {
        int sum = 0, sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 == 0) {
            for (int i = 0; i < arr.length; i++) {
                sum2 += arr[i];
                if (sum2 == sum/2) return true;
                if (sum2 > sum/2) return false;
            }
        }
        return false;
    }

    public static void offsetArray(int[] arr, int n) {
        int temp, counter, counter2;
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                temp = arr[0];
                counter = 0;
                counter2 = arr.length - 1;
                for (int j = 1; j < arr.length; j++) {
                    arr[counter] = arr[counter2];
                    counter = counter2;
                    counter2--;
                }
                arr[1] = temp;
            }
        } else {
            n = -n;
            for (int i = 0; i < n; i++) {
                temp = arr[0];
                counter = 0;
                counter2 = 1;
                for (int j = 1; j < arr.length; j++) {
                    arr[counter] = arr[counter2];
                    counter++;
                    counter2++;
                }
                arr[arr.length - 1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
