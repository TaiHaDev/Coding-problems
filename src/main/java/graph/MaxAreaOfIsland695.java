package graph;

public class MaxAreaOfIsland695 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(new MaxAreaOfIsland695().maxAreaOfIsland(grid));
    }
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(backtrack(grid, row, col, r, c), maxArea);
                }
            }
        }
        return maxArea;
    }

    public int backtrack(int[][] grid, int row, int col, int curRow, int curCol) {
        if (curRow < 0 || curCol < 0 || curRow == row || curCol == col || grid[curRow][curCol] == 0) return 0;
        grid[curRow][curCol] = 0;
        return 1 + backtrack(grid, row, col, curRow + 1, curCol) + backtrack(grid, row, col, curRow - 1, curCol)
                + backtrack(grid, row, col, curRow, curCol + 1) + backtrack(grid, row, col, curRow, curCol - 1);
    }
}
