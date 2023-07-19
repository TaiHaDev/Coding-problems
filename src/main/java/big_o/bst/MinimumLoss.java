package big_o.bst;

import java.util.*;



public class MinimumLoss {
    /**
     * Key idea:
     * - finding the least higher number before using treeset
     * - by doing the above, we can add and find one by one
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long minLoss = Long.MAX_VALUE;
        TreeSet<Long> set = new TreeSet<>();
        set.add(sc.nextLong());
        for (int i = 1; i < n; i++) {
            long cur = sc.nextLong();
            Long last = set.ceiling(cur + 1);
            if (last != null) {
                minLoss = Math.min(minLoss, last - cur);
            }
            set.add(cur);
        }
        System.out.println(minLoss);
    }
}
