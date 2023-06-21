package not_leetcode.graph.bfs;

import java.util.*;

public class ShortestReachBFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        while (total-- > 0) {
            int vertices = sc.nextInt();
            int edge = sc.nextInt();
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= vertices; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < edge; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }
            int[] len = new int[vertices + 1];
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[vertices + 1];
            int root = sc.nextInt();
            queue.add(root);
            visited[root] = true;
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                List<Integer> next = graph.get(cur);
                for (int n : next) {
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                        len[n] = len[cur] + 6;
                    }
                }
            }
            for (int i = 1; i < len.length; i++) {
                if (i == root) continue;
                int cur = len[i];
                if (cur == 0) System.out.print(-1);
                else System.out.print(cur);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
