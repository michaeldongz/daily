package com.leetcode.learning.arrayAndString;

/**
 * @author: Michael
 * @date: 2025/1/7
 * @desc: 旋转矩阵
 */
public class RotationMatrix {

    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                exchange(matrix, i, j, j, matrix.length - 1 - i);
                exchange(matrix, i, j, matrix.length - 1 - i, matrix.length - 1 - j);
                exchange(matrix, i, j, matrix.length - 1 - j, i);
            }
        }
    }

    public static void exchange(int[][] matrix, int i1, int j1, int i2, int j2) {
        matrix[i1][j1] = matrix[i1][j1] + matrix[i2][j2];
        matrix[i2][j2] = matrix[i1][j1] - matrix[i2][j2];
        matrix[i1][j1] = matrix[i1][j1] - matrix[i2][j2];
    }

}