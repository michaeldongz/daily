package com.leetcode.daily.year2025.month01;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Michael
 * @date 2025/1/4 13:08
 * @desc
 */
public class Day04 {

    public static void main(String[] args) {
    }

    private static TreeMap<Integer, Integer> cnt;

    public Day04() {
        cnt = new TreeMap<Integer, Integer>();
    }

    public static int book(int startTime, int endTime) {
        int ans = 0;
        int maxBook = 0;
        cnt.put(startTime, cnt.getOrDefault(startTime, 0) + 1);
        cnt.put(endTime, cnt.getOrDefault(endTime, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int freq = entry.getValue();
            maxBook += freq;
            ans = Math.max(maxBook, ans);
        }
        return ans;
    }

}
