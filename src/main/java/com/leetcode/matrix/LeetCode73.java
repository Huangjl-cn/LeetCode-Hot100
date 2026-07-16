package com.leetcode.matrix;

/// [矩阵置零](https://leetcode.cn/problems/set-matrix-zeroes/solutions/669901/ju-zhen-zhi-ling-by-leetcode-solution-9ll7/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode73 {
    /**
     * 使用矩阵的第一行、第一列去做标记数组，一行一列的那个格子表示第一行的状态，另起一个变量表示第一列的状态
     */
    public void setZeroes(int[][] matrix) {
        // 初始化flagCol0、和matrix[0][0]
        boolean flagCol0 = false;
        int rowLength = matrix.length, colLength = matrix[0].length;
        // 这里有个小细节，就是先初始化flagCol0
        // 不然初始化matrix[0][0]后（本身不为0，同行有0的情况），会影响flagCol0的判断
        for (int i = 0; i < rowLength; ++i) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
                break;
            }
        }
        for (int i = 0; i < colLength; ++i) {
            if (matrix[0][i] == 0) {
                matrix[0][0] = 0;
                break;
            }
        }
        // 遍历数组，标记状态
        for (int i = 1; i < rowLength; ++i) {
            for (int j = 1; j < colLength; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        // 根据标志位更新数组
        for (int i = 1; i < rowLength; ++i) {
            for (int j = 1; j < colLength; ++j) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int i = 0; i < colLength; ++i) {
                matrix[0][i] = 0;
            }
        }
        if (flagCol0) {
            for (int i = 0; i < rowLength; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}
