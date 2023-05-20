package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress93 {
    public static void main(String[] args) {
        System.out.println(new RestoreIpAddress93().restoreIpAddresses("101023"));
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, s, 0, "", 0);
        return result;
    }

    public void backtrack(List<String> result, String s, int index, String cur, int dotCount) {
        if (index >= s.length()) {
            if ((cur.length()) == (s.length() + 4)) {
                result.add(cur.substring(0, cur.length() - 1));
            }
            return;
        }
        int loopCount = Math.min(3, s.length() - index);
        for (int i = 0; i < loopCount; i++) {
            String currentStr = s.substring(index, index + i + 1);
            int currentNumber = Integer.parseInt(currentStr);
            if (currentNumber < 10 * i) break;
            if (currentNumber <= 255) {
                backtrack(result, s, index + i + 1, cur + currentNumber + ".",dotCount + 1);
            }
        }
    }

}
