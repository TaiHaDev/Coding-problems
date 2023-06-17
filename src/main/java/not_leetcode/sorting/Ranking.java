package not_leetcode.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ranking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int[] points = new int[total];

        for (int i = 0; i < total; i++) {
            points[i] = sc.nextInt();
        }
        int[] inputs = points.clone();
        Map<Integer, Integer> pointToRank = new HashMap<>();
        Arrays.sort(points);
        int last = points[total - 1];
        int rank = 1;
        pointToRank.put(points[total - 1], 1);
        for (int i = total - 2; i >= 0; i--) {
            rank++;
            int cur = points[i];
            if (cur != last) {
                last = points[i];
                pointToRank.put(points[i], rank);
            }
        }
        for (int num : inputs) {
            System.out.print(pointToRank.get(num) + " ");
        }
    }
}
