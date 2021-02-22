package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MySkipList {
    private List<Node> heads;
    private Node head;
    private int max;
    private Random random;

    MySkipList() {
        this.max = 64;
        this.head = new Node(0, null, null);
        this.heads = new ArrayList<>(this.max);
        this.heads.add(head);
        this.random = new Random();
    }

    private class Node {
        int val;
        Node next, down;

        public Node(int val, Node next, Node down) {
            this.val = val;
            this.next = next;
            this.down = down;
        }
    }

    public boolean search(int target) {
        Node node = head;
        while (node != null) {
            if (node.next != null) {
                if (node.next.val < target) {
                    node = node.next;
                } else if (node.next.val > target) {
                    node = node.down;
                } else {
                    return true;
                }
            } else {
                node = node.down;
            }
        }
        return false;
    }


    public void add(int num) {
        Node node = head;
        do {
            if (node.next != null) {
                if (node.next.val <= num) {
                    node = node.next;
                } else if (node.down != null) {
                    node = node.down;
                } else {
                    break;
                }
            } else {
                if (node.down != null) {
                    node = node.down;
                } else {
                    break;
                }
            }
        } while (node != null);
        node.next = new Node(num, node.next, null);
        if (this.heads.size() < this.max && random.nextFloat() < 1f / Math.pow(2, this.heads.size())) {
            Node up = this.heads.get(this.heads.size() - 1);
            Node downHead = new Node(0, null, null);
            Node down = downHead;
            while (up != null) {
                up.down = down;
                if (up.next != null) {
                    down.next = new Node(up.next.val, null, null);
                }
                up = up.next;
                down = down.next;
            }
            this.heads.add(downHead);
        }
    }

    public static void main(String[] args) {
        MySkipList mySkipList = new MySkipList();
        for (int i = 0; i < 10; i++) {
            mySkipList.add(i);
        }

        for (int i = 0; i < mySkipList.heads.size(); i++) {
            System.out.println("批次" + i);
            Node node = mySkipList.heads.get(i);
            while (node != null) {
                System.out.println("批次" + i + "-----value" + node.val);
                node = node.next;
            }
        }
        System.out.println(mySkipList.search(19));

    }


}
