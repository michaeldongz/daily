package com.leetcode.daily.year2025.month01;

/**
 * @author: Michael
 * @date: 2025/1/16
 * @desc:
 */
public class Day16 {

    public static void main(String[] args) {
        System.out.println(minimumSubarrayLength(new int[]{1, 2, 3}, 2));
        System.out.println(minimumSubarrayLength(new int[]{2, 1, 8}, 10));
        System.out.println(minimumSubarrayLength(new int[]{1, 2}, 1));
    }

    public static int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int value = 0;
            for (int j = i; j < n; j++) {
                value |= nums[j];
                if (value >= k) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
