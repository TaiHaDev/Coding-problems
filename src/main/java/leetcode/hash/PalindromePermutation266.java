package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation266 {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap();
        int oddCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            int charCount = map.getOrDefault(curChar, 0);
            if (charCount > 0 && charCount % 2 != 0) {
                oddCount--;
            } else {
                oddCount++;
            }
            charCount++;
            map.put(curChar, charCount);
        }
        return oddCount == 0 || (s.length() % 2 == 1 && oddCount == 1);
    }
}
