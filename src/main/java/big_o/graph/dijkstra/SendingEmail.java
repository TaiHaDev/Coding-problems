package big_o.graph.dijkstra;

import java.util.*;

public class SendingEmail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int count = 1;
        while (cases-- > 0) {
            int vertices = sc.nextInt();
            int edgeCount = sc.nextInt();
            int start = sc.nextInt();
            int end = sc.nextInt();

            List<List<Integer[]>> adjList = new ArrayList<>();
            for (int i = 0; i <= vertices; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int i = 0; i < edgeCount; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                int weight = sc.nextInt();
                adjList.get(v1).add(new Integer[]{v2, weight});
                adjList.get(v2).add(new Integer[]{v1, weight});
            }
            PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
            int[] dist = new int[vertices+ 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            pq.add(new Integer[]{start, 0});
            dist[start] = 0;
            while (!pq.isEmpty()) {
                Integer[] cur = pq.remove();
                if (dist[cur[0]] != cur[1]) continue;
                for (Integer[] next : adjList.get(cur[0])) {
                    int updatedWeight = cur[1] + next[1];
                    if (updatedWeight < dist[next[0]]) {
                        dist[next[0]] = updatedWeight;
                        pq.add(new Integer[]{next[0], updatedWeight});
                    }
                }
            }
            System.out.println("Case #" + count++ + ": " + (dist[end] == Integer.MAX_VALUE ? "unreachable" : dist[end]));
        }
    }
}
