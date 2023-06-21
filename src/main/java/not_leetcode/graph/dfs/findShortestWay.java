package not_leetcode.graph.dfs;

import java.util.*;

public class findShortestWay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < vertices - 1; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }
        int participant = sc.nextInt();
        Set<Integer> participants = new HashSet<>();
        for (int i = 0; i < participant; i++) {
            participants.add(sc.nextInt());
        }
        System.out.println(bfs(adjList, participants));
    }

    private static int bfs(List<List<Integer>> adjList, Set<Integer> participants) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjList.size()];
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                int curVertex = queue.poll();
                if (participants.contains(curVertex)) result = Math.min(result, curVertex);
                for (int next : adjList.get(curVertex)) {
                    if (visited[next]) continue;
                    queue.add(next);
                    visited[next] = true;
                }
            }
            if (result != Integer.MAX_VALUE) return result;
        }
        return -1;
    }
}
