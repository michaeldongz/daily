package com.leetcode.daily.year2025.month01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Michael
 * @date: 2025/1/6
 * @desc:
 */
public class Day06 {

    public static void main(String[] args) {
        System.out.println(maxConsecutive(2, 9, new int[]{4, 6})); // 3
        System.out.println(maxConsecutive(6, 8, new int[]{7, 6, 8})); // 0
        System.out.println(maxConsecutive(3, 15, new int[]{7, 9, 13})); // 4
    }

    // 官方 - 排序
    // 时间复杂度：O(nlogn)，其中 n 是数组 special 的长度。
    // 空间复杂度：O(logn)，即为排序需要使用的栈空间。
    public static int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int ans = 0;
        ans = Math.max(ans, special[0] - bottom);
        for (int i = 1; i < special.length; ++i) {
            ans = Math.max(ans, special[i] - special[i - 1] - 1);
        }
        ans = Math.max(ans, top - special[special.length - 1]);
        return ans;
    }


    // 题解是没问题的，但是 超出时间限制了 （大量数据测试的情况下）
    public static int maxConsecutive1(int bottom, int top, int[] special) {
        // 将 int[] 转换为 List<Integer>
        List<Integer> list = Arrays.stream(special).boxed().collect(Collectors.toList());

        int result = 0;
        int current = 0;

        for (int i = bottom; i <= top; i++) {
            if(list.contains(i)){
                if(current > result){
                    result = current;
                }
                current = 0;
                continue;
            }
            current++;
        }

        if(current > result){
            result = current;
        }

        return result;
    }
}
