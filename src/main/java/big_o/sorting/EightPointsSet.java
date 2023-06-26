package big_o.sorting;

import java.util.*;

public class EightPointsSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> xs = new HashSet<>();
        Set<Integer> ys = new HashSet<>();
        Set<List<Integer>> pairs = new HashSet<>();
        for (int i = 0; i < 8; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            pairs.add(List.of(x, y));
            xs.add(x);
            ys.add(y);
        }
        if (xs.size() != 3 || ys.size() != 3) {
            System.out.println("ugly");
            return;
        }
        List<Integer> xSorted = new ArrayList<>(xs);
        List<Integer> ySorted = new ArrayList<>(ys);
        Collections.sort(xSorted);
        Collections.sort(ySorted);
        if (!pairs.add(List.of(xSorted.get(1), ySorted.get(1)))) {
            System.out.println("ugly");
            return;
        }
        for (int x : xSorted) {
            for (int y : ySorted) {
                if (!pairs.contains(List.of(x,y))) {
                    System.out.println("ugly");
                    return;
                }
            }
        }
        System.out.println("respectable");
    }
}
