package leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class FindKLengthSubStringWithNoRepeatedCharacters1100 {
    public static void main(String[] args) {
        System.out.println(new FindKLengthSubStringWithNoRepeatedCharacters1100().numKLenSubstrNoRepeats("havefunonleetcode", 5));
    }
    public int numKLenSubstrNoRepeats(String s, int k) {
        Map<Character, Integer> map = new HashMap();
        int left = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            map.put(curChar, map.getOrDefault(curChar, 0) + 1);
            while(i - left + 1 > k || map.get(curChar) > 1) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            if (i - left + 1 == k) {
                res++;
            }
        }
        return res;
    }
}
