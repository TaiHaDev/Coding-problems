package big_o.bit_manipulation;

import java.util.Scanner;

public class Dishes {
    public static int Count1(int x) {
        int cnt = 0;
        while (x != 0) {
            if ((x & 1) != 0) ++cnt;
            x >>= 1;
        }
        return cnt;
    }

    public static void main(String ar[]){
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        while (T-- > 0){
            int n, k;
            n = sc.nextInt();
            k = sc.nextInt();
            String[] arr = new String[n];
            sc.nextLine();
            for (int i =0; i < n; i++) {
                arr[i] = sc.nextLine();
            }

            int max_value = 1 << k;
            int ans = n;
            for (int i =1; i < max_value; i++) {
                boolean satisfied_choice = true;
                for (int v = 0; v < n; v++) {
                    boolean flag = false;
                    for (int u = 0; u < k; u++) {
                        if (arr[v].charAt(u) == '1' && ( i & (1 << u) ) != 0) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        satisfied_choice = false;
                        break;
                    }
                }
                if (satisfied_choice) {
                    ans = Math.min(ans, Count1(i));
                }
            }
            System.out.println(ans);
        }

        sc.close();
    }
}
