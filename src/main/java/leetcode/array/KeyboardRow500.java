package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow500 {
    public String[] findWords(String[] words) {
        int[] mark = new int[26];
        List<String> result = new ArrayList();
        for (char c : "qwertyuiop".toCharArray()) {
            mark[c - 'a'] = 1;
        }
        for (char c : "asdfghjkl".toCharArray()) {
            mark[c - 'a'] = 2;
        }
        for (char c : "zxcvbnm".toCharArray()) {
            mark[c - 'a'] = 3;
        }
        for (String word : words) {
            boolean isOneLined = true;
            int first = mark[Character.toLowerCase(word.charAt(0)) - 'a'];
            for (char c : word.toCharArray()) {
                if (first != mark[Character.toLowerCase(c) - 'a']) {             isOneLined = false;
                    break;
                }
            }
            if (isOneLined) {
                result.add(word);
            }
        }

        String[] res = new String[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
