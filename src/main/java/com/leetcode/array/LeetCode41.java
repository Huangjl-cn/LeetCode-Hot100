package com.leetcode.array;

/// [缺失的第一个正数](https://leetcode.cn/problems/first-missing-positive/solutions/304743/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode41 {
    /**
     * 首先要知道答案的范围只会是：[1,N+1] ，其中N是数组的长度
     * 置换：
     * 1. 遍历数组，把当前位置i的值交换到正确的位置`nums[i] - 1`上（如果nums[i] ∈ [1,N]）
     * 2. 为了防死循环，如果nums[nums[i] - 1] == nums[i],跳过
     * 3. 再次遍历数组，如果某个位置i的值不等于i+1，即是答案
     */
    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        // 置换数组
        for (int i = 0; i < N; ++i) {
            while (1 <= nums[i] && nums[i] <= N && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < N; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return N + 1;
    }
}
