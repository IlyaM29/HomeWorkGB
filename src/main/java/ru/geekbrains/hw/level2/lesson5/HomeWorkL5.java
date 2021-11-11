package ru.geekbrains.hw.level2.lesson5;

import java.util.Arrays;

public class HomeWorkL5 {
    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void secondMethod() throws InterruptedException {
        int size = 10_000_000;
        int half = size/2;
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();

        float[] leftHalf = new float[half];
        float[] rightHalf = new float[half];

        Thread thread1 = new Thread(() -> {
            System.arraycopy(arr, 0, leftHalf, 0, half);
            for (int i = 0; i < leftHalf.length; i++) {
                leftHalf[i] = (float) (leftHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(leftHalf, 0, arr, 0, half);
        });

        Thread thread2 = new Thread(() -> {
            System.arraycopy(arr, half, rightHalf, 0, half);
            for (int i = 0; i < rightHalf.length; i++) {
                rightHalf[i] = (float) (rightHalf[i] * Math.sin(0.2f + (i+half) / 5) * Math.cos(0.2f + (i+half) / 5) * Math.cos(0.4f + (i+half) / 2));
            }
            System.arraycopy(rightHalf, 0, arr, half, half);
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
