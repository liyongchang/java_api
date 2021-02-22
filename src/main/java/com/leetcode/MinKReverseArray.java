package com.leetcode;

public class MinKReverseArray {

    public static void main(String[] args) {
        System.out.println(new MinKReverseArray().minArray(new int[]{1,3,7,79,0}));
    }

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[left]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
