package leetcode.dynamic_programming_1D;

import java.util.Arrays;
import java.util.List;

public class WordBreak139 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new boolean[2]));
        System.out.println(new WordBreak139().wordBreak("applepenapple", List.of("apple", "pen")));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            String cur = s.substring(i);
            for (String str : wordDict) {
                if (cur.startsWith(str)) {
                    dp[i] = dp[i + str.length()];
                    if (dp[i]) break;
                }
            }
        }
        return dp[0];
    }

}
