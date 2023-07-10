package big_o.binary_search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pizzamania {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int total = sc.nextInt();
            int piz = sc.nextInt();
            int[] moneys = new int[total];
            int result = 0;
            Map<Integer, Integer> twoSums = new HashMap<>();
            for (int i = 0; i < total; i++) {
                int cur = sc.nextInt();
                if (twoSums.containsKey(cur)) {
                    result++;
                    twoSums.put(cur, twoSums.get(cur) - 1);
                    if (twoSums.get(cur) == 0) twoSums.remove(cur);
                } else {
                    int left = piz - cur;
                    twoSums.put(left, twoSums.getOrDefault(left, 0) + 1);
                }
            }
            System.out.println(result);
        }
    }
}
