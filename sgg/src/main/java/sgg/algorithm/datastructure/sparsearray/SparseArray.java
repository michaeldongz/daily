package sgg.algorithm.datastructure.sparsearray;

/**
 * @author: Michael
 * @date: 2025/2/10
 * @desc: 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        // 创建原始的二维数组 11 * 11
        // 0 表示没有棋子； 1 表示 黑子； 2 表示 白子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        // 输出
        int sum = 0;
        for (int[] row : chessArr1){
            for (int data : row){
                if(data != 0){
                    sum++;
                }
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 将二维数组转换成稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        // 输出
        for (int[] row : sparseArr){
            System.out.printf("%d\t%d\t%d\t\n", row[0], row[1], row[2]);
        }
    }


}
