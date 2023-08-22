package AOC;

import java.util.Scanner;
import java.util.Stack;

public class SyntaxScoring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 0;
        while (true) {
            String syntax = sc.nextLine();
            if (syntax.isBlank()) break;
            res += validateSyntax(syntax);
        }
        System.out.println(res);
    }

    private static int validateSyntax(String syntax) {
        Stack<Character> stack = new Stack<>();
        for (char c : syntax.toCharArray()) {
            if ("([{<".contains(Character.toString(c))) {
                stack.add(c);
                continue;
            }
            char top = stack.pop();
            if (c == ')' && top != '(') {
                return 3;
            } else if (c == ']' && top != '[') {
                return 57;
            } else if (c == '}' && top != '{') {
                return 1197;
            } else if (c == '>' && top != '<') {
                return 25137;
            }
        }
        return 0;
    }
}
