package leetcode.array;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int row = grid.length;
        int cow = grid[0].length;
        int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < cow; c++) {
                if (grid[r][c] == 1) {
                    res += 4;
                    if (r > 0 && grid[r-1][c] == 1) {
                        res -= 2;
                    }
                    if (c > 0 && grid[r][c-1] == 1) {
                        res -= 2;
                    }
                }
            }
        }
        return res;
    }
}
