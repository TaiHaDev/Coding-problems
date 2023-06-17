package not_leetcode;

import java.util.Scanner;

public class Wrath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int[] claws = new int[total];
        for (int i = 0; i < total; i++) {
            claws[i] = sc.nextInt();
        }
        int count = 1;
        int until = total - 1 - claws[total - 1];
        for (int i = total - 2; i >= 0; i--) {
            int cur = claws[i];
            if (i < until) count++;
            until = Math.min(i - cur, until);
        }
        System.out.println(count);
    }

}
