package com.leetcode.daily.year2025.month01;

import java.util.List;
import java.util.Arrays;

/**
 * @author: Michael
 * @date: 2025/1/21
 * @desc:
 */
public class Day21 {

    public static void main(String[] args) {

    }

    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] f = new int[k + 1];
        Arrays.fill(f, -1);
        f[0] = 0;
        for (List<Integer> pile : piles) {
            for (int i = k; i > 0; --i) {
                int value = 0;
                for (int t = 1; t <= pile.size(); ++t) {
                    value += pile.get(t - 1);
                    if (i >= t && f[i - t] != -1) {
                        f[i] = Math.max(f[i], f[i - t] + value);
                    }
                }
            }
        }
        return f[k];
    }
}
