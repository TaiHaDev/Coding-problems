package big_o.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DependencyLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        while (n-- > 0) {
            int vertices = sc.nextInt();
            int total = sc.nextInt();
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < vertices + 1; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int i = 0; i < total; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                adjList.get(v1).add(v2);
            }
            boolean[] visited = new boolean[vertices + 1];
            boolean[] recursionVisited = new boolean[vertices + 1];
            boolean isPrinted = false;
            for (int i = 1; i < visited.length; i++) {
                if (!visited[i] && !bfs(adjList, visited, i, recursionVisited)) {
                    isPrinted = true;
                    System.out.println("YES");
                    break;
                }
            }
            if (!isPrinted) {
                System.out.println("NO");
            }
        }
    }

    private static boolean bfs(List<List<Integer>> adjList, boolean[] visited, int start, boolean[] recursionVisited) {
        if (recursionVisited[start]) return false;
        if (visited[start]) return true;
        visited[start] = true;
        boolean result = true;
        for (int next : adjList.get(start)) {
            recursionVisited[start] = true;
            result = result &&  bfs(adjList, visited, next, recursionVisited);
            recursionVisited[start] = false;
        }
        return result;
    }
}
