package leetcode.two_pointer;

public class ValidPalindromeII680 {
    public static void main(String[] args) {
        System.out.println(new ValidPalindromeII680().validPalindrome("cbbcc"));

    }
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        boolean isUsed = false;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                if (!isUsed && s.charAt(r-1) == s.charAt(l)) {
                    r-=2;
                    l--;
                    isUsed = true;
                } else if (!isUsed && s.charAt(l + 1) == s.charAt(r)) {
                    r--;
                    l+=2;
                    isUsed = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
