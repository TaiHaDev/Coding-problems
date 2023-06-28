package big_o.graph.dijkstra;

import java.util.*;

public class TrafficNetwork {
    /**
     * using dijkstra algorithm twice to calculate the shortest path from the start and end to all other points
     * and loop throw all the new edge to calculate to minimum path
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int vertices = sc.nextInt();
            int edges = sc.nextInt();
            int newEdges = sc.nextInt();
            int start = sc.nextInt();
            int end = sc.nextInt();

            List<List<int[]>> adjList = new ArrayList<>(vertices + 1);
            for (int i = 0; i <= vertices; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int i = 0; i < edges; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                int weight = sc.nextInt();
                adjList.get(v1).add(new int[] {v2, weight});
            }

            int[][] newRoads = new int[newEdges][3];
            for (int i = 0; i < newEdges; i++) {
                newRoads[i][0] = sc.nextInt();
                newRoads[i][1] = sc.nextInt();
                newRoads[i][2] = sc.nextInt();
            }

            int[] distFromStart = dijkstra(adjList, start, vertices);
            int[] distFromEnd = dijkstra(reverseGraph(adjList, vertices), end, vertices);

            int minDist = distFromStart[end];
            for (int[] road : newRoads) {
                if(distFromStart[road[0]] != Integer.MAX_VALUE && distFromEnd[road[1]] != Integer.MAX_VALUE) {
                    minDist = Math.min(minDist, distFromStart[road[0]] + road[2] + distFromEnd[road[1]]);
                }
                if(distFromStart[road[1]] != Integer.MAX_VALUE && distFromEnd[road[0]] != Integer.MAX_VALUE) {
                    minDist = Math.min(minDist, distFromStart[road[1]] + road[2] + distFromEnd[road[0]]);
                }
            }

            System.out.println(minDist == Integer.MAX_VALUE ? -1 : minDist);
        }
    }

    private static List<List<int[]>> reverseGraph(List<List<int[]>> adjList, int vertices) {
        List<List<int[]>> reversedGraph = new ArrayList<>(vertices + 1);
        for (int i = 0; i <= vertices; i++) {
            reversedGraph.add(new ArrayList<>());
        }
        for(int i = 1; i <= vertices; i++){
            for(int[] edge : adjList.get(i)){
                reversedGraph.get(edge[0]).add(new int[]{i, edge[1]});
            }
        }
        return reversedGraph;
    }

    private static int[] dijkstra(List<List<int[]>> adjList, int source, int vertices) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        int[] dist = new int[vertices + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new int[]{source, 0});
        dist[source] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            if (dist[cur[0]] != cur[1]) continue;
            for (int[] next : adjList.get(cur[0])) {
                int updatedWeight = next[1] + cur[1];
                if (updatedWeight < dist[next[0]]) {
                    dist[next[0]] = updatedWeight;
                    pq.add(new int[]{next[0], updatedWeight});
                }
            }
        }

        return dist;
    }
}
