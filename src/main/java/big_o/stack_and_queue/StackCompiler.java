package big_o.stack_and_queue;


import java.util.Scanner;
import java.util.Stack;

public class StackCompiler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        String[] expressions = new String[total];
        for (int i = 0; i < total; i++) {
            expressions[i] = sc.next();
        }
        for (String cur : expressions) {
            Stack<Integer> stack = new Stack<>();
            int max = 0;
            char[] charArray = cur.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                if (c == '<') stack.push(i);
                else {
                    if (stack.isEmpty()) {
                        break;
                    }
                    stack.pop();
                    max = stack.isEmpty() ? i + 1 : max; // if stack is empty, the expression is valid so far.
                }
            }
            if (stack.isEmpty()) System.out.println(max);
            else System.out.println(0);
        }
    }
}
