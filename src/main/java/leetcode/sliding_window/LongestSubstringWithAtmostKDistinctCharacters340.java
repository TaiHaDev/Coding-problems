package leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostKDistinctCharacters340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int res = 0;
        Map<Character, Integer> countMap = new HashMap();
        int left = 0;
        int countDistinct = 0;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            countMap.put(curChar, countMap.getOrDefault(curChar, 0) + 1);
            if (countMap.get(curChar) == 1) {
                countDistinct++;
            }
            while(countDistinct > k) {
                int curCount = countMap.get(s.charAt(left)) - 1;
                if (curCount == 0) {
                    countDistinct--;
                }
                countMap.put(s.charAt(left), curCount);
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
