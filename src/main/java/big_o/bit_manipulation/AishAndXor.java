package big_o.bit_manipulation;

import java.util.Scanner;

public class AishAndXor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int[] sum0 = new int[total];
        int[] sumXor = new int[total];
        sum0[0] = sc.nextInt();
        sumXor[0] = sum0[0];
        for (int i = 1; i < total; i++) {
            int cur = sc.nextInt();
            sum0[i] = sum0[i-1] + (cur == 0 ? 1 : 0);
            sumXor[i] = sumXor[i-1] ^ cur;
        }
        int queries = sc.nextInt();
        while(queries-->0) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            int res;
            int count;
            if (l == 0) {
                res = sumXor[r];
                count = sum0[r];
            } else {
                res = sumXor[r] - sumXor[l - 1];
                count = sum0[r] ^ sum0[l - 1];
            }
            System.out.println(res + " " + count);
        }
    }
}
