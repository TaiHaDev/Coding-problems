package leetcode.array;

public class MinimumPathSum64 {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new MinimumPathSum64().minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = col - 2; i >= 0; i--) {
            grid[row - 1][i] = grid[row - 1][i + 1] + grid[row - 1][i];
        }
        for (int i = row - 2; i >= 0; i--) {
            grid[i][col - 1] = grid[i + 1][col-1] + grid[i][col-1];
        }
        for (int r = row - 2; r >= 0; r--) {
            for (int c = col - 2; c >= 0; c--) {
                grid[r][c] = Math.min(grid[r+1][c], grid[r][c+1]) + grid[r][c];
            }
        }
        return grid[0][0];
    }
}
