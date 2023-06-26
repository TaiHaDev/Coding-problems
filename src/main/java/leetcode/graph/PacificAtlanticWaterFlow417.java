package leetcode.graph;

import java.util.*;

public class PacificAtlanticWaterFlow417 {
    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        System.out.println(new PacificAtlanticWaterFlow417().pacificAtlantic(heights));
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            dfs(heights, row, col, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, row, col, i, col - 1, Integer.MIN_VALUE, atlantic);
        }
        for (int i = 0; i < col; i++) {
            dfs(heights, row, col, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, row, col, row - 1, i, Integer.MIN_VALUE, atlantic);
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(List.of(r,c));
                }
            }
        }
        return result;
    }

    public void dfs(int[][] heights, int row, int col, int curRow, int curCol, int prev, boolean[][] visited) {
        if (curRow < 0 || curCol < 0 || curRow == row || curCol == col || heights[curRow][curCol] < prev || visited[curRow][curCol]) return;
        visited[curRow][curCol] = true;
        dfs(heights, row, col, curRow, curCol + 1, heights[curRow][curCol], visited);
        dfs(heights, row, col, curRow, curCol - 1, heights[curRow][curCol], visited);
        dfs(heights, row, col, curRow + 1, curCol, heights[curRow][curCol], visited);
        dfs(heights, row, col, curRow - 1, curCol, heights[curRow][curCol], visited);
    }
}
