package leetcode.graph;

import java.util.Arrays;

public class SurroundedRegion130 {
    public static void main(String[] args) {
        char[][] board = {
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}
        };

        new SurroundedRegion130().solve(board);
        System.out.println(Arrays.deepToString(board));
    }
    public void solve(char[][] board) {
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            dfs(board, row, col, i, 0);
            dfs(board, row, col, i, col - 1);
        }
        for (int i = 0; i < col; i++) {
            dfs(board, row, col ,0, i);
            dfs(board, row, col, row - 1, i);
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == 'T') board[r][c] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int row, int col, int curRow, int curCol) {
        if (curRow < 0 || curCol < 0 || curRow == row || curCol == col || board[curRow][curCol] != 'O') return;
        board[curRow][curCol] = 'T';
        dfs(board, row, col, curRow + 1, curCol);
        dfs(board, row, col, curRow -1 , curCol);
        dfs(board, row, col, curRow, curCol + 1);
        dfs(board, row, col, curRow, curCol - 1);

    }
}
