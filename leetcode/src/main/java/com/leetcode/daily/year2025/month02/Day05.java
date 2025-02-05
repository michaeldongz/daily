package com.leetcode.daily.year2025.month02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Michael
 * @date: 2025/2/5
 * @desc:
 */
public class Day05 {

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2})); // [[],[1],[1,2],[1,2,2],[2],[2,2]]
        System.out.println(subsetsWithDup(new int[]{0}));   // [[],[0]]
    }

    static List<Integer> t = new ArrayList<Integer>();
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            boolean flag = true;
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
                        flag = false;
                        break;
                    }
                    t.add(nums[i]);
                }
            }
            if (flag) {
                ans.add(new ArrayList<Integer>(t));
            }
        }
        return ans;
    }
}
