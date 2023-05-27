package no_category;

public class DecodeWays91 {
    public static void main(String[] args) {
        System.out.println(new DecodeWays91().numDecodings("06"));
    }
    public int numDecodings(String s) {
        return backtrack(s, 0, new int[s.length()]);
    }
    public int backtrack(String s, int index, int[] memoi) {
        if (index >= s.length()) return 1;
        if (memoi[index] > 0) return memoi[index];
        int cur = Integer.parseInt(s.substring(index, index + 1));
        int count = 0;
        if (cur > 0) {
            count += backtrack(s, index + 1, memoi);
        }
        if (index < s.length() - 1 && cur > 0 && (Integer.parseInt(s.substring(index, index + 2)) < 27)) {
            count += backtrack(s, index + 2, memoi);
        }
        memoi[index] = count;
        return count;
    }
}
