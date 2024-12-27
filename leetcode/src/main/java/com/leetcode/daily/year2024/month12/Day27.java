package com.leetcode.daily.year2024.month12;

import java.util.*;

/**
 * @author: Michael
 * @date: 2024/12/27
 * @desc:
 */
public class Day27 {

    public static void main(String[] args) {
        int[] ints = occurrencesOfElement(new int[]{1, 3, 1, 7}, new int[]{1, 3, 2, 4}, 1);
        System.out.println(Arrays.toString(ints));
        int[] ints1 = occurrencesOfElement(new int[]{1, 2, 3}, new int[]{10}, 5);
        System.out.println(Arrays.toString(ints1));
    }

    // 官方答案
    // 时间复杂度：O(n+q)，其中 n 表示给定数组 nums 的长度， q 表示给定的查询数组 queries 的长度。只需遍历数组 nums 与 queries 一次即可。
    // 空间复杂度：O(n)，其中 n 表示给定数组 nums 的长度。记录 x 出现的小标，需要的空间最多为 O(n)。
    // 执行用时分布  6ms   击败61.40%
    // 消耗内存分布  63.49MB  击败45.33%
    public static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                indices.add(i);
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (indices.size() < queries[i]) {
                res[i] = -1;
            } else {
                res[i] = indices.get(queries[i] - 1);
            }
        }
        return res;
    }

    // 个人方案
    // 时间复杂度O（N） + O(Q)
    // 执行用时分布  19ms   击败19.30%
    // 消耗内存分布  61.10MB  击败94.00%
    public static int[] occurrencesOfElement1(int[] nums, int[] queries, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == x){
                map.put(count, i);
                count ++ ;
            }
        }

        int[] ans = new int[queries.length];
        for (int j = 0 ; j < queries.length ; j++){
            ans[j] = map.getOrDefault(queries[j], -1);
        }

        return ans;
    }
}
