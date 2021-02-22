package com.leetcode;

import java.util.PriorityQueue;

public class TopNArray {

    public static void getTopN(int[] ints, int n) {
        PriorityQueue priorityQueue = new PriorityQueue<Integer>((x, y) -> y - x);
        for (int i = 0; i < ints.length; i++) {
            priorityQueue.add(ints[i]);
        }
        for (int j = 0; j < n; j++) {
            System.out.println(priorityQueue.poll());
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 3, 4, 6, 9, 2, 7, 8};
        getTopN(arr, 3);
    }
}
