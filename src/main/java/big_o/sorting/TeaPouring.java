package big_o.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class TeaPouring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int friends = sc.nextInt();
        int volume = sc.nextInt();
        int[] cups = new int[friends * 2];
        for (int i = 0; i < friends * 2; i++) {
            cups[i] = sc.nextInt();
        }
        double bestAmount = (double) volume / (friends + friends * 2);
        Arrays.sort(cups);
        double girlMinVolume = cups[0];
        double boyMinVolume = cups[friends];
        if (bestAmount < girlMinVolume && bestAmount * 2 < boyMinVolume) {
            System.out.println(volume);
            return;
        }
        boyMinVolume = Math.min(boyMinVolume, girlMinVolume * 2);
        girlMinVolume = Math.min(boyMinVolume / 2, girlMinVolume);
        System.out.println(boyMinVolume * friends + girlMinVolume * friends);
    }
}
