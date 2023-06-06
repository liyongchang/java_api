package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数 题解
 */
public class PrintNumbers17 {

    public int[] printNumber(int n) {
        int end = (int) (Math.pow(10, n) - 1);
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        PrintNumbers17 printNumbers17=new PrintNumbers17();
        System.out.println(printNumbers17.printNumbers(2));
    }


    public int[] printNumbers(int n){
        List<String> result = new ArrayList<>();
        //找出当前选择列表的所有子集（包括空集[]）
        getsubsets(n,new StringBuilder(),result);
        //删除空集
        result.remove(0);

        return result.stream().mapToInt(Integer::valueOf).sorted().toArray();
    }
    public void getsubsets(int n, StringBuilder trace, List<String> result){
        if(trace.length() > n) return ;
        result.add(trace.toString());
        //选择列表[0,1,2,3,4,5,6,7,8,9]
        for (int i = 0; i < 10; i++) {
            //剪枝操作：生成子集的时候不能以0为开头，如0,01,02... 012等等
            if(trace.length() == 0 && i == 0) continue;
            //做出选择
            trace.append(i);
            getsubsets(n,trace,result);
            //撤销选择
            trace.deleteCharAt(trace.length()-1);
        }
    }


}
