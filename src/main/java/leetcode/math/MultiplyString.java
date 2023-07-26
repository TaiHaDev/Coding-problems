package leetcode.math;

public class MultiplyString {
    public static void main(String[] args) {
        System.out.println('Y' - 'A');
    }
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        if (len1 == 0 || len2 == 0 || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        if ("1".equals(num1)) {
            return num2;
        }
        if ("1".equals(num2)) {
            return num1;
        }
        int[] products = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int d1 = Character.getNumericValue(num1.charAt(i));
                int d2 = Character.getNumericValue(num2.charAt(j));
                int mul = d1 * d2;
                products[i + j + 1] += mul % 10;
                products[i + j] = mul / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int item : products) {
            if (item == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(item);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
