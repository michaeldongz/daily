package com.leetcode.learning.arrayAndString;

/**
 * @author: Michael
 * @date: 2025/1/7
 * @desc: 最长公共前缀
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

    }

    public static String longestCommonPrefix(String[] strs) {
        String str;
        String minStr = strs[0];
        int cnnt = 0;
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<minStr.length()){
                minStr = strs[i];
            }
        }
        for(int i=0;i<minStr.length();i++){
            str = minStr.substring(0, minStr.length()-i);
            cnnt = 0;
            for(int j=0;j<strs.length;j++){
                cnnt = strs[j].indexOf(str)==0?++cnnt:cnnt;
            }
            if(cnnt>=strs.length){
                return str;
            }
        }
        return "";
    }

}
