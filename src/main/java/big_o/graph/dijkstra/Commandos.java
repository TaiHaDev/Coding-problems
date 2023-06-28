package big_o.graph.dijkstra;

import java.util.*;

public class Commandos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        while (n-- > 0) {
            int vertices = sc.nextInt();
            int edgeCount = sc.nextInt();
            List<List<Integer[]>> adjList = new ArrayList<>(vertices + 1);
            for (int i = 0; i < vertices + 1; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int i = 0; i < edgeCount; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                adjList.get(v1).add(new Integer[]{v2, 1});
                adjList.get(v2).add(new Integer[]{v1, 1});
            }
            int start = sc.nextInt();
            int end = sc.nextInt();
            PriorityQueue<Integer[]> queue = new PriorityQueue<>(Comparator.comparingInt(e -> (e[1])));
            int[] dist = new int[vertices];
            Arrays.fill(dist, Integer.MAX_VALUE);
            queue.add(new Integer[]{start, 0});
            dist[start] = 0;
            while (!queue.isEmpty()) {
                Integer[] cur = queue.remove();
                for (Integer[] next : adjList.get(cur[0])) {
                    int updatedWeight = next[1] + cur[1];
                    if (updatedWeight < dist[next[0]]) {
                        dist[next[0]] = updatedWeight;
                        queue.add(new Integer[]{next[0], updatedWeight});
                    }
                }
            }
            int[] dist2 = new int[vertices];
            Arrays.fill(dist2, Integer.MAX_VALUE);
            dist2[end] = 0;
            queue.add(new Integer[]{end, 0});
            while (!queue.isEmpty()) {
                Integer[] cur = queue.remove();
                for (Integer[] next : adjList.get(cur[0])) {
                    int updatedWeight = next[1] + cur[1];
                    if (updatedWeight < dist2[next[0]]) {
                        dist2[next[0]] = updatedWeight;
                        queue.add(new Integer[]{next[0], updatedWeight});
                    }
                }
            }
            int result = 0;
            for (int i = 0; i < vertices; i++) {
                result = Math.max(result, dist[i] + dist2[i]);
            }
            System.out.println("Case " + count++ + ": " + result);
        }
    }
}
