package big_o.dsu;

import java.util.Scanner;

public class GraphConnectivity {
    private static int[] parents;
    private static int[] ranks;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        sc.nextLine();
        while (n-- > 0) {
            int vertices = sc.nextLine().charAt(0) - 'A' + 1;
            parents = new int[vertices];
            ranks = new int[vertices];
            makeSet();
            while (sc.hasNextLine()) {
                String cur = sc.nextLine();
                if (cur.isEmpty()) break;
                int u = cur.charAt(0) - 'A';
                int v = cur.charAt(1) - 'A';
                if (u != v) {
                    vertices--;
                    unionSet(u, v);
                }
            }


            System.out.println(vertices);
            if (n > 0) System.out.println();
        }
    }

    private static void makeSet() {
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            ranks[i] = 0;
        }
    }

    private static int findParent(int start) {
        if (start != parents[start]) {
            parents[start] = findParent(parents[start]);
        }
        return parents[start];
    }

    private static void unionSet(int u, int v) {
        int uParent = findParent(u);
        int vParent = findParent(v);
        if (ranks[uParent] < ranks[vParent]) {
            parents[uParent] = vParent;
        } else if (ranks[uParent] > ranks[vParent]) {
            parents[vParent] = uParent;
        } else {
            parents[uParent] = vParent;
            ranks[vParent]++;
        }
    }
}