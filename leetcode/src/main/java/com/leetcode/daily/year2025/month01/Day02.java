package com.leetcode.daily.year2025.month01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael
 * @date 2025/1/2 17:45
 * @desc
 */
public class Day02 {

    public static void main(String[] args) {
        Day02 day02 = new Day02();
    }
    static List<int[]> booked;

    public Day02() {
        booked = new ArrayList<int[]>();
    }

    public static boolean book(int startTime, int endTime) {
        for (int[] arr : booked) {
            int l = arr[0], r = arr[1];
            if (l < endTime && startTime < r) {
                return false;
            }
        }
        booked.add(new int[]{startTime, endTime});
        return true;
    }
}
