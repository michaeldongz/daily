package com.leetcode.daily.year2024.month12;

import java.util.Arrays;

/**
 * @author: Michael
 * @date: 2024/12/31
 * @desc:
 */
public class Day31 {

    public static void main(String[] args) {
        System.out.println(minimumCost(3, 2, new int[]{1, 3}, new int[]{5}));
        System.out.println(minimumCost(2, 2, new int[]{7}, new int[]{4}));
    }

    public static long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int h = 1, v = 1;
        long res = 0;
        int horizontalIndex = horizontalCut.length - 1, verticalIndex = verticalCut.length - 1;
        while (horizontalIndex >= 0 || verticalIndex >= 0) {
            if (verticalIndex < 0 || (horizontalIndex >= 0 && horizontalCut[horizontalIndex] > verticalCut[verticalIndex])) {
                res += horizontalCut[horizontalIndex--] * h;
                v++;
            } else {
                res += verticalCut[verticalIndex--] * v;
                h++;
            }
        }
        return res;
    }
}
