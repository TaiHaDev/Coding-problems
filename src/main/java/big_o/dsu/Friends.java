package big_o.dsu;

import java.util.Scanner;

public class Friends {
    public static int[] parent;
    public static int[] rank;
    public static int[] sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        while (total-- > 0) {
            int vertices = sc.nextInt();
            int edges = sc.nextInt();
            parent = new int[vertices];
            rank = new int[vertices];
            sum = new int[vertices];
            makeSet();
            for (int i = 0; i < edges; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                unionSet(u,v);
            }
            int maxFriends = 0;
            for (int n : sum) {
                maxFriends = Math.max(maxFriends, n);
            }
            System.out.println(maxFriends);
        }
    }
    private static void makeSet() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
            sum[i] = 1;
        }
    }
    private static int findSet(int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = findSet(parent[vertex]);
        }
        return parent[vertex];
    }



    private static void unionSet(int u, int v) {
        int rootU = findSet(u);
        int rootV = findSet(v);
        if (rootV == rootU) return;
        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
            sum[rootV] += sum[rootU];

        } else if (rank[rootV] < rank[rootU]) {
            parent[rootV] = rootU;
            sum[rootU] += sum[rootV];

        } else {
            parent[rootU] = rootV;
            rank[rootV]++;
            sum[rootV] += sum[rootU];
        }
    }

}
