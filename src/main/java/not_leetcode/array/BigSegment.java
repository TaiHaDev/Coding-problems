package not_leetcode.array;

import java.util.Scanner;

public class BigSegment {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] segmentArr = new int[size][2];
        for (int i = 0; i < size; i++) {
            segmentArr[i] = new int[] {sc.nextInt(), sc.nextInt()};

        }

        int lower = Integer.MAX_VALUE, upper = Integer.MIN_VALUE;
        int result = -1;
        for (int i = 0; i < size; i++) {
            int[] cur = segmentArr[i];
            if (cur[0] <= lower && cur[1] >= upper) {
                lower = cur[0];
                upper = cur[1];
                result = i + 1;
            } else if (cur[0] < lower) {
                lower = cur[0];
                result = -1;
            } else if (cur[1] > upper) {
                upper = cur[1];
                result = -1;
            }
        }
        System.out.println(result);
    }
}
