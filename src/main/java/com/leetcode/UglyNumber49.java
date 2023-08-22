package com.leetcode;

public class UglyNumber49 {
    public static int uglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int x = 0, y = 0, z = 0, temp = 0;
        for(int i = 1; i < n; i++){
            System.out.println("i="+i);
            temp = Math.min(ugly[x]*2, Math.min(ugly[y]*3,ugly[z]*5));
            if(temp == ugly[x]*2) x++;
            if(temp == ugly[y]*3) y++;
            if(temp == ugly[z]*5) z++;
            ugly[i] = temp;
        }
        return ugly[n-1];
    }

    public static void main(String[] args) {
        System.out.println(uglyNumber(8));
    }
}
