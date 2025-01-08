package com.leetcode.learning.arrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Michael
 * @date: 2025/1/7
 * @desc: 零矩阵
 */
public class ZeroMatrix {

    public static void main(String[] args) {
        int[][] int1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(int1);


        int[][] int2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes(int2);
    }

    // 0 ms 击败100%
    // 44.7 MB 击败42.86%
    public static void setZeroes(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        int[] rowRecord = new int[M];
        int[] colRecord = new int[N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    rowRecord[i] = 1;
                    colRecord[j] = 1;
                }
            }
        }

        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                if (rowRecord[row] == 1 || colRecord[col] == 1) {
                    matrix[row][col] = 0;
                }
            }

        }
    }

    // 6 ms 击败5.35%
    // 44.8MB 击败17.65%
    public static void setZeroes1(int[][] matrix) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        row = row.stream().distinct().toList();
        col = col.stream().distinct().toList();

        for (int r : row) {
            Arrays.fill(matrix[r], 0);
        }

        for (int c : col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][c] = 0;
            }
        }

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

}