package com.logic;

public class BinarySearch2 {
    public static void main(String[] args) {
        // 需要查找的数字
        int targetNumb = 8;
        // 目标有序数组
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int middle = 0;
        int low = 0;
        int high = arr.length - 1;
        int isfind = 0;
        while (low <= high) {
            middle = (high + low) / 2;
            if (arr[middle] == targetNumb) {
                System.out.println(targetNumb + " 在数组中,下标值为: " + middle);
                isfind = 1;
                break;
            } else if (arr[middle] > targetNumb) {
                // 说明该数在low~middle之间
                high = middle - 1;
            } else {
                // 说明该数在middle~high之间
                low = middle + 1;
            }
        }
        if (isfind == 0) {
            System.out.println("数组不含 " + targetNumb);
        }
    }

    private static int recursiveFind(int[] arr,int start,int end,int searchKey){
        if (start <= end) {
            int middle =  (start+end)/2;
            if (searchKey == arr[middle]) {
                return middle;
            } else if (searchKey < arr[middle]) {
                return recursiveFind(arr, start, middle - 1, searchKey);
            } else {
                return recursiveFind(arr, middle + 1, end, searchKey);
            }
        } else {
            return -1;
        }
    }

}
