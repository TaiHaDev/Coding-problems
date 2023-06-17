package not_leetcode.sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BuildingTowers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int[] nums = new int[total];
        for (int i = 0; i < total; i++) {
            nums[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        int highest = 0;
        for (int i = 0; i < total; i++) {
            int cur = nums[i];
            int towerSize = map.getOrDefault(cur, 0) + 1;
            highest = Math.max(highest, towerSize);
            map.put(cur, towerSize);
        }
        System.out.println(highest + " " + map.size());
    }
}
