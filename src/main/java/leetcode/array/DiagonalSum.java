package leetcode.array;

public class DiagonalSum {
    public int diagonalSum(int[][] mat) {
        int result = 0;
        for (int i = 0; i < mat.length; i++) {
            result += mat[i][i];
            if (mat.length % 2 != 0 && i == mat.length / 2) continue;
            result += mat[i][mat[0].length - 1 - i];
        }
        return result;
    }
}

