package com.logic;

public class RecursionTest {

    /*
     * 用递归编写程序时一定要牢记两点：
     * 1. 递归公式；
     * 2. 收敛条件（什么时候就不再继续递归）。
     * recursive function calling
     */
    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1))+ originStr.charAt(0);
    }


    public static void main(String[] args) {
        //String s1 = ("123456");
        //System.out.println(s1.substring(1));

        String s = reverse2("123456");
        System.out.println(s);
    }


    public static String reverse2(String a) {
        String s = "";
        new StringBuilder().reverse();
        for (int i = a.length() - 1; i > 0; i--) {
            s += a.charAt(i);
        }
        return s;
    }
}
