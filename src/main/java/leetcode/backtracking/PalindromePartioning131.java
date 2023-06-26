package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartioning131 {
    /**
     * Medium question.
     * Intuition: going through all possible partition combination and check if its palindrome. If it hits the base case
     * all the letter is used, we add that new partition combination to the resulting array.
     */
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, s, new ArrayList<>(), 0);
        return result;
    }
    public static void backtrack(List<List<String>> result,String s,  List<String> cur, int index) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s.substring(index, i + 1))) {
                cur.add(s.substring(index, i+1));
                backtrack(result, s, cur, i + 1);
                cur.remove(cur.size() - 1);
            }
        }

    }
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
