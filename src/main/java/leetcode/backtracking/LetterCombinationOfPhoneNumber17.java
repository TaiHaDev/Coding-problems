package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber17 {
    public static void main(String[] args) {
        System.out.println(new LetterCombinationOfPhoneNumber17().letterCombinations("23"));
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        backtrack(result, digits, map, "", 0);
        return result;
    }
    public void backtrack(List<String> result, String digits, Map<String, String> mapping, String cur, int index) {
        if (index >= digits.length()) {
            result.add(cur);
            return;
        }
        String currentLetters = mapping.get(digits.substring(index, index + 1));
        for (int i = 0; i < currentLetters.length(); i++) {
            String temp = cur;
            cur += currentLetters.substring(i, i + 1);
            backtrack(result, digits, mapping, cur, index + 1);
            cur = temp;
        }
    }
}
