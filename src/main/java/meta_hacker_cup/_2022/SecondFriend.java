package meta_hacker_cup._2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SecondFriend {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int c = 1;
        while (n-- > 0) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            char[][] grid = new char[row][col];
            boolean isTreeExisted = false;
            for (int i = 0; i < row; i++) {
                String curLine = sc.next();
                for (int j = 0; j < col; j++) {
                    grid[i][j] = curLine.charAt(j);
                    if (grid[i][j] == '^') {
                        isTreeExisted = true;
                    }
                }
            }
            String out = "Case #" + c++ + ": ";
            if (solve(grid, isTreeExisted)) {
                System.out.println(out + "Possible");
                System.out.println(Arrays.deepToString(grid));
            } else {
                System.out.println(out + "Impossible");
            }
        }
    }

    private static boolean solve(char[][] grid, boolean isTreeExisted) {
        return (grid.length != 1 && grid[0].length != 1) || !isTreeExisted;
    }



    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {}
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
