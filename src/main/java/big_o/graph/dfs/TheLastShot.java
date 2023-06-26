package big_o.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheLastShot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
        int max = 0;
        for (int i = 1; i < vertices + 1; i++) {
            boolean[] visited = new boolean[vertices + 1]; // move inside the for loop so that it get refreshed for each for loop :)
            max = Math.max(max, dfs(adjList, visited, i));
        }
        System.out.println(max);
    }

    private static int dfs(List<List<Integer>> adjList, boolean[] visited, int i) {
        if (visited[i]) return 0;
        visited[i] = true;
        int count = 1;
        for (int next : adjList.get(i)) {
            count += dfs(adjList, visited, next);
        }
        return count;
    }
}