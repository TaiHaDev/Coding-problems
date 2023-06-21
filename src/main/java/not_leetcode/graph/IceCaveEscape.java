package not_leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IceCaveEscape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        char[][] grid = new char[row][col];
        for (int i = 0; i < row; i++) {
            String str = sc.next();
            for (int j = 0; j < col; j++) {
                grid[i][j] = str.charAt(j);
            }
        }
        int[] start = {sc.nextInt() - 1, sc.nextInt() - 1};
        int[] end = {sc.nextInt() - 1, sc.nextInt() - 1};
        if (bfs(grid, start, end)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean bfs(char[][] grid, int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.add(start);
        visited[start[0]][start[1]] = true;
        int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] neighbor : neighbors) {
                int nextR = cur[0] + neighbor[0];
                int nextC = cur[1] + neighbor[1];
                if (nextR >= 0 && nextC >= 0 && nextR < grid.length && nextC < grid[0].length ) {
                    if ((visited[nextR][nextC] || grid[nextR][nextC] == 'X') && (end[0] == nextR && nextC == end[1])) {
                        return true;
                    }
                    if (!visited[nextR][nextC] && grid[nextR][nextC] == '.') {
                        queue.add(new int[]{nextR, nextC});
                        visited[nextR][nextC] = true;
                    }
                }
            }
        }
        return false;
    }
}
