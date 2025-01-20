package com.leetcode.daily.year2025.month01;

/**
 * @author: Michael
 * @date: 2025/1/20
 * @desc:
 */
public class Day20 {

    public static void main(String[] args) {
        System.out.println(findClosestNumber(new int[]{-4, -2, 1, 4, 8})); // 1
        System.out.println(findClosestNumber(new int[]{2, -1, 1})); // 1
    }

    // 2ms 击败68.52%
    // 44.12MB 击败 19.01%
    public static int findClosestNumber(int[] nums) {
        int result = nums[0];
        int min = Math.abs(nums[0]);

        for (int i = 1; i < nums.length; i++){
            int num = nums[i];

            if (Math.abs(num) < min){
                result = num;
                min = Math.abs(num);;
            } else if (Math.abs(num) == min){
               result = Math.max(result, num);
            }
        }

        return result;
    }
}
