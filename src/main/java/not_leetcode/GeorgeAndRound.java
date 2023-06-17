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
        int count = expected;
        for (int i = 0; i < expected; i++) {
            for (int j = last; j < actual; j++) {
                if (expectedNums[i] <= actualNums[j]) {
                    count--;
                    last = j + 1;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}