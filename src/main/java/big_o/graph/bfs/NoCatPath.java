package big_o.graph.bfs;

import java.util.*;

public class NoCatPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int threshold = sc.nextInt();
        boolean[] catMap = new boolean[vertices + 1];
        for (int i = 0; i < vertices; i++) {
            catMap[i + 1] = sc.nextInt() == 1;
        }
        List<List<Integer>> adjList = new ArrayList<>(vertices + 1);
        for (int i = 0; i < vertices + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < vertices - 1; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }
        System.out.println(bfs(adjList, threshold, catMap));

    }

    private static int bfs(List<List<Integer>> adjList, int threshold, boolean[] catMap) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjList.size()];
        queue.add(new int[] {catMap[1] ? 1 : 0, 1});
        visited[1] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            List<Integer> integers = adjList.get(cur[1]);
            if (integers.size() == 1 && cur[1] != 1) count++;
            for (int li : integers) {
                if (visited[li]) continue;
                int[] next = {catMap[li] ? cur[0] + 1 : 0, li};
                if (next[0] <= threshold) {
                    queue.add(next);
                }
                visited[li] = true;
            }
        }
        return count;
    }
}
