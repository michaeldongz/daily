package com.leetcode.daily.year2025.month01;

/**
 * @author Michael
 * @date 2025/1/11 19:29
 * @desc
 */
public class Day11 {

    public static void main(String[] args) {
        System.out.println(generateKey(1, 10, 1000));   // 0000
        System.out.println(generateKey(987, 879, 798)); // 777
        System.out.println(generateKey(1, 2, 3)); // 1
    }

    public static int generateKey(int num1, int num2, int num3) {
        int key = 0;
        for (int p = 1; num1 > 0 && num2 > 0 && num3 > 0; p *= 10) {
            key += Math.min(Math.min(num1 % 10, num2 % 10), num3 % 10) * p;
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }
        return key;
    }

}
