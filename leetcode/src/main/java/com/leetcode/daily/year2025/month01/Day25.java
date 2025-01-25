package com.leetcode.daily.year2025.month01;

/**
 * @author Michael
 * @date 2025/1/25 09:15
 * @desc
 */
public class Day25 {

    public static void main(String[] args) {

    }

    public long minimumMoney(int[][] transactions) {
        long totalLose = 0;
        int res = 0;
        for (int[] t : transactions) {
            int cost = t[0];
            int cashback = t[1];
            totalLose += Math.max(cost - cashback, 0);
            res = Math.max(res, Math.min(cost, cashback));
        }
        return totalLose + res;
    }

}
