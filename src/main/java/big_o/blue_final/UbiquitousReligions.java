package big_o.blue_final;

import java.util.Scanner;

public class UbiquitousReligions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = 1;
        while (true) {
            int vertices = sc.nextInt();
            int edges = sc.nextInt();
            if (vertices == 0 && edges == 0) break;
            DSU dsu = new DSU(vertices);
            for (int i = 0; i < edges; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                dsu.joinSet(u, v);
            }
            int result = 0;
            for (int i = 0; i < vertices; i++) {
                if (dsu.parents[i] == i) {
                    result++;
                }
            }
            System.out.println("Case " + c++ + ": " + result);
        }
    }
}





class DSU {
    public int[] parents;
    public int[] ranks;

    public DSU(int len) {
        this.parents = new int[len];
        this.ranks = new int[len];
        init();
    }

    private void init() {
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            ranks[i] = 0;
        }
    }

    private int findRoot(int node) {
        if(parents[node] != node) {
            parents[node] = findRoot(parents[node]);
        }
        return parents[node];
    }
    public void joinSet(int u , int v) {
        int uRoot = findRoot(u);
        int vRoot = findRoot(v);
        if (ranks[uRoot] > ranks[vRoot]) {
            parents[vRoot] = uRoot;
        } else if (ranks[uRoot] < ranks[vRoot]) {
            parents[uRoot] = vRoot;
        } else {
            parents[uRoot] = vRoot;
            ranks[vRoot]++;
        }
    }

}
