package com.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/// [找到字符串中所有字母异位词](https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/1123971/zhao-dao-zi-fu-chuan-zhong-suo-you-zi-mu-xzin/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> res = new ArrayList<>();
        if (sLen < pLen) {
            return res;
        }

        // 统计初始窗口和p的中，字母出现次数的差
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }

        //初始化diff值
        int diff = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++diff;
            }
        }

        if (diff == 0) {
            res.add(0);
        }

        // 开始滑动窗口
        for (int i = 0; i < sLen - pLen; ++i) {
            // 移出左边的值
            if (count[s.charAt(i) - 'a'] == 1) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                --diff;
            } else if (count[s.charAt(i) - 'a'] == 0) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                ++diff;
            }
            --count[s.charAt(i) - 'a'];

            // 移进右边的值
            if (count[s.charAt(i + pLen) - 'a'] == -1) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                --diff;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                ++diff;
            }
            ++count[s.charAt(i + pLen) - 'a'];

            if (diff == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
