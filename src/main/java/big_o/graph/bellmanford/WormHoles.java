package big_o.graph.bellmanford;

import java.util.Arrays;
import java.util.Scanner;

public class WormHoles {
    // detect negative cycle
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int vertices = sc.nextInt();
            int edges = sc.nextInt();
            int[][] graph = new int[edges][3];
            for (int i = 0; i < edges; i++) {
                graph[i] = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()};
            }
            int[] dist = new int[vertices];
            if (bellmanFord(graph, dist, vertices, edges)) {
                System.out.println("possible");
            } else {
                System.out.println("not possible");
            }
        }
    }

    private static boolean bellmanFord(int[][] graph, int[] dist, int vertices, int edges) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < edges; j++) {
                int[] cur = graph[j];
                int u = cur[0];
                int v = cur[1];
                int weight = cur[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }
        for (int i = 0; i < edges; i++) {
            int[] cur = graph[i];
            int u = cur[0];
            int v = cur[1];
            int weight = cur[2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                return true;
            }
        }
        return false;
    }


}
