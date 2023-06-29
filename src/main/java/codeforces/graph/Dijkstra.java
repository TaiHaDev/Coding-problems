package codeforces.graph;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        List<List<int[]>> adjList = new ArrayList<>(vertices + 1);
        for (int i = 0; i < vertices + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            adjList.get(v1).add(new int[] {v2, weight});
            adjList.get(v2).add(new int[] {v1, weight});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        int[] dist = new int[vertices + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new int[]{1, 0});
        dist[1] = 0;
        int[] path = new int[vertices + 1];
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            if (dist[cur[0]] != cur[1]) continue;
            for (int[] next : adjList.get(cur[0])) {
                int updatedWeight = next[1] + cur[1];
                if (updatedWeight < dist[next[0]]) {
                    dist[next[0]] = updatedWeight;
                    pq.add(new int[]{next[0], updatedWeight});
                    path[next[0]] = cur[0];
                }
            }
        }
        if (dist[vertices] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            int last = vertices;
            int next = path[last];
            while(last != 1) {
                int temp = path[next];
                path[next] = last;
                last = next;
                next = temp;
            }
            System.out.print(last);
            while(last != vertices) {
                last = path[last];
                System.out.print(" " + last);
            }
        }
    }
}
