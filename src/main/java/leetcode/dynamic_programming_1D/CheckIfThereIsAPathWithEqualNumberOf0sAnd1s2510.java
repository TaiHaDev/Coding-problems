package leetcode.dynamic_programming_1D;

public class CheckIfThereIsAPathWithEqualNumberOf0sAnd1s2510 {
    public static void main(String[] args) {
        System.out.println(new CheckIfThereIsAPathWithEqualNumberOf0sAnd1s2510().isThereAPath(new int[][] {{0,1,0,0},{0,1,0,0},{1,0,1,0}}));
    }
    public boolean isThereAPath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if ((row + col - 1) % 2 != 0) return false;
        int steps = (row + col - 1) / 2;
        int diffLen = steps * 2 + 1;
        boolean[][][] dp = new boolean[row][col][diffLen];
        dp[row - 1][col - 1][grid[row-1][col-1] == 0 ? -1 + steps : 1 + steps] = true;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                int offset = grid[i][j] == 0 ? -1 : 1;
                for (int diff = 0; diff < diffLen; diff++) {
                    if (i != row - 1 && dp[i + 1][j][diff]) {
                        int newDiff = diff + offset;
                        if (newDiff < 0 || newDiff >= diffLen) {
                            continue;
                        }
                        dp[i][j][newDiff] = true;
                    }
                    if (j != col - 1 && dp[i][j + 1][diff]) {
                        int newDiff = diff + offset;
                        if (newDiff < 0 || newDiff >= diffLen) {
                            continue;
                        }
                        dp[i][j][newDiff] = true;
                    }
                }
            }
        }
        return dp[0][0][steps];
    }
}
