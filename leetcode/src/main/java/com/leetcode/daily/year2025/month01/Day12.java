package com.leetcode.daily.year2025.month01;

/**
 * @author Michael
 * @date 2025/1/12 09:54
 * @desc
 */
public class Day12 {

    public static void main(String[] args) {
        System.out.println(largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14})); // 4
        System.out.println(largestCombination(new int[]{8, 8})); // 2
    }

    // 计算从低到高第 k 个二进制位数值为 1 的元素个数
    public static int maxlen(int[] candidates, int k) {
        int res = 0;
        for (int num : candidates) {
            if ((num & (1 << k)) != 0) {
                res++;
            }
        }
        return res;
    }

    public static int largestCombination(int[] candidates) {
        int res = 0;
        for (int i = 0; i < 24; i++) {
            // 遍历二进制位
            res = Math.max(res, maxlen(candidates, i));
        }
        return res;
    }
}
