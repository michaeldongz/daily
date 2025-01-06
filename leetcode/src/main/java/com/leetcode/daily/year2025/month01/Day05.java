package com.leetcode.daily.year2025.month01;

import java.util.Arrays;

/**
 * @author Michael
 * @date 2025/1/5 19:46
 * @desc
 */
public class Day05 {

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(new int[]{0, 0, 1, 2, 1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        atm.deposit(new int[]{0, 1, 0, 1, 1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        System.out.println(Arrays.toString(atm.withdraw(550)));
    }

    public static class ATM {
        private long[] cnt;   // 每张钞票剩余数量
        private long[] value; // 每张钞票面额

        public ATM() {
            cnt = new long[]{0, 0, 0, 0, 0};
            value = new long[]{20, 50, 100, 200, 500};
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < 5; ++i) {
                cnt[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] res = new int[5];
            // 模拟尝试取出钞票的过程
            for (int i = 4; i >= 0; --i) {
                res[i] = (int) Math.min(cnt[i], amount / value[i]);
                amount -= res[i] * value[i];
            }
            if (amount > 0) {
                // 无法完成该操作
                return new int[]{-1};
            } else {
                // 可以完成该操作
                for (int i = 0; i < 5; ++i) {
                    cnt[i] -= res[i];
                }
                return res;
            }
        }
    }
}
