package not_leetcode.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestStreet {

    private static List<List<Edge>> adjList;
    private static int furthestNode = 0;
    private static int maxDistance = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            adjList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                int len = sc.nextInt();

                adjList.get(a).add(new Edge(b, len));
                adjList.get(b).add(new Edge(a, len));
            }

            maxDistance = -1;
            dfs(0, 0, new boolean[n]);

            maxDistance = -1;
            dfs(furthestNode, 0, new boolean[n]);

            System.out.println(maxDistance);
        }
    }

    private static void dfs(int node, int dist, boolean[] visited) {
        visited[node] = true;

        if (dist > maxDistance) {
            maxDistance = dist;
            furthestNode = node;
        }

        for (Edge e : adjList.get(node)) {
            if (!visited[e.to]) {
                dfs(e.to, dist + e.weight, visited);
            }
        }
    }
}

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}