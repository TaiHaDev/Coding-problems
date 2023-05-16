package array;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagram49 {
    public static void main(String[] args) {
        String[] s = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(s));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] charCount = new int[26];
            for (char c : strs[i].toCharArray()) {
                charCount[c - 'a'] += 1;
            }
            List<String> li = map.getOrDefault(Arrays.toString(charCount), new ArrayList<>());
            li.add(strs[i]);
            map.put(Arrays.toString(charCount), li);
        }
        return map.values().stream().toList();
    }

}
