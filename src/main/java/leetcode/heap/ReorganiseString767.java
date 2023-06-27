package leetcode.heap;

import java.util.*;

public class ReorganiseString767 {
    public static void main(String[] args) {
        System.out.println(new ReorganiseString767().reorganizeString("aab"));
    }
    public String reorganizeString(String s) {
        char[] result = new char[s.length()];
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        int max = 0;
        char letter = ' ';
        for (var entry : count.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                letter = entry.getKey();
            }
        }
        count.remove(letter);
        if (max < s.length() / 2) return " ";
        int index = 0;
        for (int i = 0; i < max; i++) {
            result[index] = letter;
            index += 2;
        }
        for (char c : count.keySet()) {
            for (int i = 0; i < count.get(c); i++) {
                if (index >= s.length()) {
                    index = 1;
                }
                result[index] = c;
                index += 2;
            }
        }
        return new String(result);
    }
}
