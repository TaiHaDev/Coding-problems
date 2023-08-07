package leetcode.no_category;

public class FindTheDifference389 {
    public char findTheDifference(String s, String t) {
        int ans = 0;
        for (char c : t.toCharArray()) ans += c;
        for (char c : s.toCharArray()) ans -= c;
        return (char) ans;
    }
}
