package com.leetcode.daily.year2025.month01;

/**
 * @author Michael
 * @date 2025/1/27 08:55
 * @desc
 */
public class Day27 {

    public static void main(String[] args) {

    }

    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
