package com.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/// [螺旋矩阵](https://leetcode.cn/problems/spiral-matrix/solutions/2362055/54-luo-xuan-ju-zhen-mo-ni-qing-xi-tu-jie-juvi/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode54 {
    /**
     * 使用四个边界代替visited状态数组，将空间复杂度降到常数
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (true) {
            // 右
            for (int i = left; i <= right; ++i) {
                res.add(matrix[top][i]);
            }
            if (++top > bottom) return res;
            // 下
            for (int i = top; i <= bottom; ++i) {
                res.add(matrix[i][right]);
            }
            if (--right < left) return res;
            // 左
            for (int i = right; i >= left; --i) {
                res.add(matrix[bottom][i]);
            }
            if (--bottom < top) return res;
            // 上
            for (int i = bottom; i >= top; --i) {
                res.add(matrix[i][left]);
            }
            if (++left > right) return res;
        }
    }
}
