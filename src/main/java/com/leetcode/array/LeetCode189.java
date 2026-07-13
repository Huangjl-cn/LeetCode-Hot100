package com.leetcode.array;

/// [轮转数组](https://leetcode.cn/problems/rotate-array/solutions/551039/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/?envType=study-plan-v2&envId=top-100-liked)
/// 还有个有趣的方法：三次数组翻转
public class LeetCode189 {
    /**
     * 这里采用环状替换的方法，
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int count = gcd(n, k);
        k = k % n;
        for (int start = 0; start < count; ++start) {
            int current = start; // 当前下标位置
            int next; // 目标下标位置
            int temp; // 即将被覆盖的值的缓存
            int pre = nums[current]; // 将要写入的值
            do {
                // 更新下一个位置，缓存其值并覆盖
                next = (current + k) % n;
                temp = nums[next];
                nums[next] = pre;
                // 更新pre 和 current
                pre = temp;
                current = next;
            } while (current != start);
        }
    }

    // 求最大公约数
    int gcd(int n, int k) {
        return k > 0 ? gcd(k, n % k) : n;
    }
}
