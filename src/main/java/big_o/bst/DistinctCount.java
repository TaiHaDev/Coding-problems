package big_o.bst;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DistinctCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int total = sc.nextInt();
            int distinctNum = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < total; i++) {
                set.add(sc.nextInt());
            }
            if (set.size() < distinctNum) {
                System.out.println("Bad");
            } else if (set.size() > distinctNum) {
                System.out.println("Average");
            } else {
                System.out.println("Good");
            }

        }
    }
}
