package big_o.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int vertices = sc.nextInt();
            int total = sc.nextInt();
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int i = 0; i < total; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                adjList.get(v1).add(v2);
                adjList.get(v2).add(v1);
            }
            boolean[] students = new boolean[vertices];
            int count = 0;
            for (int i = 0; i < vertices ; i++) {
                if (!students[i]) {
                    dfs(adjList, students, i);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(List<List<Integer>> adjList, boolean[] students, int i) {
        if (students[i]) return;
        students[i] = true;
        for (int next : adjList.get(i)) {
            dfs(adjList, students, next);
        }
    }
}
