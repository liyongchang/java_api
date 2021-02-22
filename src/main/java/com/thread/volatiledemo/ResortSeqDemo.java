package com.thread.volatiledemo;

public class ResortSeqDemo {
    int a = 0;
    boolean flag = false;

    public void m1() {
        a = 1;
        flag = true;
    }

    public void m2() {
        if (flag) {
            a = a + 5;
            System.out.println(a);
        }
    }
}
