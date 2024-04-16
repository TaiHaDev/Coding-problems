package leetcode.hash;

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
}
