package leetcode.backtracking;

public class WordSearch79 {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(board, "ABCCED"));

    }
    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int r = 0; r < row; r++) {
            for (int j = 0; j < col; j++) {
                if (check(board, word, row, col, 0, r, j)) return true;
            }
        }
        return false;
    }
    public static boolean check(char[][] board, String word, int row, int col, int index, int curRow, int curCol) {
        if (index >= word.length()) return true;
        if (curCol < 0 || curCol >= row || curRow < 0 || curRow >= row || word.charAt(index) != board[curRow][curCol]) return false;

        boolean exist = false;
        if (board[curRow][curCol] == word.charAt(index)) {
            board[curRow][curCol] += 100;
            exist =
                    check(board, word, row, col, index + 1, curRow + 1, curCol) || check(board, word, row, col, index + 1, curRow - 1, curCol)
                            || check(board, word, row, col, index + 1, curRow, curCol + 1) || check(board, word, row, col, index + 1, curRow, curCol - 1);
            board[curRow][curCol] -= 100;
        }
        return exist;
    }
}
