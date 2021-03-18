package com.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        /*System.out.println(122);
        List<Integer> items = new ArrayList<Integer>();
        items.add(1);
        items.add(122);
        items.add(14);
        items.add(61);
        items.add(99);
        items.add(36);
        System.out.println(items);
        System.out.println(items.size());
        sort(items);*/
        System.out.println("quick_sort--------------");
        int[] s = new int[]{1, 3, 0, 7, 5};
        new QuickSort().quick_sort(s, 0, s.length - 1);
        System.out.println(Arrays.toString(s));
    }


    public void quick_sort(int s[], int left, int right) {
        if (left < right) {
            int leftPoint = left;
            int rightPoint = right;
            int pivot = s[left];//!!!!!!!!!
            while (leftPoint < rightPoint) {
                while (leftPoint < rightPoint && s[rightPoint] > pivot) {
                    rightPoint--;
                }

                while (leftPoint < rightPoint && s[leftPoint] <= pivot) {
                    leftPoint++;
                }
                //两个条件都满足才交换
                if (leftPoint < rightPoint) {
                    int temp = s[leftPoint];
                    s[leftPoint] = s[rightPoint];
                    s[rightPoint] = temp;
                }
            }
            //快速排序为何这么快，因为一趟排序后元素都在他应该在的位置！
            s[left] = s[leftPoint];//!!!!!!!!!
            s[leftPoint] = pivot;
            quick_sort(s, left, rightPoint - 1);
            quick_sort(s, rightPoint + 1, right);
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
