package big_o.dsu;

import java.util.*;
import java.io.*;

public class LostAndSurvive {

    static final int MAX_N = 100005;
    static int n, m;
    static int[] root = new int[MAX_N];
    static int[] cnt = new int[MAX_N];
    static int maxi = 0;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    static int findRoot(int u) {
        if (u == root[u]) {
            return u;
        }
        return root[u] = findRoot(root[u]);
    }

    static void unionSet(int u, int v) {
        int uu = findRoot(u);
        int vv = findRoot(v);

        if (uu != vv) {
            cnt[uu] += cnt[vv];
            root[vv] = uu;
            pq.add(new Pair(cnt[uu], uu));
            maxi = Math.max(maxi, cnt[uu]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);

        for (int i = 1; i <= n; i++) {
            cnt[i] = 1;
            root[i] = i;
            pq.add(new Pair(1, i));
        }

        maxi = 1;

        for (int i = 1; i <= m; i++) {
            tokens = br.readLine().split(" ");
            int u = Integer.parseInt(tokens[0]);
            int v = Integer.parseInt(tokens[1]);

            unionSet(u, v);

            while (true) {
                Pair tmp = pq.peek();
                int r = findRoot(tmp.second);
                if (r != tmp.second || cnt[r] != tmp.first) {
                    pq.poll();
                } else {
                    break;
                }
            }

            System.out.println(maxi - pq.peek().first);
        }
    }
}

class Pair implements Comparable<Pair> {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.first != o.first) {
            return Integer.compare(this.first, o.first);
        }
        return Integer.compare(this.second, o.second);
    }
}