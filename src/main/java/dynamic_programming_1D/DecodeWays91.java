package dynamic_programming_1D;

public class DecodeWays91 {
    public static void main(String[] args) {
        System.out.println(new DecodeWays91().numDecodings("60"));
    }

    /**
     * Dynamic programming
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int oneBack = s.charAt(0) == '0' ? 0 : 1;
        int twoBack = 1;

        for (int i = 2; i < s.length() + 1; i++) {
            int current = 0;

            if (s.charAt(i - 1) != '0')
                current += oneBack;

            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7'))
                current += twoBack;

            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
    }


    public int numDecodings2(String s) {
        return backtrack(s, 0, new int[s.length()]);
    }


    /**
     * Memoization
     *
     * @param s
     * @param index
     * @param memoi
     * @return
     */
    public int backtrack(String s, int index, int[] memoi) {
        if (index >= s.length()) return 1;
        if (memoi[index] > 0) return memoi[index];
        int cur = Integer.parseInt(s.substring(index, index + 1));
        if (s.charAt(index) == '0') return 0;
        int count = 0;

        count += backtrack(s, index + 1, memoi);
        int twoDigit;
        if (index < s.length() - 1 && (twoDigit = (Integer.parseInt(s.substring(index, index + 2)))) < 27 && twoDigit > 10) {
            count += backtrack(s, index + 2, memoi);
        }
        memoi[index] = count;
        return count;
    }
}
