package com.leetcode.twopointers;

/// [盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;

        // 每次动高度比较小的那一个边界就行了
        while (left < right) {
            ans = Math.max(Math.min(height[left], height[right]) * (right - left), ans);
            if (height[left] <= height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return ans;
    }
}
