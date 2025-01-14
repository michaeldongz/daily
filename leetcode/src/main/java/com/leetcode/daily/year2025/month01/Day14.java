package com.leetcode.daily.year2025.month01;

/**
 * @author: Michael
 * @date: 2025/1/14
 * @desc:
 */
public class Day14 {

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2, 11, 10, 1, 3}, 10)); // 3
        System.out.println(minOperations(new int[]{1, 1, 2, 4, 9}, 1)); // 0
        System.out.println(minOperations(new int[]{1, 1, 2, 4, 9}, 9)); // 4
    }

    // 枚举
    // 时间复杂度 O(n)
    // 空间复杂度：O(1)
    // 0ms 击败 100.00%
    // 41.92 MB 击败 30.88%
    public static int minOperations(int[] nums, int k) {
        int result = 0;

        for (int i : nums) {
            if (i < k) {
                result++;
            }
        }

        return result;
    }
}
