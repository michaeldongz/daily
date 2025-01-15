package com.leetcode.daily.year2025.month01;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: Michael
 * @date: 2025/1/15
 * @desc:
 */
public class Day15 {

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2, 11, 10, 1, 3}, 10)); // 2
        System.out.println(minOperations(new int[]{1, 1, 2, 4, 9}, 20)); // 4
    }

    public static int minOperations(int[] nums, int k) {
        // 选择数组中最小的两个数
        // 删除
        // 将 min(x, y) * 2 + max(x, y) 添加到数组中的任意位置
        // 注意，只有当 nums 至少包含两个元素时，你才可以执行以上操作。
        // 你需要使数组中的所有元素都大于或等于 k ，请你返回需要的 最少 操作次数。
        int res = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long num : nums) {
            pq.offer(num);
        }
        while (pq.peek() < k) {
            long x = pq.poll(), y = pq.poll();
            pq.offer(x + x + y);
            res++;
        }
        return res;
    }

}
