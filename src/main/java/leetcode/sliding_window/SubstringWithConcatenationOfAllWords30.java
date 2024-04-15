package leetcode.sliding_window;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords30 {
    public static void main(String[] args) {
        System.out.println(new SubstringWithConcatenationOfAllWords30().findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        Map<String, Integer> map = new HashMap();
        Map<String, Integer> wordsMap = new HashMap<>();
        int left = 0;
        for (String string : words) {
            map.put(string, 0);
            wordsMap.put(string, wordsMap.getOrDefault(string, 0) + 1);
        }
        List<Integer> res = new LinkedList();
        for (int i = 0; i + wordLen <= s.length(); i++) {
            String curWord = s.substring(i, i + wordLen);
            if (map.containsKey(curWord)) {
                map.put(curWord, map.get(curWord) + 1);
                while(map.get(curWord) > wordsMap.get(curWord)) {
                    String firstWord = s.substring(left, left + wordLen);
                    map.put(firstWord, map.get(firstWord) - 1);
                    left += wordLen;
                }
                if (!wordsMap.equals(map)) continue;
                res.add(left);
                String firstWord = s.substring(left, left + wordLen);
                map.put(firstWord, map.get(firstWord) - 1);
                left += wordLen;

            } else {
                for (int j = 0; j < words.length; j++) {
                    map.put(words[j], 0);
                }
                left = i + 1;
            }
        }
        return res;
    }
}
