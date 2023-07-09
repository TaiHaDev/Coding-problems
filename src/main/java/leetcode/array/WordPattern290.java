package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {
    public static void main(String[] args) {
        System.out.println(new WordPattern290().wordPattern("abba", "dog cat cat fish"));
    }
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap();
        Map<String, Character> revMap = new HashMap();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(words[i])) {
                    return false;
                }
            }
            map.put(c, words[i]);
            if (revMap.containsKey(words[i])) {
                if (!(revMap.get(words[i]) == c)) {
                    return false;
                }
            }
            revMap.put(words[i], c);
        }
        return true;
    }
}
