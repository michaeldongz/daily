package com.leetcode.daily.year2025.month01;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Michael
 * @date 2025/1/29 09:14
 * @desc
 */
public class Day29 {

    public static void main(String[] args) {

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
