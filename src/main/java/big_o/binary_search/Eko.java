package big_o.binary_search;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Eko {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int wanted = sc.nextInt();
        Integer[] trees = new Integer[total];
        for (int i = 0; i < total; i++) {
            trees[i] = sc.nextInt();
        }
        int l = Collections.min(Arrays.asList(trees)), r = Collections.max(Arrays.asList(trees));
        int res = 0;
        while (l <= r) {
            int h = (l + r) >> 1;
            int amount = getAmount(trees, h, wanted);
            if (amount == -1) {
                r = h - 1;
            } else {
                res = h;
                l = h + 1;
            }
        }
        System.out.println(res);
    }

    private static int getAmount(Integer[] trees, int h, int wanted) {
        int result = 0;
        for (int tree : trees) {
            if (tree > h) {
                result += tree - h;
                if (result > wanted) return 1;
            }
        }
        return result == wanted ? 0 : -1;
    }
}
