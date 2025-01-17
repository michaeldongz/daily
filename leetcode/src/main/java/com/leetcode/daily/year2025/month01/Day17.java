package com.leetcode.daily.year2025.month01;

/**
 * @author: Michael
 * @date: 2025/1/17
 * @desc:
 */
public class Day17 {

    public static void main(String[] args) {
        System.out.println(minimumSubarrayLength(new int[]{1,2,3}, 2)); // 1
        System.out.println(minimumSubarrayLength(new int[]{2,1,8}, 10)); // 3
        System.out.println(minimumSubarrayLength(new int[]{1,2}, 0)); // 1
    }

    public static int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int[] bits = new int[30];
        int res = Integer.MAX_VALUE;
        for (int left = 0, right = 0; right < n; right++) {
            for (int i = 0; i < 30; i++) {
                bits[i] += (nums[right] >> i) & 1;
            }
            while (left <= right && calc(bits) >= k) {
                res = Math.min(res, right - left + 1);
                for (int i = 0; i < 30; i++) {
                    bits[i] -= (nums[left] >> i) & 1;
                }
                left++;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static int calc(int[] bits) {
        int ans = 0;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] > 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
