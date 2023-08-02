package leetcode.bit_manipulation;

public class NumberToHex405 {
    public String toHex(int num) {
        if (num == 0) return "0";
        String result = "";
        while(num != 0) {
            int curHex = num & 15;
            if (curHex < 10) {
                result = "" + curHex + result;
            } else {
                String cur = Character.toString((char) ('a' + curHex - 10));
                result = cur + result;
            }
            num = num >>> 4;
        }
        return result;
    }
}
