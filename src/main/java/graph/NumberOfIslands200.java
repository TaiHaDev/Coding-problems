package graph;

public class NumberOfIslands200 {
    /**
     * using backtracking to visit all the land of each island and loop through each element in the grid and count
     * pretty bad explanation D:.
     * An optimisation to this problem is to modify the grid argument inplace so we can remove the visit array to track
     * visited element.
     * @param args
     */
    public static void main(String[] args) {
        char[][] grid = {{'1','0','1','1','0','1','1'}};
        System.out.println(new NumberOfIslands200().numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    bfs(grid, row, col, r, c);
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int row, int col, int curRow, int curCol) {
        if (curRow < 0 || curCol < 0 || curRow == row || curCol == col || grid[curRow][curCol] == '0')
            return;
        grid[curRow][curCol] = '0';
        bfs(grid, row, col,  curRow + 1, curCol);
        bfs(grid, row, col,  curRow - 1, curCol);
        bfs(grid, row, col,  curRow, curCol + 1);
        bfs(grid, row, col, curRow, curCol - 1);
    }
}
