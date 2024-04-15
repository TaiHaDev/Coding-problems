package leetcode.hash;

import java.util.*;

public class SentenceFamilarity734 {
    public static void main(String[] args) {
    }
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        Map<String, Set<String>> map = new HashMap();
        for (List<String> pair : similarPairs) {
            map.computeIfAbsent(pair.get(0), k -> new HashSet<>()).add(pair.get(1));
            map.computeIfAbsent(pair.get(1), k -> new HashSet<>()).add(pair.get(0));

        }
        for (int i = 0; i < sentence1.length; i++) {
            if (!sentence1[i].equals(sentence2[i]) && !map.getOrDefault(sentence1[i], new HashSet<>()).contains(sentence2[i])) {
                return false;
            }
        }
        return true;
    }
}
