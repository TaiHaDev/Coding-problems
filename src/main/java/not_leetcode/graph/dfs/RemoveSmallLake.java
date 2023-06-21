package not_leetcode.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveSmallLake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int removeCount = sc.nextInt();
        char[][] grid = new char[row][col];
        for (int i = 0; i < row; i++) {
            String next = sc.next();
            for (int j = 0; j < col; j++) {
                grid[i][j] = next.charAt(j);
            }
        }
        boolean[][] visited = new boolean[row][col];
        List<List<int[]>> lakeAreas =  new ArrayList<>();
        for (int r = 1; r < row - 1; r++) {
            for (int c = 1; c < col - 1; c++) {
                if (!visited[r][c] && grid[r][c] == '.') {
                    List<int[]> points = new ArrayList<>();
                    boolean isLake = dfs(grid, visited, r, c, row, col, points);
                    if (isLake) {
                        lakeAreas.add(points);
                    }
                }
            }
        }
        lakeAreas.sort((o1, o2) -> Integer.compare(o1.size(), o2.size()));
        int result = 0;
        for (int i = 0; i < lakeAreas.size() - removeCount; i++) {
            List<int[]> points = lakeAreas.get(i);
            result += points.size();
            for (int[] point : points) {
                grid[point[0]][point[1]] = '*';
            }
        }
        System.out.println(result);
        for (char[] cs : grid) {
            for (char c : cs) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static boolean dfs(char[][] grid, boolean[][] visited, int r, int c, int row, int col, List<int[]> points) {
        if (r < 0 || c < 0 || r >= row || c >= col || visited[r][c] || grid[r][c] == '*') return true;
        if (r == 0 || c == 0 || r == row - 1 || c == col -1) return false;
        points.add(new int[] {r, c});
        visited[r][c] = true;
        return
        dfs(grid, visited, r + 1, c, row, col, points) &&
        dfs(grid, visited, r - 1, c, row, col, points) &&
        dfs(grid, visited, r, c + 1, row, col, points) &&

                dfs(grid, visited, r, c - 1, row, col, points);
    }
}
