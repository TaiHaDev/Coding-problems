package not_leetcode.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestStreet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int vertices = sc.nextInt();
            List<TownStreet>[] adjList = new List[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new ArrayList<>();
            }
            for (int i = 1; i < vertices; i++) {
                int v1 = sc.nextInt() - 1;
                int v2 = sc.nextInt() - 1;
                int length = sc.nextInt();
                adjList[v1].add(new TownStreet(v2, length));
                adjList[v2].add(new TownStreet(v1, length));
            }
               int result = 0;
            for (int i = 1; i < vertices; i++) {
                result = Math.max(result, dfs(adjList, i, new boolean[vertices]));
            }
            System.out.println(result);
        }
    }

    private static int dfs(List<TownStreet>[] adjMatrix, int vertex, boolean[] visited) {
        if (visited[vertex - 1]) return 0;
        List<TownStreet> matrix = adjMatrix[vertex - 1];
        int result = 0;
        for (TownStreet street : matrix) {
            int weight = street.weight;
            int i = street.to;
            if (weight > 0 && !visited[i]) {
                visited[vertex - 1] = true;
                result = Math.max(result, weight + dfs(adjMatrix, i + 1, visited));
            }
        }
        return result;
    }
}

class TownStreet {
    int to;
    int weight;

    public TownStreet(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}