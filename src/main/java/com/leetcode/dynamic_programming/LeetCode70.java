package com.leetcode.dynamic_programming;

/// [力扣题解](https://leetcode.cn/problems/climbing-stairs/solutions/286022/pa-lou-ti-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode70 {
    public int climbStairs(int n) {
        int temp = 0 ,n1 = 0 , n2 = 1;

        for (int i = 1; i <= n; i++) {
            temp = n1;
            n1 = n2;
            n2 = temp + n1;
        }
        return n2;
    }
}
