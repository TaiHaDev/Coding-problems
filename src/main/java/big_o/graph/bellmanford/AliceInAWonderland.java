package big_o.graph.bellmanford;

import java.io.*;
import java.util.*;

public class AliceInAWonderland {
    private static final int INF = 100 * (1 << 30) + 7;

    static class Edge {
        int source, target, weight;

        public Edge(int source, int target, int weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        int tc = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int vertices = Integer.parseInt(br.readLine().trim());
            if (vertices == 0) break;

            String[] monuments = new String[vertices];
            long[][] dist = new long[vertices][vertices];
            List<Edge> graph = new ArrayList<>();

            for (int i = 0; i < vertices; i++) {
                Arrays.fill(dist[i], INF);
                String[] line = br.readLine().split(" ");
                monuments[i] = line[0];
                for (int j = 0; j < vertices; j++) {
                    int w = Integer.parseInt(line[j + 1]);
                    dist[i][j] = i == j ? 0 : w;
                    if (i != j && w != 0) {
                        graph.add(new Edge(i, j, w));
                    }
                }
            }

            for (int i = 0; i < vertices; i++) {
                bellmanFord(graph, dist, i);
            }

            int q = Integer.parseInt(br.readLine().trim());
            System.out.println("Case #" + tc++ + ":");

            while (q-- > 0) {
                String[] uv = br.readLine().split(" ");
                int u = Integer.parseInt(uv[0]);
                int v = Integer.parseInt(uv[1]);

                if (dist[u][v] <= -INF) {
                    System.out.println("NEGATIVE CYCLE");
                }
                else {
                    System.out.print(monuments[u] + "-" + monuments[v] + " ");
                    System.out.println(dist[u][v] != INF ? dist[u][v] : "NOT REACHABLE");
                }
            }
        }
    }

    private static void bellmanFord(List<Edge> edgeList, long[][] dist, int start) {
        for (int i = 0; i < dist.length - 1; i++) {
            for (Edge edge : edgeList) {
                int u = edge.source;
                int v = edge.target;
                long w = edge.weight;
                if (dist[start][u] != INF && dist[start][u] + w < dist[start][v]) {
                    dist[start][v] = dist[start][u] + w;
                }
            }
        }

        for (int i = 0; i < dist.length - 1; i++) {
            for (Edge edge : edgeList) {
                int u = edge.source;
                int v = edge.target;
                long w = edge.weight;
                if (dist[start][u] != INF && dist[start][u] + w < dist[start][v]) {
                    dist[start][v] = -INF;
                }
            }
        }
    }
}