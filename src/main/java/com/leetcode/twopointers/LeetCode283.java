package com.leetcode.twopointers;

/// [移动零](https://leetcode.cn/problems/move-zeroes/solutions/489622/yi-dong-ling-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode283 {
    /**
     * 使用双指针：最开始都指向起始元素，他们分开的时机就是第一次遇到 0 元素的时候，这时 left 会留在原地，right 会继续向右直到遇到非 0 元素
     * 往后 left 和 right 左侧间全是 0 元素，left 左侧就是已经处理好的序列
     */
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                // 当left，right 指向同一个位置的时候不用交换
                if (left != right) {
                    nums[left] = nums[right];
                    nums[right] = 0;
                }
                left++;
            }
            right++;
        }
    }
}
