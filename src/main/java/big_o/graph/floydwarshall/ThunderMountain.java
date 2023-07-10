package big_o.graph.floydwarshall;

import java.util.Scanner;

public class ThunderMountain {
    static double INF = 1e9;
    static double EPS = 1e-9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int t = 1; t <= N; t++) {
            int n = sc.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for(int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }

            double[][] dist = new double[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    dist[i][j] = INF;
                }
                dist[i][i] = 0;
            }

            for(int i = 0; i < n; i++) {
                for(int j = i+1; j < n; j++) {
                    double d = Math.hypot(x[i] - x[j], y[i] - y[j]);
                    if(d < 10 + EPS) {
                        dist[i][j] = dist[j][i] = d;
                    }
                }
            }

            for(int k = 0; k < n; k++) {
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }

            double maxDist = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                        maxDist = Math.max(maxDist, dist[i][j]);
                }
            }

            System.out.println("Case #" + t + ":");
            if(maxDist == INF) {
                System.out.println("Send Kurdy");
            } else {
                System.out.format("%.4f%n", maxDist);
            }
            System.out.println();
        }
    }
}
