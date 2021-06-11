package com.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class StringTest {
    public static void main(String[] args) {
        String str2 = new String("str") + new String("01");
        str2.intern();
        String str1 = "str01";
        System.out.println(str2 == str1);
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> list1 = new ArrayList<ArrayList<Integer>>();
        if (root == null) return list1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list2 = new ArrayList<Integer>();//存储每一层节点
            for (int i = queue.size(); i > 0; i--) {//遍历当前层的节点 注意不能反着写
                TreeNode temp = queue.poll();
                if ((list1.size() + 1) % 2 != 0) //list1.size()+1：当前的层数，从1开始
                    list2.add(temp.val);//奇数层，头插
                else
                    list2.add(0, temp.val);//偶数层，尾插
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            list1.add(list2);

        }
        return list1;
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}
