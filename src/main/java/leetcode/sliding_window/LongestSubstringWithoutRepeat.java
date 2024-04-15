package leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeat {
    // sliding window to be revisited
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeat().lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int left = 0;
        int lengthOfLongestSubstring = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left))- 1);
                left++;
            }
            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, i - left + 1);
        }
        return lengthOfLongestSubstring;
    }

}
