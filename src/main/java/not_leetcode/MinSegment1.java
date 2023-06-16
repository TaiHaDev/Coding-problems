package not_leetcode;

import java.util.*;

public class MinSegment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Map<Integer, Integer> orderedMap = new LinkedHashMap<>(n, 0.75f, true);
        for (int i = 0; i < n; i++) {
            if (orderedMap.size() == k) break;
            orderedMap.put(sc.nextInt(), i);
        }
        if (orderedMap.size() < k) System.out.println("-1 -1");
        int start = -1;
        int end = -1;
        int count = 0;

        for (var entry : orderedMap.entrySet()) {
            count++;
            if (start == -1) {
                start = entry.getValue();
            }
            if (count == k) {
                end = entry.getValue();
            }
        }
        System.out.println(start+ 1 + " " + (end + 1));
    }
}
