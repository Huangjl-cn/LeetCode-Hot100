package com.leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/// [力扣题解](https://leetcode.cn/problems/3sum/solutions/284681/san-shu-zhi-he-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked)
/// ### 优化思路:
/// #### 1.在第一个元素>0时，提前停止
/// ```java
/// //调前剪枝
/// if (nums[first] > 0) {
///     return res; // 或者 break; 因为后面不可能有解了
/// }
/// ```
/// #### 2.增加更积极的剪枝条件
///
/// - 最小和剪枝：如果当前固定的数加上它后面两个最小的数（即 `nums[first+1]`和 `nums[first+2]`）之和已经大于0，那么对于这个 first以及之后更大的 first，三数之和都只会更大，因此可以提前终止整个循环。
/// - 最大和剪枝：如果当前固定的数加上数组末尾两个最大的数（即 `nums[n-2]`和 `nums[n-1]`）之和仍然小于0，说明这个数太小了，即使配上最大的两个数也无法达到0，应该跳过当前 first，继续检查下一个更大的数。
///
/// ```java
/// // 优化1: 最小和剪枝
/// if (first < length - 2 && nums[first] + nums[first+1] + nums[first+2] > 0) {
///     break;
/// }
/// // 优化2: 最大和剪枝
/// if (first < length - 2 && nums[first] + nums[length-2] + nums[length-1] < 0) {
///     continue;
/// }
/// ```
///
public class LeetCode15 {
    /**
     * 排序后，寻找 x + y + z = 0。在固定好 x 后 ，若 y 变大 ，z 的取值肯定是变小，所以可以发现 y、z 满足条件的取值范围是不断相向靠近的
     * 因此可以使用双指针法，一个指针指向 y，一个指针指向 z，然后根据情况向中间移动指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // 对数组进行排序
        Arrays.sort(nums);

        // 遍历 x
        for (int i = 0; i < nums.length; i++) {
            // 跳过重复的值
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int x = nums[i];

            // 定义双指针
            int k = nums.length - 1;
            // 遍历 y
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int y = nums[j];
                // 移动 k，选择满足条件的三元组
                while (j < k && x + y + nums[k] > 0) {
                    k--;
                }
                // 如果 j >= k，说明已经没有满足条件的三元组了
                if (j >= k) {
                    break;
                }
                if (x + y + nums[k] == 0) {
                    res.add(Arrays.asList(x, y, nums[k]));
                }
            }
        }
        return res;
    }
}
