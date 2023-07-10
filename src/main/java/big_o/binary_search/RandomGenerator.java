package big_o.binary_search;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RandomGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int diff = sc.nextInt();
        Set<Integer> twoSum = new HashSet<>();
        int result = 0;
        for (int i = 0; i < total; i++) {
            int cur = sc.nextInt();
            if (twoSum.contains(cur + diff)) {
                result++;
            }
            if (twoSum.contains(cur - diff)){
                result++;
            }

            twoSum.add(cur);
        }
        System.out.println(result);
    }
}
