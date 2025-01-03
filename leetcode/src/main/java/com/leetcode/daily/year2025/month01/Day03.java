package com.leetcode.daily.year2025.month01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Michael
 * @date: 2025/1/3
 * @desc:
 */
public class Day03 {

    public static void main(String[] args) {
        Day03 day03 = new Day03();
        System.out.println(book(10, 20));
        System.out.println(book(50, 60));
        System.out.println(book(10, 40));
        System.out.println(book(5, 15));
        System.out.println(book(5, 10));
        System.out.println(book(25, 55));
    }

    static List<int[]> booked;
    static List<int[]> overlaps;

    public Day03() {
        booked = new ArrayList<int[]>();
        overlaps = new ArrayList<int[]>();
    }

    public static boolean book(int startTime, int endTime) {
        for (int[] arr : overlaps) {
            int l = arr[0], r = arr[1];
            if (l < endTime && startTime < r) {
                return false;
            }
        }
        for (int[] arr : booked) {
            int l = arr[0], r = arr[1];
            if (l < endTime && startTime < r) {
                overlaps.add(new int[]{Math.max(l, startTime), Math.min(r, endTime)});
            }
        }
        booked.add(new int[]{startTime, endTime});
        return true;
    }
}
