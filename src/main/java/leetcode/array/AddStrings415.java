package leetcode.array;

public class AddStrings415 {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        String result = "";
        int carry = 0;
        int dec = 0;
        while(len1 >= 0 || len2 >= 0 || carry > 0) {
            int val1 = 0;
            int val2 = 0;
            if (len1 >= 0) {
                val1 = num1.charAt(len1) - '0';

            }
            if (len2 >= 0) {
                val2 = num2.charAt(len2) - '0';
            }
            int sum = val1 + val2 + carry;
            result = (sum % 10) + result;
            carry = sum / 10;
            len1--;
            len2--;
        }
        return result;
    }
}
