package com.leetcode;
/**
 * 上海识装信息科技有限公司
 * <p>
 * 〈竞拍前置准备线程池〉
 *
 * @author yongchangli
 * @date 2023/6/614:37
 * @since 4.85
 */
public class HammingWeight15 {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }
}
