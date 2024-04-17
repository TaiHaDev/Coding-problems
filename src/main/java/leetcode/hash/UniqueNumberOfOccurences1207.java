package leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurences1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurences = new HashMap<>();

        for (int num : arr) {
            occurences.put(num, occurences.getOrDefault(num, 0) + 1);
        }

        Set<Integer> occSet = new HashSet<>(occurences.values());

        if (occSet.size() == occurences.size()){
            return true;
        } else {
            return false;
        }

    }
}
