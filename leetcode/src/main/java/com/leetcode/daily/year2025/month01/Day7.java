package com.leetcode.daily.year2025.month01;

/**
 * @author: Michael
 * @date: 2025/1/7
 * @desc:
 */
public class Day7 {

    public static void main(String[] args) {
        System.out.println(countKeyChanges("aAbBcC")); // 输出：2 A -> b;  B -> c ;
        System.out.println(countKeyChanges("AaAaAaaA")); // 输出：0
    }

    // 时间复杂度：O(n)，其中 n 是字符串 s 的长度。
    // 空间复杂度：O(1)。
    // 1ms  击败 84%
    // 41.27MB 击败 51.82%
    public static int countKeyChanges(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (Character.toLowerCase(s.charAt(i - 1)) != Character.toLowerCase(s.charAt(i))) {
                ++ans;
            }
        }
        return ans;
    }


    // 1ms  击败 84%
    // 41.36MB 击败 35.45%
    public static int countKeyChanges1(String s) {
        int count = 0;
        char pre = ' ';

        for (int i = 0; i < s.length(); i++){
            char c = Character.toLowerCase(s.charAt(i));
            if (pre != ' ' && c != pre){
                count ++;
            }
            pre = c;
        }

        return count;
    }
}
