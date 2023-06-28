package big_o.graph.dijkstra;

import java.util.*;

public class ChocolateJourney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        int citiesWithChoc = sc.nextInt();
        int requiredTime = sc.nextInt();
        int[] chocs = new int[citiesWithChoc];
        for (int i = 0; i < citiesWithChoc; i++) {
            chocs[i] = sc.nextInt();
        }
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
        int start = sc.nextInt();
        int end = sc.nextInt();
        int[] distStart = new int[vertices + 1];
        dijkstra(distStart, adjList, start);
        int[] distEnd = new int[vertices + 1];
        dijkstra(distEnd, adjList, end);
        int result = Integer.MAX_VALUE;
        for (int city : chocs) {
            int timeToChoc = distStart[city];
            int timeToFriend = distEnd[city];
            if (timeToFriend < requiredTime) {
                result = Math.min(result, timeToChoc + timeToFriend);
            }
        }
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }


    public static void dijkstra(int[] dist, List<List<int[]>> adjList, int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            if (dist[cur[0]] != cur[1]) continue;
            for (int[] next : adjList.get(cur[0])) {
                int updated = next[1] + cur[1];
                if (updated < dist[next[0]]) {
                    dist[next[0]] = updated;
                    pq.add(new int[] {next[0], updated});
                }
            }
        }
    }
}
