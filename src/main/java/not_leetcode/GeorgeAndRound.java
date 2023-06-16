package not_leetcode;

import java.util.Scanner;

public class GeorgeAndRound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int expected = sc.nextInt();
        int actual = sc.nextInt();
        int[] expectedNums = new int[expected];
        int[] actualNums = new int[actual];
        for (int i = 0; i < expected; i++) {
            expectedNums[i] = sc.nextInt();
        }
        for (int i = 0; i < actual; i++) {
            actualNums[i] = sc.nextInt();
        }
        int last = 0;
        for (int i = 0; i < expected; i++) {
            boolean done = false;
            for (int j = last; j < actual; j++) {
                if (expectedNums[i] <= actualNums[j]) {
                    last += j + 1;
                    break;
                }
                if (j == actual - 1) {
                    System.out.println(expected - i);
                    done = true;
                    break;
                }
            }
            if (done) break;

        }
    }
}
