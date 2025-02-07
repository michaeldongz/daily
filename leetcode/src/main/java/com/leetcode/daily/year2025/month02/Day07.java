package com.leetcode.daily.year2025.month02;

/**
 * @author: Michael
 * @date: 2025/2/7
 * @desc:
 */
public class Day07 {

    public static void main(String[] args) {
        System.out.println(generateMatrix(3)); // [[1,2,3],[8,9,4],[7,6,5]]
        System.out.println(generateMatrix(1)); // [[1]]
    }

    public static int[][] generateMatrix(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int directionIndex = 0;
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }

}
