package not_leetcode;

import java.util.Scanner;

public class NightAtMuseum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(solution(input));
    }
    public static int solution(String input) {
        int result = 0;
        char last = 'a';
        for (int i = 0; i < input.length(); i++) {
            int distance = Math.abs(input.charAt(i) - last);
            result += Math.min(distance, 26 - distance);
            last = input.charAt(i);
        }
        return result;
    }
}
