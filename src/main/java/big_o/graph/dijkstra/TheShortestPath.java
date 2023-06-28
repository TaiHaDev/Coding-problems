package big_o.graph.dijkstra;

import java.util.*;

public class TheShortestPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int vertices = sc.nextInt();
            List<List<int[]>> adjList = new ArrayList<>(vertices + 1);
            Map<String, Integer> cityVertexMap = new HashMap<>();
            for (int i = 0; i < vertices + 1; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int i = 1; i < vertices + 1; i++) {
                String cityName = sc.next();
                cityVertexMap.put(cityName, i);
                int edgeCount = sc.nextInt();
                for (int j = 0; j < edgeCount; j++) {
                    adjList.get(i).add(new int[] {sc.nextInt(), sc.nextInt()});
                }
            }
            int total = sc.nextInt();
            while (total-- > 0) {
                PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
                int[] dist = new int[vertices + 1];
                Arrays.fill(dist, Integer.MAX_VALUE);
                int start = cityVertexMap.get(sc.next());
                pq.add(new int[]{start, 0});
                dist[start] = 0;
                while (!pq.isEmpty()) {
                    int[] cur = pq.remove();
                    if (dist[cur[0]] != cur[1]) continue;
                    for (int[] next : adjList.get(cur[0])) {
                        int updatedWeight = cur[1] + next[1];
                        if (updatedWeight < dist[next[0]]) {
                            dist[next[0]] = updatedWeight;
                            pq.add(new int[]{next[0], updatedWeight});
                        }
                    }
                }
                System.out.println(dist[cityVertexMap.get(sc.next())]);
            }
        }
    }
}
