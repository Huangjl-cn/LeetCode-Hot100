package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/// [力扣题解](https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/227999/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode3 {
    /**
     * 优化思路：因为只包含英文字母、数字、符号和空格组成，可以直接用数组来替代Map
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0, res = 0;
        // 使用Map去记录字符和其出现的位置
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                // 因为没有清理Map的索引，所以如果小于left 的要忽略
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
