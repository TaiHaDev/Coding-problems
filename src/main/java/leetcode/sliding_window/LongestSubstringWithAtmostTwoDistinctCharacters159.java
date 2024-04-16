package leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostTwoDistinctCharacters159 {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithAtmostTwoDistinctCharacters159().lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }
    public int lengthOfLongestSubstringTwoDistinct(String s) {
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
            while(countDistinct > 2) {
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
