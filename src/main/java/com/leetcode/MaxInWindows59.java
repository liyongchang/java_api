package com.leetcode;

import java.util.LinkedList;

/*
 * 滑动窗口最大值
 */
public class MaxInWindows59 {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length <= 1) {
            return nums;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.add(i);
            if (queue.peekLast() - k == queue.peek()) {
                queue.poll();
            }
            if (i + 1 >= k && !queue.isEmpty()) {
                res[index++] = nums[queue.peek()];
            }
        }
        return res;
    }
}
