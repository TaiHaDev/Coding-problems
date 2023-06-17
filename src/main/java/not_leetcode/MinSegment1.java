package not_leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinSegment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Map<Integer, Integer> occurrences = new HashMap<>();
        int left = 0, count = 0;
        int resultLeft = -2, resultRight = -2;

        for (int right = 0; right < n; right++) {
            occurrences.put(a[right], occurrences.getOrDefault(a[right], 0) + 1);
            if (occurrences.get(a[right]) == 1) {
                count++;
            }

            if ( occurrences.get(a[left]) > 1) {
                occurrences.put(a[left], occurrences.get(a[left]) - 1);
                if (occurrences.get(a[left]) == 0) {
                    count--;
                }
                left++;
            }
            if (count == k) {
                resultLeft = left;
                resultRight = right;
                break;
            }
        }
        System.out.println((resultLeft + 1) + " " + (resultRight + 1));
    }
}
