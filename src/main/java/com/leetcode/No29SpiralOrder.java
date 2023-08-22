package com.leetcode;

public class No29SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
//模拟
        if (matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;//m行，n列
        int[] res = new int[m * n];
        int l = 0, r = n - 1, u = 0, d = m - 1, x = 0;
        while (true) {
            for (int i = l; i <= r; ++i) res[x++] = matrix[u][i];//从左到右
            if (++u > d) break;
            for (int i = u; i <= d; ++i) res[x++] = matrix[i][r];//从上到下
            if (--r < l) break;
            for (int i = r; i >= l; --i) res[x++] = matrix[d][i];//从右到左
            if (--d < u) break;
            for (int i = d; i >= u; --i) res[x++] = matrix[i][l];//从下到上
            if (++l > r) break;

        }
        return res;
    }
}
