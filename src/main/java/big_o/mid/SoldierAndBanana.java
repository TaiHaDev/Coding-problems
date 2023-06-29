package big_o.mid;

import java.util.Scanner;

public class SoldierAndBanana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long start = sc.nextInt();
        long have = sc.nextInt();
        long target = sc.nextInt();
        long result = target * (target + 1) / 2 * start - have;
        System.out.println(result < 0 ? 0 : result);
    }
}
