package big_o.bst;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TreePopulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline
        sc.nextLine(); // Consume the empty line

        while (t-- > 0) {
            TreeMap<String, Integer> treeMap = new TreeMap<>();
            int totalTrees = 0;

            while (sc.hasNextLine()) {
                String tree = sc.nextLine();
                if (tree.isEmpty()) {
                    break;
                }
                treeMap.put(tree, treeMap.getOrDefault(tree, 0) + 1);
                totalTrees++;
            }
            for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
                double percent = (double) entry.getValue() / totalTrees * 100;
                System.out.printf("%.4f", percent);
            }

            if (t > 0) {
                System.out.println();
            }
        }

        sc.close();
    }
}
