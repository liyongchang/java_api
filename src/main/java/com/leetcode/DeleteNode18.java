package com.leetcode;

import com.container.list.ListNode;

/**
 * 剑指 Offer 18. 删除链表的节点
 */
public class DeleteNode18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.getVal() == val) {
            return head.getNext();
        }
        ListNode pre = head;
        ListNode cur = head.getNext();
        while (cur != null && cur.getVal() != val) {
            pre = cur;
            cur = cur.getNext();
        }
        if (cur != null) {
            pre.setNext(cur.getNext());
        }
        return head;
    }

}
