package com.logic;

public class BubbleSort {
    //12 4 1 6
    public static void BubbleSort(int[] arr) {
        int i = arr.length;
        while (i > 1) {
            int index = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    index = j;
                }
            }
            i = index;
        }
    }

    public static void BubbleSort2(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
