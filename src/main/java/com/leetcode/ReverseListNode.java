package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseListNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class Solution {
        public int[] reversePrint(ListNode head) {
            Stack<ListNode> stack = new Stack<ListNode>();
            ListNode temp = head;
            while (temp != null) {
                stack.push(temp);
                temp = temp.next;
            }
            int size = stack.size();
            int[] print = new int[size];
            for (int i = 0; i < size; i++) {
                print[i] = stack.pop().val;
            }
            return print;
        }

        List<Integer> list = new ArrayList<>();

        public int[] reversePrint2(ListNode head) {
            reverseHead(head);
            int[] res = new int[list.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.get(i);
            }
            return res;
        }

        private void reverseHead(ListNode head) {
            if (head == null) {
                return;
            }
            reverseHead(head.next);
            list.add(head.val);
        }

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        Solution solution = new Solution();
        int[] res = solution.reversePrint(listNode);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
