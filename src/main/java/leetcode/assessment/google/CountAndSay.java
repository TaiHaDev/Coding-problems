package leetcode.assessment.google;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(2));
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";

        return say(countAndSay(n - 1));
    }

    public String say(String in) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            int cur = in.charAt(i);
            int count = 1;
            while (i < in.length() - 1 && in.charAt(i + 1) == cur) {
                count++;
                i++;
            }
            sb.append(count).append(Character.toString(cur));
        }
        return sb.toString();
    }
}
