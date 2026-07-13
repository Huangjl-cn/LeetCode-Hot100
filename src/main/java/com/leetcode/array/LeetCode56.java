package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/// [合并区间](https://leetcode.cn/problems/merge-intervals/solutions/203562/he-bing-qu-jian-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode56 {
    /**
     * 先按照左区间排序，后面的合并就简单了
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 按照左区间排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            // 如果未处理的区间和merged 的最后一个区间有交集，则合并
            if (!merged.isEmpty() && merged.getLast()[1] >= interval[0]) {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
                continue;
            }
            merged.add(interval);
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
