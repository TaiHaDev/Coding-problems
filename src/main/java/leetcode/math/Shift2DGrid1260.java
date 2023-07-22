package leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid1260 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(new Shift2DGrid1260().shiftGrid(grid, 1));
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                temp.add(0);
            }
            result.add(temp);
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int nextRow = (r + (c + k) / col) % row;
                int nextCol = (c + k) % col;
                result.get(nextRow).set(nextCol, grid[r][c]);
            }
        }
        return result;
    }
}
