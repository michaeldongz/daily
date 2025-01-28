package com.leetcode.daily.year2025.month01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael
 * @date 2025/1/28 09:27
 * @desc
 */
public class Day28 {

    public static void main(String[] args) {

    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }
}