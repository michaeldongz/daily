package com.leetcode.daily.year2025.month02;

/**
 * @author: Michael
 * @date: 2025/2/20
 * @desc:
 */
public class Day20 {

    public static void main(String[] args) {
        System.out.println(evenOddBit(50)); // [1,1]
        System.out.println(evenOddBit(2)); // [0,1]
    }

    public static int[] evenOddBit(int n) {
        int[] res = new int[2];
        int i = 0;
        while (n > 0) {
            res[i] += n & 1;
            n >>= 1;
            i ^= 1;
        }
        return res;
    }

}
