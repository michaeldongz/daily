package com.leetcode.learning.arrayAndString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Michael
 * @date: 2025/1/7
 * @desc: 对角线遍历
 */
public class DiagonalTraversal {

    public static void main(String[] args) {

    }


    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        //存放数组
        int[] ans = new int[m * n];
        //对角线方向次数
        int count = n + m - 1;
        //定义初始化 行标记，列标记，存放数组索引
        int row = 0, col = 0, Index = 0;
        //开始对角线循环
        for (int i = 0; i < count; i++) {
            //判断对角线方向（因题目初始从右上（即i=0）开始）：偶数右上，奇数左下
            if (i % 2 == 0) {
                //右上操作
                while (row >= 0 && col < n) {
                    //将矩阵数存入存放数组
                    ans[Index] = matrix[row][col];
                    //索引后移
                    Index++;
                    //右上规律：行减一，列加一
                    row--;
                    col++;
                }
                //判断是否为越界情况：不越界正常行加一，越界行加二，列减一；
                //（此处不理解的拿张草稿纸将循环中row和col的值遍历写一下对照矩阵图就明白了）
                if (col < n) {
                    row++;
                }
                else {
                    row += 2;
                    col--;
                }
            }
            //左下操作：按规律与右上相反即可
            else {
                while (row < m && col >= 0) {
                    ans[Index] = matrix[row][col];
                    Index++;
                    row++;
                    col--;
                }
                if (row < m) {
                    col++;

                } else {
                    row--;
                    col += 2;
                }
            }
        }
        // 返回存放数组
        return ans;
    }

    public static int[] findDiagonalOrder1(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] result = new int[n*m];

        for(int i = 0,idx = 0; i < n+m-1; i++){
            if(i % 2 == 0){ //偶数对角线 ，从下往上遍历
                for(int x = Math.min(i,n-1); x >= Math.max(0, i-m+1); x--){
                    result[idx++] = mat[x][i-x];
                }
            }else{
                for(int x= Math.max(0,i-m+1);x<=Math.min(i,n-1);x++){
                    result[idx++] = mat[x][i-x];
                }
            }

        }
        return result;
    }

}
