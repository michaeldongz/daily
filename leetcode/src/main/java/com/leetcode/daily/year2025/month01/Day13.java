package com.leetcode.daily.year2025.month01;

import java.util.Arrays;

/**
 * @author: Michael
 * @date: 2025/1/13
 * @desc:
 */
public class Day13 {

    public static void main(String[] args) {
        System.out.println(waysToSplitArray(new int[]{10,4,-8,7})); // 2
        System.out.println(waysToSplitArray(new int[]{2,3,1,0})); // 2
    }

    // 时间复杂度：O(n)。
    // 空间复杂度：O(1)。
    public static int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long left = 0, right = 0;
        for (int num : nums) {
            right += num;
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            left += nums[i];
            right -= nums[i];
            if (left >= right) {
                ans++;
            }
        }
        return ans;
    }
}
