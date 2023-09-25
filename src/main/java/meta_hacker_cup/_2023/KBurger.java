package meta_hacker_cup._2023;

import java.util.Scanner;

public class KBurger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = 1;
        int n = sc.nextInt();
        while (n-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int k = sc.nextInt();
            int totalBuns = s * 2 + d * 2;
            int totalInside = s + d * 2;
            boolean res = true;
            if (k > totalInside || k + 1 > totalBuns) {
                res = false;
            }
            String out = "Case #" + c++ + ": ";
            if (res) {
                System.out.println(out + "YES");
            } else {
                System.out.println(out + "NO");
            }
        }
    }
}
