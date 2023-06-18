package not_leetcode.stack_and_queue;

import java.util.Scanner;
import java.util.Stack;

public class TransformExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        String[] expressions = new String[total];
        for (int i = 0; i < total; i++) {
            expressions[i] = sc.next();
        }
        for (String cur : expressions) {
            Stack<String> stack = new Stack<>();
            for (char c : cur.toCharArray()) {
                if (c == ')') {
                    String snd = stack.pop();
                    String operator = stack.pop();
                    String fst = stack.pop();
                    stack.pop();
                    stack.push(fst + snd + operator);
                } else {
                    stack.push(String.valueOf(c));
                }
            }
            System.out.println(stack.pop());
        }
    }
}
