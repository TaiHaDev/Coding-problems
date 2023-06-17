package not_leetcode.array;


import java.util.Scanner;

public class ConstantRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        int n = scanner.nextInt();
        int[] dataPoints = new int[n];
        for (int i = 0; i < n; i++) {
            dataPoints[i] = scanner.nextInt();
        }

        // Frequency table to keep track of the occurrences
        int[] freq = new int[100001];
        int left = 0, maxLen = 0;
        int maxVal = dataPoints[0], minVal = dataPoints[0];

        // Sliding window with two pointers
        for (int right = 0; right < n; right++) {
            int current = dataPoints[right];
            freq[current]++;

            maxVal = Math.max(maxVal, current);
            minVal = Math.min(minVal, current);

            while (maxVal - minVal > 1) {
                freq[dataPoints[left]]--;
                if (freq[dataPoints[left]] == 0 && dataPoints[left] == maxVal) {
                    maxVal--;
                }
                if (freq[dataPoints[left]] == 0 && dataPoints[left] == minVal) {
                    minVal++;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        // Output the result
        System.out.println(maxLen);
    }
}