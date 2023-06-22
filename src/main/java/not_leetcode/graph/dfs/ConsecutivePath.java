    package not_leetcode.graph.dfs;

    import java.util.Scanner;

    public class ConsecutivePath {
        private static int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = 1;
            while (true) {
                int row = sc.nextInt();
                int col = sc.nextInt();
                if (row == 0 && col == 0) break;
                char[][] grid = new char[row][col];
                for (int i = 0; i < row; i++) {
                    grid[i] = sc.next().toCharArray();
                }
                int result = 0;
                for (int r = 0; r < row; r++) {
                    for (int c = 0; c < col; c++) {
                        result = Math.max(backtrack(grid, new boolean[row][col], r, c, row, col, 0), result);
                    }
                }
                System.out.println("Case " + n++ + ": " + result);
            }

        }

        private static int backtrack(char[][] grid, boolean[][] visited, int r, int c, int row, int col, int index) {
            if (r < 0 || c < 0 || r >= row || c >= col || visited[r][c] || grid[r][c] != 'A' + index) return 0;
            int count = 0;
            for (int[] neighbor : neighbors) {
                int nextR = r + neighbor[0];
                int nextC = c + neighbor[1];
                visited[r][c] = true;
                count =  Math.max(count, 1 + backtrack(grid, visited, nextR, nextC, row, col, index + 1));
                visited[r][c] = false;
            }
            return count;
        }
    }
