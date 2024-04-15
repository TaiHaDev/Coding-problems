package leetcode.array;

import java.util.*;

public class GroupAnagram49 {
    public static void main(String[] args) {
        String[] s = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(s));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            char[] sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            map.putIfAbsent(Arrays.toString(sorted), new ArrayList());
            map.get(Arrays.toString(sorted)).add(strs[i]);
        }
        return map.values().stream().toList();
    }

}
