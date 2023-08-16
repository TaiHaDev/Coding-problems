package big_o.blue_final;

import java.util.Scanner;

public class LearningLanguages {
    private static int[] parents;
    private static int[] ranks;
    private static int[] mem;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int employees = sc.nextInt();
        int languages = sc.nextInt();
        parents = new int[employees + 1];
        ranks = new int[employees + 1];
        mem = new int[languages + 1];
        int zeroCount = 0;
        init();
        for (int i = 1; i <= employees; i++) {
            int know = sc.nextInt();
            if (know == 0) zeroCount++;
            while (know-- > 0) {
                int lan = sc.nextInt();
                if (mem[lan] != 0) {
                    join(mem[lan], i);
                } else {
                    mem[lan] = i;
                }
            }
        }
        if (zeroCount == employees) {
            System.out.println(zeroCount);
            return;
        }
        int res = -1;
        for (int i = 1; i <= employees; i++) {
            if (parents[i] == i) {
                res++;
            }
        }
        System.out.println(res);

    }
    private static void init() {
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            ranks[i] = 0;
        }
    }
    private static int findParent(int node) {
        if (node != parents[node]) {
            parents[node] = findParent(parents[node]);
        }
        return parents[node];
    }
    private static void join(int u, int v) {
        int uParent = findParent(u);
        int vParent = findParent(v);
        if (ranks[uParent] < ranks[vParent]) {
            parents[uParent] = vParent;
        } else if (ranks[uParent] > ranks[vParent]) {
            parents[vParent] = uParent;
        } else {
            parents[uParent] = vParent;
            ranks[uParent]++;
        }
    }
}
