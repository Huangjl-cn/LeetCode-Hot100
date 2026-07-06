package com.leetcode.substring;

import java.util.ArrayDeque;
import java.util.Deque;

/// [滑动窗口最大值](https://leetcode.cn/problems/sliding-window-maximum/solutions/543426/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/?envType=study-plan-v2&envId=top-100-liked)
/// 也可以使用PriorityQueue 实现，但不够优雅，可以学习一下每次取最大/小值用大/小顶堆这个数据结构
public class LeetCode239 {
    /**
     * 使用单调队列去实现，队列满足两个特性：
     * 1. 队列里的存放的是nums 数组的下标，保持递增
     * 2. 队列里元素在nums 数组里的取值保持递减
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        // 声明双端队列，使用ArrayDeque，底层是环形数组，性能好
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < k; ++i) {
            // 如果 x 的下标比 y 大，而且nums[x] >= nums[y]，那么完全可以从队列里移除y
            // 因为 x 只会比 y 待在窗口里的时间长，而且在的时间也只有可能取 x，不可能去y
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        res[0] = nums[dq.peekFirst()];

        for (int i = k; i < nums.length; ++i) {
            // 同样地，去除不可能取到的元素，保持递减
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);

            // 每次取值前，先检查对首的元素是否已经移出去了
            while (dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            res[i - k + 1] = nums[dq.peekFirst()];
        }
        return res;
    }
}
