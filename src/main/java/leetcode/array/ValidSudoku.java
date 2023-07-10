package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku{
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = null;
        Set<Character> colSet = null;
        for (int i = 0; i < 9; i++) {
            rowSet = new HashSet<>();
            colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char curRow = board[i][j];
                char curCol = board[j][i];
                if (curRow != '.') {
                    if (rowSet.contains(curRow)) {
                        return false;
                    } else {
                        rowSet.add(curRow);
                    }
                }
                if (curCol != '.') {
                    if (colSet.contains(curCol)) {
                        return false;
                    } else {
                        colSet.add(curCol);
                    }
                }
            }
        }
        for (int i = 0; i < 9; i+= 3) {
            for (int j = 0; j < 9; j+= 3) {
                if (!isValidBlock(i, j, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidBlock(int i, int j, char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                char cur = board[k][l];
                if (cur == '.') continue;
                if (set.contains(cur)) return false;
                set.add(cur);
            }
        }
        return true;
    }
}
