package leetcode.array;

import java.util.*;

public class FindAllAnagramsInAString438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        int[] sArray = new int[27];
        int[] pArray = new int[27];
        int start = 0;
        for (char c : p.toCharArray()) {
            sArray[c - 'a']++;
        }
        for (int end = 0; end < s.length(); end++) {
            pArray[s.charAt(end) - 'a']++;
            if (end - start == p.length()) {
                pArray[s.charAt(start) - 'a']--;
                start++;
            }
            if (Arrays.equals(sArray, pArray)) {
                result.add(start);
            }
        }
        return result;
    }
}
