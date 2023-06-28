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
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int i = 0; i < edges; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                int weight = sc.nextInt();
                adjList.get(v1).add(new Integer[] {v2, weight});
            }
            int[] dist = new int[vertices];
            int[][] path = new int[vertices][2];
            dijkstra(dist, adjList, start, path);
            if (dist[end] == Integer.MAX_VALUE) {
                System.out.println(-1);
                continue;
            }
            int last = dist[end];
            while (true) {
                int p = end;
                while (p != start) {
                    int[] prev = path[p];
                    p = prev[0];
                    adjList.get(prev[0]).get(prev[1])[1] = Integer.MAX_VALUE;
                }
                path = new int[vertices][2];
                dist = new int[vertices];
                dijkstra(dist, adjList, start, path);
                if (dist[end] != last) {
                    break;
                }
            }
            System.out.println(dist[end] == Integer.MAX_VALUE ? -1 : dist[end]);
        }
    }
    public static void dijkstra(int[] dist, List<List<Integer[]>> adjList, int start, int[][] path) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            if (dist[cur[0]] != cur[1]) continue;
            List<Integer[]> get = adjList.get(cur[0]);
            for (int i = 0; i < get.size(); i++) {
                Integer[] next = get.get(i);
                if (next[1] == null || next[1] == Integer.MAX_VALUE) continue;
                int updated = next[1] + cur[1];
                if (updated < dist[next[0]]) {
                    dist[next[0]] = updated;
                    pq.add(new int[]{next[0], updated});
                    path[next[0]] = new int[]{cur[0], i};
                }
            }
        }
    }
}





