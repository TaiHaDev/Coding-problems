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
        int count = expected;
        int expectIndex = 0, actualIndex = 0;
        while(expectIndex < expected && actualIndex < actual) {
            if (expectedNums[expectIndex] <= actualNums[actualIndex]) {
                expectIndex++;
                actualIndex++;
                count--;
            } else {
                actualIndex++;
            }
        }
        System.out.println(count);
    }
}