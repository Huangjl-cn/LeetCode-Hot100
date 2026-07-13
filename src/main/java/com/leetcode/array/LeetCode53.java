package com.leetcode.array;

/// [最大子序和](https://leetcode.cn/problems/maximum-subarray/solutions/228009/zui-da-zi-xu-he-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode53 {
    /**
     * 思路和`和为K的子数组`那道题有点像，还更简单一点，不断比较以 i 结尾的子数组就好了。也就是动态规划，还有个分治的解法，有时间可以学习一下
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int pre = 0; //代表以 i- 1 结尾的子数组的最大值
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(pre, max);
        }
        return max;
    }
}
