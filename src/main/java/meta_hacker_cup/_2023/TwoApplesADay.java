package meta_hacker_cup._2023;

import java.util.Arrays;
import java.util.Scanner;

public class TwoApplesADay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        int caseNo = 1;

        while (t-- > 0) {
            System.out.print("Case #" + caseNo++ + ": ");
            int days = sc.nextInt();
            int[] weights = new int[2 * days - 1];

            for (int i = 0; i < weights.length; i++) {
                weights[i] = sc.nextInt();
            }

            if (days == 1) {
                System.out.println(1);
                continue;
            }

            Arrays.sort(weights);

            int totalWeight = 0;
            for (int weight : weights) {
                totalWeight += weight;
            }

            int minAppleWeight = Integer.MAX_VALUE;

            for (int i = 0; i < weights.length; i++) {
                int remainingSum = totalWeight - weights[i];
                int dailyWeight = remainingSum / days;

                int missingApple = dailyWeight * days - remainingSum;
                if (missingApple > 0 && remainingSum + missingApple == dailyWeight * days) {
                    minAppleWeight = Math.min(minAppleWeight, missingApple);
                }
            }

            if (minAppleWeight == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(minAppleWeight);
            }
        }
    }
}
