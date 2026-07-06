package com.leetcode.hash;

import java.util.*;

/// [字母异位词分组](https://leetcode.cn/problems/group-anagrams/solutions/520469/zi-mu-yi-wei-ci-fen-zu-by-leetcode-solut-gyoc/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode49 {
    /**
     * 思路：将每个字符串排序，作为key，将字符串放入对应的key中
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 思路：统计每个字符串的字母出现的次数拼接为一个字符串作为key，将字符串放入对应的key中
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            // 记录每个字母出现的次数，将其作为key
            int[] counts = new int[26];
            for (int i = 0; i < s.length(); ++i) {
                counts[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            res.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
