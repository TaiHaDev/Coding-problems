package meta_hacker_cup._2023;

import java.util.Scanner;

public class KBurger2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = 1;
        int n = sc.nextInt();
        while (n-- > 0) {
            long s = sc.nextLong();
            long d = sc.nextLong();
            long max = sc.nextLong();
            long res = 0;
            if (d >= s * 2) {
                res = max / s;
            } else {
                res = max / d * 2 - 1;
                long leftOver = max % d;
                if (res < 0) res = 0;
                if (res == 0 && leftOver >= s) {
                    res++;
                } else if (res > 0 && leftOver >= s) {
                    res+=2;
                }
        }
            System.out.println("Case #" + c++ + ": " + res);
    }
}}
