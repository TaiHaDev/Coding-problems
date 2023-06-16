package not_leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SuffixStructures {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String w1 = sc.nextLine();
        String w2 = sc.nextLine();
        boolean isAutomaton = isAutomaton(w1, w2);
        Map<Character, Integer> countW1 = countChar(w1);
        Map<Character, Integer> countW2 = countChar(w2);
        boolean isArray = countW1.equals(countW2);
        if (isAutomaton) {
            System.out.println("automaton");
        } else if (isArray) {
            System.out.println("array");
        } else if (isBoth(countW1, countW2)) {
            System.out.println("both");
        } else {
            System.out.println("need tree");
        }
    }
    public static boolean isAutomaton(String a, String b) {
        int lastIndex = 0;
        for (char c : b.toCharArray()) {
            lastIndex = a.indexOf(c, lastIndex);
            if (lastIndex == -1) return false;
            lastIndex++;
        }
        return true;
    }
    public static Map<Character, Integer> countChar(String str) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : str.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result;
    }
    public static boolean isBoth(Map<Character, Integer> countW1, Map<Character, Integer> countW2) {
        for (var entrySet : countW2.entrySet()) {
            if (entrySet.getValue() > countW1.getOrDefault(entrySet.getKey(), 0)) {
                return false;
            }
        }
        return true;
    }

}
