package leetcode.stack;

import java.util.Stack;

public class TernaryExpressionParser439 {
    public static void main(String[] args) {
        System.out.println(new TernaryExpressionParser439().parseTernary("T?T?F:5:3"));
    }
    public String parseTernary(String expression) {
        Stack<String> stack = new Stack<>();
        String[] elem = expression.split("[?:]");
        for (String str : elem) {
            stack.push(str);
        }
        return "";
    }
}
