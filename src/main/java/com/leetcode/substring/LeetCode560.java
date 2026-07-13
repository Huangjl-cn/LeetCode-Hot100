package com.leetcode.substring;

import java.util.HashMap;
import java.util.Map;

/// [和为 K 的子数组](https://leetcode.cn/problems/subarray-sum-equals-k/solutions/238572/he-wei-kde-zi-shu-zu-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode560 {
    /**
     * 使用前缀和 + 哈希表去优化
     * 使用前缀和问题发生了转化：寻找以 i 结尾和为k的子数组 -> 寻找以j∈[0,i]结尾，前缀和为pre[i] - k 的子数组
     * 哈希表优化：记录前缀和与其出现的次数，当需要寻找时某个前缀和时，直接取出现的次数就好了
     */
    public int subarraySum(int[] nums, int k) {
        int res = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // 不加 {0:1}，会漏掉所有"从数组开头，位置i结尾"的和为K的子数组。
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                res += map.get(pre - k);
            }
            // 更新前缀和pre 出现的次数
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }
}
