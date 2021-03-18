package com.leetcode.reverse;

public class ReverseKGroup {

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        ListNode newHead = reverse(head, tail);
        //这里本身头部节点反转后就要指向反转后的节点
        head.next = reverseKGroup(tail, k);
        return newHead;
    }
    //少量反转链表方法
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode cur = head;
        ListNode nextP = null;
        ListNode preP = null;
        while (cur != tail) {
            nextP = cur.next;//当前节点 当前下一个赋值给nextP
            cur.next = preP;//前一个赋值给preP

            preP = cur;//成为历史了
            cur = nextP;//当前节点后移动
        }
        return preP;
    }


}
