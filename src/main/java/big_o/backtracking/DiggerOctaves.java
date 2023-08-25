package big_o.backtracking;

import java.util.Scanner;
import java.util.TreeSet;

class Main {
    private static final int MAX_N = 10;
    private static final int dx[] = {1, -1, 0, 0};
    private static final int dy[] = {0, 0, -1, 1};

    private static String a[] = new String[MAX_N];
    private static int test, n, trace[] = new int[MAX_N];
    private static boolean visited[][] = new boolean[MAX_N][MAX_N];
    private static long f[] = new long[65];

    private static int cnt = 0;

    private static TreeSet<Long> S = new TreeSet<Long>();

    private static void DFS(int step, int x, int y) {
        visited[x][y] = true;
        trace[step] = x * n + y;

        if (step == 8) {
            long sum = 0;
            for (int i = 1; i <= 8; i++) {
                sum |= f[trace[i]];
            }
            cnt++;
            S.add(sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nxtx = x + dx[i];
            int nxty = y + dy[i];
            if (nxtx >= 0 && nxtx < n && nxty >= 0 && nxty < n && visited[nxtx][nxty] == false) {
                DFS(step + 1, nxtx, nxty);
                visited[nxtx][nxty] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        f[0] = 1;

        for (int i = 1; i < 64; i++) {
            f[i] = f[i - 1] << 1;
        }

        test = sc.nextInt();

        for (int t = 1; t <= test; t++) {
            n = sc.nextInt();
            cnt = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.next();
            }

            S.clear();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = false;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i].charAt(j) == '.') {
                        visited[i][j] = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == false) {
                        DFS(1, i, j);
                        visited[i][j] = false;
                    }
                }
            }

            System.out.println(S.size());
        }

        sc.close();
    }
}
