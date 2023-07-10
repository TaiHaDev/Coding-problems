package big_o.binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class FindMarble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = 1;
        while (true) {
            int total = sc.nextInt();
            int queries = sc.nextInt();
            if (total == 0 && queries == 0) break;
            int[] marbles = new int[total];
            for (int i = 0; i < total; i++) {
                marbles[i] = sc.nextInt();
            }
            Arrays.sort(marbles);
            System.out.println("CASE# " + c++ + ":");
            for (int i = 0; i < queries; i++) {
                int target = sc.nextInt();
                int res = binarySearch(marbles, target) ;
                System.out.println(res == -1 ? target + " not found" : target + " found at " + (res + 1));
            }
        }

    }

    private static int binarySearch(int[] marbles, int target) {
        int l = 0, r = marbles.length - 1;
        int res = -1;
        while (l <= r) {
            int middle = (l + r + 1) >> 1;
            if (marbles[middle] < target) {
                l = middle + 1;
            } else {
                if (marbles[middle] == target) {
                    res = middle;
                }
                r = middle - 1;
            }
        }
        return res;
    }
}
