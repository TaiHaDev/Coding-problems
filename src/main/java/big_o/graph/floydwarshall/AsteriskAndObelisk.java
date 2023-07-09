package big_o.graph.floydwarshall;

import java.util.*;
import java.io.*;

public class AsteriskAndObelisk {
    static final int INF = 1000000000;
    static int[][] dist;
    static int[] feastCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            if (C == 0 && S == 0 && Q == 0)
                break;

            dist = new int[C][C];
            for (int i = 0; i < C; i++)
                Arrays.fill(dist[i], INF);

            feastCost = new int[C];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < C; i++) {
                feastCost[i] = Integer.parseInt(st.nextToken());
                dist[i][i] = feastCost[i];
            }

            for (int i = 0; i < S; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                int w = Integer.parseInt(st.nextToken());
                dist[u][v] = dist[v][u] = Math.max(w, Math.max(feastCost[u], feastCost[v]));
            }

            for (int k = 0; k < C; k++)
                for (int i = 0; i < C; i++)
                    for (int j = 0; j < C; j++)
                        dist[i][j] = Math.min(dist[i][j], Math.max(dist[i][k], dist[k][j]));

            if (t != 1)
                pw.println();
            pw.println("Case #" + t++);
            for (int q = 0; q < Q; q++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                if (dist[u][v] == INF)
                    pw.println("-1");
                else
                    pw.println(dist[u][v]);
            }
        }
        pw.close();
    }
}
