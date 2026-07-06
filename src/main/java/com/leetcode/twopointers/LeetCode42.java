package com.leetcode.twopointers;

/// [接雨水](https://leetcode.cn/problems/trapping-rain-water/solutions/692342/jie-yu-shui-by-leetcode-solution-tuvc/?envType=study-plan-v2&envId=top-100-liked)
/// #### 基本思路：
/// 每个位置 x 能接的雨水量由左右最大高度的最小值决定<br>
/// 代码上来看就是：`maxHeight[x] = Math.min(leftMax[x] ,rightMax[x]) - height[x]`
/// #### 优化思路：
/// 使用双指针，简单地描述逻辑就是：
/// ```
/// 可以简单地去想象推理一下这个逻辑：如果 height[left] <= height[right] 那么移动左指针，否则移动右指针
/// 按照这个逻辑来，会发现：
/// 1. 固定的那个指针当前指向的高度就是 左/右 的最大高度：leftMax/rightMax
/// 2. 移动的那个指针那边的最大值一定是不大于固定指针那边的最大值的
/// （数学上的证明比较绕，就去想象一下那个逻辑的演变过程就不难发现）
///
/// 所以就有结论：
/// 如果 height[left] <= height[right] ，那么一定有 leftMax <= rightMax
///
/// 于是，当 height[left] <= height[right] ，也代表着 leftMax <= rightMax，就可以计算left 位置的雨水量了
/// 因为rightMax 一定不会小于leftMax ，所以瓶颈是在leftMax ，雨水量 = leftMax - height[left]
///
/// 完罢继续移动左指针，直到 height[left] > height[right] ，此时height[left] 就是 leftMax 并且大于 rightMax，
/// 所以瓶颈就变为了 rightMax，这时就要移动右指针了
/// ```
public class LeetCode42 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while (left < right) {
            // 此时rightMax >= leftMax ,瓶颈是leftMax ，所以移动左指针,直到 leftMax > rightMax
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
