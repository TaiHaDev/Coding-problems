package array;

import java.util.Scanner;

public class VitalyAndStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(solution(s, t));
    }
    public static String solution(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            int distance = Math.abs(c1 - c2);
            if (distance > 1) {
                return s.substring(0, i) + (char) ((c1 + c2) / 2) + s.substring(i + 1);
            }
        }
        return "No such string";
    }
}
