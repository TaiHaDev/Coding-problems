package big_o.prim;

import java.util.Arrays;
import java.util.Scanner;

public class ConnectTheCampus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int[][] buildings = new int[vertices][2];
        for (int i = 0; i < vertices; i++) {
            buildings[i] = new int[] {sc.nextInt(), sc.nextInt()};
        }
        double[] dist = new double[vertices];
        boolean[] visited = new boolean[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        int cables = sc.nextInt();
        for (int i = 0; i < cables; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int[] b1 = buildings[u - 1];
            int[] b2 = buildings[v - 1];
            dist[u] = distance(b1[0], b1[1], b2[0], b2[1]);
            dist[v] = 0;
            visited[u] = true;
            visited[v] = true;
        }
    }

    private static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2- x1, 2) + Math.pow(y2 - y1, 2));
    }
}
