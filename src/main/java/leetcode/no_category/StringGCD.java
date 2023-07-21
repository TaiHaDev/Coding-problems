package leetcode.no_category;

public class StringGCD {
    public String gcdOfStrings(String str1, String str2) {
        String base = str1.length() > str2.length() ? str2 : str1;
        for (int i = Math.min(str1.length(), str2.length()); i >= 1; i--) {
            if (isGCD(str1, str2, base.substring(0, i))) {
                return base.substring(0, i);
            }
        }
        return "";
    }
    public boolean isGCD(String str1, String str2, String divisor) {
        if (str1.length() % divisor.length() != 0 && str2.length() % divisor.length() != 0) return false;
        return str1.replace(divisor, "").isEmpty() && str2.replace(divisor, "").isEmpty();
    }
}
