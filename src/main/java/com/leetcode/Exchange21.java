package com.leetcode;

import java.util.Arrays;

public class Exchange21 {

    /**
     * 如果遇到奇数就放到数组前面的位置，遍历结束工作也就完成了。其实这种解法也叫快慢指针，快指针为i，慢指针为j。
     *
     * @param arr
     * @return
     */
    public int[] exchange(int[] arr) {
        if (arr == null || arr.length == 1) {
            return arr;
        }
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] % 2 != 0) {
                //i 遍历到奇数，交换arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                //j++把第二个奇数位置腾出来
                arr[j++] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }


    /**
     * 还有一种解法，双指针法，就是一个从头开始遍历，一个从尾开始遍历，一直到两个相遇。
     * 头指针找到偶数，尾指针找到奇数，就可以进行交换了。
     *
     * @param arr
     * @return
     */
    public int[] exchange2(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            while (start < end && arr[start] % 2 == 1) {
                start++;
            }
            while (start < end && arr[end] % 2 == 0) {
                end--;
            }
            int temp = arr[start];
            arr[start] = arr[end];
            //j++把第二个奇数位置腾出来
            arr[end] = temp;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void main(String[] args) {
        Exchange21 exchange21 = new Exchange21();
        System.out.println(exchange21.exchange2(new int[]{2, 1, 3, 4}));
    }
}
