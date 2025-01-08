package com.leetcode.daily.year2025.month01;

/**
 * @author: Michael
 * @date: 2025/1/8
 * @desc:
 */
public class Day08 {

    public static void main(String[] args) {
        System.out.println(largestGoodInteger("6777133339"));
        System.out.println(largestGoodInteger("2300019"));
        System.out.println(largestGoodInteger("42352338"));
    }

    // 优质解法
    // 1 ms , 击败 85.37%        时间复杂度：O(10) 十次循环
    // 41.00 MB， 击败 69.31%    空间复杂度：O(1)
    public static String largestGoodInteger(String num) {
        String result = "";

        String[] nums = new String[]{"000", "111", "222", "333", "444", "555", "666", "777", "888", "999"};

        for (int i = 0; i < nums.length; i++){
           if(num.contains(nums[i])){
               result = nums[i];
           }
        }

        return result;
    }


    // 优化后 个人解法 ： 暴力解法
    // 2 ms , 击败 50.00%        时间复杂度：O(n)
    // 41.50 MB， 击败 18.81%    空间复杂度：O(1)
    public static String largestGoodInteger3(String num) {
        String result = "";

        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i+1) && num.charAt(i+1) == num.charAt(i+2)) {
                String temp = num.substring(i, i + 3);
                if (temp.compareTo(result) > 0) {
                    result = temp;
                }
            }
        }

        return result;
    }

    // 优化后 个人解法 ： 暴力解法
    // 3 ms , 击败 25.61%
    // 42.87 MB， 击败 5.94%
    public static String largestGoodInteger2(String num) {
        String result = "";

        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(0) == num.charAt(1) && num.charAt(1) == num.charAt(2)) {
                String temp = num.substring(i, i + 3);
                if (temp.compareTo(result) > 0) {
                    result = temp;
                }
            }
        }

        return result;
    }

    // 最开始 个人解法 ： 暴力解法
    // 10 ms , 击败 8.54%
    // 43.85 MB， 击败 5.94%
    public String largestGoodInteger1(String num) {
        String result = "";
        String first = num.substring(0, 1);
        String second = num.substring(1, 2);

        for (int i = 2; i < num.length(); i++) {
            String temp = num.substring(i, i + 1);
            if (first.equals(second)) {
                if (first.equals(temp)) {
                    if (result.isEmpty()) {
                        result = first + second + temp;
                    } else {
                        if (Integer.parseInt(result) < Integer.parseInt(first + second + temp)) {
                            result = first + second + temp;
                        }
                    }
                }
            }
            first = second;
            second = temp;
        }

        return result;
    }
}
