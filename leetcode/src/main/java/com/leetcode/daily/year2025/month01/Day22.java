package com.leetcode.daily.year2025.month01;

import java.util.Arrays;

/**
 * @author Michael
 * @date 2025/1/22 14:29
 * @desc
 */
public class Day22 {

    public static void main(String[] args) {

    }

    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int length = piles.length;
        int rounds = length / 3;
        int coins = 0;
        int index = length - 2;
        for (int i = 0; i < rounds; i++) {
            coins += piles[index];
            index -= 2;
        }
        return coins;
    }
}
