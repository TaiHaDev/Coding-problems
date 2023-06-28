package big_o.graph.dijkstra;

import java.util.*;

public class MiceMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int start = sc.nextInt();
        int timeRequired = sc.nextInt();
        int total = sc.nextInt();
        List<List<int[]>> adjList = new ArrayList<>(vertices + 1);
        for (int i = 0; i < vertices + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < total; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            adjList.get(v2).add(new int[] {v1, weight});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        int[] dist = new int[vertices + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new int[]{start, 0});
        dist[start] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            if (dist[cur[0]] != cur[1]) continue;
            for (int[] next : adjList.get(cur[0])) {
                int newWeight = next[1] + cur[1];
                if (newWeight < dist[next[0]]) {
                    dist[next[0]] = newWeight;
                    pq.add(new int[]{next[0], newWeight});
                }
            }
        }
        int result = 0;
        for (int d : dist) {
            if (d <= timeRequired) {
                result++;
            }
        }
        System.out.println(Arrays.toString(dist));
        System.out.println(result);
    }
}
