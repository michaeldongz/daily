package com.leetcode.daily.year2024.month12;

import java.util.Arrays;

/**
 * @author: Michael
 * @date: 2024/12/26
 * @desc:
 */
public class Day25 {

    public static void main(String[] args) {
        minimumCost(3, 2, new int[]{1, 3}, new int[]{5});
        minimumCost(2, 2, new int[]{7}, new int[]{4});
    }

    public static int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int[] ndp = new int[n];
        for (int i = 1; i < n; ++i) {
            ndp[i] = ndp[i - 1] + verticalCut[i - 1];
        }
        int topLeft = ndp[0];
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int curTopLeft = topLeft;
                topLeft = ndp[j];
                if (j == 0) {
                    ndp[j] += horizontalCut[i - 1];
                    continue;
                }
                ndp[j] = ndp[j - 1] + ndp[j] - curTopLeft + Math.min(horizontalCut[i - 1], verticalCut[j - 1]);
            }
        }
        return ndp[n - 1];
    }

}
