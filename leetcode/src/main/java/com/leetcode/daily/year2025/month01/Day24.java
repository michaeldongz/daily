package com.leetcode.daily.year2025.month01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael
 * @date 2025/1/24 09:12
 * @desc
 */
public class Day24 {

    public static void main(String[] args) {

    }

    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
    int[] prices;

    public int minimumCoins(int[] prices) {
        this.prices = prices;
        return dp(0);
    }

    public int dp(int index) {
        if (2 * index + 2 >= prices.length) {
            return prices[index];
        }
        if (!memo.containsKey(index)) {
            int minValue = Integer.MAX_VALUE;
            for (int i = index + 1; i <= 2 * index + 2; i++) {
                minValue = Math.min(minValue, dp(i));
            }
            memo.put(index, prices[index] + minValue);
        }
        return memo.get(index);
    }
}
