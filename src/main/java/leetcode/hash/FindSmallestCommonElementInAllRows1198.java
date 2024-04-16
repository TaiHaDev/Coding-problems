package leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindSmallestCommonElementInAllRows1198 {
    public int smallestCommonElement(int[][] mat) {
        Map<Integer, Integer> countMap = new HashMap();
        int row = mat.length;
        int col = mat[0].length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int curNum = mat[i][j];
                countMap.put(curNum, countMap.getOrDefault(curNum, 0) + 1);
                if (countMap.get(curNum) == row) {
                    res = Math.min(curNum, res);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public int smallestCommonElement1(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int[] startingPos = new int[row];
        for (int i = 0; i < col; i++) {
            boolean found = true;
            int curNum = mat[0][i];
            for (int j = 0; j < row; j++) {
                startingPos[j] = Arrays.binarySearch(mat[j], startingPos[j], col, curNum);
                if (startingPos[j] < 0) {
                    found = false;
                    startingPos[j] = - startingPos[j] - 1;
                    if (startingPos[j] >= col) return -1;
                }
            }
            if (found) {
                return curNum;
            }
        }
        return -1;
    }
}
