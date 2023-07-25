package big_o.prim;

import java.util.*;

public class MinimumSpanningTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        List<List<int[]>> edgeList = new ArrayList<>();
        for (int i = 0; i < vertices + 1; i++) {
            edgeList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edgeList.get(u).add(new int[] {v, w});
            edgeList.get(v).add(new int[] {u, w});
        }
        System.out.println(prim(edgeList));
    }

    private static long prim(List<List<int[]>> edgeList) {
        int[] dist = new int[edgeList.size()];
        boolean[] visited = new boolean[edgeList.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        pq.add(new int[] {1, 0});
        dist[1] = 0;
        long result = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            if (dist[cur[0]] != cur[1]) continue;
            result += cur[1];
            visited[cur[0]] = true;
            for (int[] next : edgeList.get(cur[0])) {
                if (!visited[next[0]] && next[1] < dist[next[0]]) {
                    dist[next[0]] = next[1];
                    pq.add(new int[] {next[0], next[1]});
                }
            }

        }
        return result;
    }
}
