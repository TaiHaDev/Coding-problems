package meta_hacker_cup._2023;

import java.util.Scanner;

public class DimSumDelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = 1;
        int n = sc.nextInt();
        while (n-- > 0) {
            long row = sc.nextLong();
            long col = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();
            System.out.print("Case #" + c++ + ": ");
            if (row > col) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
