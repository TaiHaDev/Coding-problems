package not_leetcode.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ValidateMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        while(total-- > 0) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            char[][] maze = new char[row][col];
            int[] start = null;
            int[] end = null;
            boolean isInputValid = true;
            for (int i = 0; i < row; i++) {
                String curRow = sc.next();
                for (int j = 0; j < col; j++) {
                    maze[i][j] = curRow.charAt(j);
                    if ((i == 0 || i == row - 1 || j == 0 || j == col - 1) && maze[i][j] == '.') {
                        int[] way = new int[] {i, j};
                        if (start == null) start = way;
                        else if (end == null) {
                            end = way;
                        } else {
                            isInputValid = false;
                        }

                    }
                }
            }
            if (!isInputValid || start == null || end == null) {
                System.out.println("invalid");
            } else if (bfs(maze, start, end)) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }

        }
    }

    private static boolean bfs(char[][] maze, int[] start, int[] end) {
        int[][] neighbors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == end[0] && cur[1] == end[1]) {
                return true;
            }
            for (int[] neighbor : neighbors) {
                int r = cur[0] + neighbor[0];
                int c = cur[1] + neighbor[1];
                if (r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && !visited[r][c] &&  maze[r][c] == '.') {
                    visited[r][c] = true;
                    queue.add(new int[] {r,c});
                }
            }
        }
        return false;
    }
}
