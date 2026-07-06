package com.leetcode.substring;

import java.util.HashMap;
import java.util.Map;

/// [最小覆盖子串](https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode76 {
    /**
     * 使用滑动窗口：不断移动右指针，找到符合要求的子串后，再不断收缩左指针；直到不再满足要求，就再移动右指针
     * 优化点：可以在判断是否满足子串要求这一点去优化，和`找到字符串中所有字母异位词`那道题一样，我们可以维护
     * 一个count 变量去记录满足是否子串的字母种类数
     */
    public String minWindow(String s, String t) {
        // 统计t中每个字符出现的次数
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int count = need.size(); // count 代表目前子串还未满足的字符种类数
        int L = 0, R = 0; // R指向满足条件子串的右侧，L指向满足条件子串的最左侧
        int sLen = s.length();
        int leftLast = -1, rightLast = sLen;

        // 不断右移右指针，除非 count == 0 满足条件
        while (R < sLen) {
            char c = s.charAt(R++);
            if (need.containsKey(c)) {
                // 如果某个字符恰好只差 1个，这种类型的字符已满足条件
                if (need.get(c) == 1) count--;
                need.put(c, need.get(c) - 1);
            }

            // 右移左指针，直到不满足条件
            while (count == 0) {
                if (R - L < rightLast - leftLast) {
                    leftLast = L;
                    rightLast = R;
                }
                char d = s.charAt(L++);
                if (need.containsKey(d)) {
                    need.put(d, need.get(d) + 1);
                    if (need.get(d) > 0) count++;
                }
            }
        }

        return leftLast == -1 ? "" : s.substring(leftLast, rightLast);
    }
}
