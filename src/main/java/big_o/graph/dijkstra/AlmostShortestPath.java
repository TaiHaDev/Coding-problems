package big_o.graph.dijkstra;

import java.util.*;

public class AlmostShortestPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int vertices = sc.nextInt();
            int edges = sc.nextInt();
            if (vertices == 0 && edges == 0) break;
            int start = sc.nextInt();
            int end = sc.nextInt();
            List<List<Integer[]>> adjList = new ArrayList<>();
            List<List<Integer[]>> reversedAdjList = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
                reversedAdjList.add(new ArrayList<>());
            }
            for (int i = 0; i < edges; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                int weight = sc.nextInt();
                adjList.get(v1).add(new Integer[] {v2, weight});
                reversedAdjList.get(v2).add(new Integer[]{v1, weight});
            }
            int[] distStart = new int[vertices];
            int[] distEnd = new int[vertices];
            dijkstra(distStart, adjList, start);
            dijkstra(distEnd, reversedAdjList, end);
            for (int vertex = 0; vertex < vertices; vertex++) {
                for (Integer[] edge : adjList.get(vertex)) {
                    if (distStart[vertex] + distEnd[edge[0]] + edge[1] == distStart[end]) {
                        edge[1] = Integer.MAX_VALUE;
                    }
                }
            }
            int[] dist = new int[vertices];
            dijkstra(dist, adjList, start);
            System.out.println(dist[end] == Integer.MAX_VALUE ? -1 : dist[end]);
        }
    }
    public static void dijkstra(int[] dist, List<List<Integer[]>> adjList, int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            if (dist[cur[0]] != cur[1]) continue;
            for (Integer[] next : adjList.get(cur[0])) {
                if (next[1] == Integer.MAX_VALUE) continue;
                int updated = next[1] + cur[1];
                if (updated < dist[next[0]]) {
                    dist[next[0]] = updated;
                    pq.add(new int[]{next[0], updated});
                }
            }
        }
    }
}





