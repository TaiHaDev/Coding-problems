package no_category;

public class PalindromicSubstring647 {
    public static void main(String[] args) {
        System.out.println(new PalindromicSubstring647().countSubstrings("aaa"));
    }
    public int countSubstrings(String s) {
        int count = s.length();
        for (int i = 0; i < s.length(); i++) {
            int index = i;
            int left = i - 1;
            while(index < s.length() - 1 && s.charAt(index) == s.charAt(index+1)) {
                index++;
                count++;
            }
            int right = index + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            }
        }
        return count;
    }
}
