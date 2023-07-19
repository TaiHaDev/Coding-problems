package big_o.bst;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MonkAndHistFriends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            long m = sc.nextLong();
            long n = sc.nextLong();
            Set<Long> set = new HashSet<>();
            for (int i = 0; i < m; i++) {
                set.add(sc.nextLong());
            }
            for (int i = 0; i < n; i++) {
                if (!set.add(sc.nextLong())) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
