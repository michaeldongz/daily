package com.leetcode.daily.year2025.month01;

/**
 * @author Michael
 * @date 2025/1/1 20:22
 * @desc
 */
public class Day01 {

    public static void main(String[] args) {
        System.out.println(convertDateToBinary("2080-02-29"));
        System.out.println(convertDateToBinary("1900-01-01"));
    }

    // 官方答案 时间复杂度和空间复杂度都是0(1)
    public static String convertDateToBinary(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        return binary(year) + "-" + binary(month) + "-" + binary(day);
    }

    private static String binary(int x) {
        StringBuilder s = new StringBuilder();
        for (; x != 0; x >>= 1) {
            System.out.println("x is : " + x);
            s.append(x & 1);
        }
        return s.reverse().toString();
    }

    // 自己的方案  只击败了6%
    public static String convertDateToBinary1(String date) {

        return convertStrToBinary(date.substring(0, 4)) +
                "-" +
                convertStrToBinary(date.substring(5, 7)) +
                "-" +
                convertStrToBinary(date.substring(8, 10));
    }

    private static String convertStrToBinary(String substring) {
        System.out.println("Current substring is : " + substring);
        int num = Integer.parseInt(substring);
        return Integer.toBinaryString(num);
    }

}
