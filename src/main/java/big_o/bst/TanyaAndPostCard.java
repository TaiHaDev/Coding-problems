package big_o.bst;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TanyaAndPostCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        String newspaper = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : newspaper.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int yayCount = 0;
        int whoopCount = 0;
        for (char c : target.toCharArray()) {
            if (Character.isUpperCase(c)) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    yayCount++;
                } else if (map.containsKey(Character.toLowerCase(c))) {
                    map.put(c, map.get(Character.toLowerCase(c)) - 1);
                    whoopCount++;
                }
            } else {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    yayCount++;
                } else if (map.containsKey(Character.toUpperCase(c))) {
                    map.put(c, map.get(Character.toUpperCase(c)) - 1);
                    whoopCount++;
                }
            }
            if (map.getOrDefault(c, 0) == 0) map.remove(c);
        }
        System.out.println(yayCount + " " + whoopCount);
    }
}
