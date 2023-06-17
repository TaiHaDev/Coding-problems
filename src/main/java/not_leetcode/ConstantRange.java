package not_leetcode;

import java.util.Scanner;

public class ConstantRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();

        int result = findLongestConstantRange(n, a);
        System.out.println(result);
    }

    public static int findLongestConstantRange(int n, int[] a) {
        int maxRangeLength = 0;
        int rangeStart = 0;
        int rangeEnd = 0;
        int minValue = a[0];
        int maxValue = a[0];

        for (int i = 1; i < n; i++) {
            if (a[i] > maxValue) {
                maxValue = a[i];
            }
            if (a[i] < minValue) {
                minValue = a[i];
            }

            if (maxValue - minValue > 1) {
                int rangeLength = rangeEnd - rangeStart + 1;
                if (rangeLength > maxRangeLength) {
                    maxRangeLength = rangeLength;
                }
                rangeStart = i;
                rangeEnd = i;
                maxValue = a[i];
                minValue = a[i];
            } else {
                rangeEnd = i;
            }
        }

        int rangeLength = rangeEnd - rangeStart + 1;
        if (rangeLength > maxRangeLength) {
            maxRangeLength = rangeLength;
        }

        return maxRangeLength;
    }
}
