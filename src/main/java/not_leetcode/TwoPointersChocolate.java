package not_leetcode;

import java.util.Scanner;

public class TwoPointersChocolate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int[] times = new int[total];
        for (int i = 0; i < total; i++) {
            times[i] = sc.nextInt();
        }

        int left = 0, right = total - 1;
        int aliceTime = 0, bobTime = 0;
        int aliceCount = 0, bobCount = 0;

        while (left <= right) {
            if (aliceTime + times[left] <= bobTime + times[right]) {
                aliceTime += times[left];
                aliceCount++;
                left++;
            } else {
                bobTime += times[right];
                bobCount++;
                right--;
            }
        }

        System.out.println(aliceCount + " " + bobCount);
    }
}
