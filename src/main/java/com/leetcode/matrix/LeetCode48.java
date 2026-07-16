package com.leetcode.matrix;

/// [旋转图像](https://leetcode.cn/problems/rotate-image/solutions/526980/xuan-zhuan-tu-xiang-by-leetcode-solution-vu3m/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode48 {
    /**
     * 翻转方法：先水平翻转再沿主对角线翻转就行了
     * <p>
     * 这里使用原地旋转的方法，顺时针翻转90度，下标的变化是：i，j -> j ,n-i-1,四次变换一次循环
     * 第一次：i， j -> j,n-i-1
     * 第二次：j，n-i-1 -> n-i-1, n-j-1
     * 第三次：n-i-1,n-j-1 -> n-j-1, i
     * 第四次：n-j-1, i -> i, j
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 当n为偶数是，需要旋转的元素有 n*n/4 个 -> (n/2)*(n/2)
        // 当n为奇数时，中间的元素不需要旋转，旋转的元素有(n*n - 1)/4个 -> ((n+1)/2) * ((n-1)/2)
        // n为偶数时，n/2 = (n+1)/2；n为奇数时，n/2 = (n-1)/2
        // 所以为了兼容两种情况，循环条件选择：(n+1)/2 和 n/2
        for (int i = 0; i < (n + 1) / 2; ++i) {
            for (int j = 0; j < n / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
