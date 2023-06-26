package big_o.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Chores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int older = sc.nextInt();
        int younger = sc.nextInt();
        int[] works = new int[total];
        for (int i = 0; i < total; i++) {
            works[i] = sc.nextInt();
        }
        Arrays.sort(works);
        System.out.println(works[younger] - works[younger - 1]);
    }
}
