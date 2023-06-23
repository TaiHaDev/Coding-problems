package not_leetcode.graph.dfs;

import java.util.Scanner;

public class LongestStreet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int vertices = sc.nextInt();
            int[][] adjMatrix = new int[vertices][vertices];
            for (int i = 1; i < vertices; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                int length = sc.nextInt();
                adjMatrix[v1 - 1][v2 - 1] = length;
                adjMatrix[v2 - 1][v1 - 1] = length;
            }
               int result = 0;
            for (int i = 1; i < vertices; i++) {
                result = Math.max(result, dfs(adjMatrix, i, new boolean[vertices]));
            }
            System.out.println(result);
        }
    }

    private static int dfs(int[][] adjMatrix, int vertex, boolean[] visited) {
        if (visited[vertex - 1]) return 0;
        int[] matrix = adjMatrix[vertex - 1];
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            int weight = matrix[i];
            if (weight > 0 && !visited[i]) {
                visited[vertex - 1] = true;
                result = Math.max(result, weight + dfs(adjMatrix, i + 1, visited));
                visited[vertex - 1] = false;
            }
        }
        return result;
    }
}
