package not_leetcode.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        int[] start = {0, 0};
        int c = 1;
        while(time-- > 0) {
            int col = sc.nextInt();
            int row = sc.nextInt();
            char[][] grid = new char[row][col];
            for (int i = 0; i < row; i++) {
                String curRow = sc.next();
                for (int j = 0; j < col; j++) {
                    grid[i][j] = curRow.charAt(j);
                    if (curRow.charAt(j) == '@') {
                        start = new int[] {i, j};
                    }
                }
            }
            System.out.println("Case " + c++ + ": " + bfs(grid, start));
        }


    }

    private static int bfs(char[][] grid, int[] start) {
        int[][] neighbors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            result++;
            for (int[] neighbor : neighbors) {
                int nextR = cur[0] + neighbor[0];
                int nextC = cur[1] + neighbor[1];
                if (nextR >= 0 && nextC >= 0 && nextR < grid.length &&
                        nextC < grid[0].length &&
                        !visited[nextR][nextC] && grid[nextR][nextC] == '.') {
                    queue.add(new int[]{nextR, nextC});
                    visited[nextR][nextC] = true;
                }
            }
        }
        return result;
    }
}
