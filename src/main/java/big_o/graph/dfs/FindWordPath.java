package big_o.graph.dfs;

import java.util.Scanner;

public class FindWordPath {
    private static String S = "ALLIZZWELL";
    private static int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            char[][] grid = new char[row][col];
            for (int i = 0; i < row; i++) {
                String str = sc.next();
                for (int j = 0; j < col; j++) {
                    grid[i][j] = str.charAt(j);
                }
            }
            boolean[][] visited = new boolean[row][col];
            boolean isFound = false;
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (backtrack(grid, r, c, row, col, visited, 0)) {
                        isFound = true;
                        break;
                    }
                }
            }
            if (isFound) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    private static boolean backtrack(char[][] grid, int r, int c, int row, int col, boolean[][] visited, int index) {
        if (r < 0 || c < 0 || r >= row || c >= col || visited[r][c] || index >= S.length() || S.charAt(index) != grid[r][c]) return false;
        if (index == S.length() - 1) return true;
        boolean result = false;
        for (int[] neighbor : neighbors) {
            int nextR = r + neighbor[0];
            int nextC = c + neighbor[1];
            visited[r][c] = true;
            result = result || backtrack(grid, nextR, nextC, row, col, visited, index + 1);
            visited[r][c] = false;
        }
        return result;
    }
}
