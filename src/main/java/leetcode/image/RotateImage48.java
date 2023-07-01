package leetcode.image;

import java.util.Arrays;

public class RotateImage48 {
    /**
     * rotate the image 90 degree
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new RotateImage48().rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
    }
    // basically, we rotate it through this axis \ then this axis |
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i ; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                int nextCol = matrix.length - 1 - j;
                matrix[i][j] = matrix[i][nextCol];
                matrix[i][nextCol] = temp;
            }
        }
    }
}
