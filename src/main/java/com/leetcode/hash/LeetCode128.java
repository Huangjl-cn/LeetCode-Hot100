package com.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/// [最长连续序列](https://leetcode.cn/problems/longest-consecutive-sequence/solutions/276931/zui-chang-lian-xu-xu-lie-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode128 {
    /**
     * 最关键的就是怎么取到一个连续数列的开头：判断 x 是否存在 x-1 这个数，如果存在就不是一个连续数列的开头
     */
    public int longestConsecutive(int[] nums) {
        // 创建快速验证是否存在的哈希表
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        // 注意这里遍历的数组是去重后的数组，不是原数组
        for (int num : set) {
            // 寻找起点，如果一个数的前一个数存在，跳过（因为不可能是最优解）
            if (set.contains(num - 1)) {
                continue;
            }
            // 统计该起点的最长序列长度
            int count = 1;
            while (set.contains(num + 1)) {
                count++;
                num++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
