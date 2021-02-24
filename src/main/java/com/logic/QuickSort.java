package com.logic;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {

        System.out.println(122);


        List<Integer> items = new ArrayList<Integer>();
        items.add(1);
        items.add(122);
        items.add(14);
        items.add(61);
        items.add(99);
        items.add(36);
        System.out.println(items);
        System.out.println(items.size());
        sort(items);
    }

    public void quick_sort(int s[], int left, int right) {
        if (left < right) {
            int leftPoint = left;
            int rightPoint = right;
            int x = s[left];
            while (leftPoint < rightPoint) {
                while (leftPoint < rightPoint && s[rightPoint] >= x) {
                    rightPoint--;
                }
                if (leftPoint < rightPoint) {
                    s[leftPoint] = s[rightPoint];
                    leftPoint++;
                }
                while (leftPoint < rightPoint && s[rightPoint] <= x) {
                    leftPoint++;
                }
                if (leftPoint < rightPoint) {
                    s[leftPoint] = s[rightPoint];
                    rightPoint--;
                }
            }
            s[leftPoint] = x;
            quick_sort(s, left, leftPoint - 1);
            quick_sort(s, leftPoint + 1, rightPoint);
        }
    }

    public static void sort(List<Integer> items) {

        if (items.size() > 1) {
            List<Integer> smaller = new ArrayList<Integer>();
            List<Integer> same = new ArrayList<Integer>();
            List<Integer> larger = new ArrayList<Integer>();
            Integer chosenItem = items.get(items.size() / 2);
            System.out.println("chosenItem" + chosenItem);
            for (Integer i : items) {
                if (i < chosenItem) {
                    smaller.add(i);
                    System.out.println("smaller" + smaller);

                } else if (i > chosenItem) {
                    larger.add(i);
                    System.out.println("larger" + larger);

                } else {
                    same.add(i);
                    System.out.println("same" + same);
                }

            }
            sort(smaller);
            sort(larger);
            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
            System.out.println(items);

        }

    }


}
