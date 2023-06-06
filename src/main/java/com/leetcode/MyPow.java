package com.leetcode;

public class MyPow {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / (x * myPow(x, -n - 1));
        } else if (n % 2 == 1) {
            return x * myPow(x, n - 1);
        } else {
            return myPow(x * x, n / 2);
        }
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(2, 1));
    }
}
