package leetcode.stack;

import java.util.Stack;

public class EvaluateReversePolishNation150 {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new EvaluateReversePolishNation150().evalRPN(tokens));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.add(Integer.parseInt(token));
            } else {
                int result = 0;
                int sn = stack.pop();
                int fn = stack.pop();
                switch (token) {
                    case "+" -> result += fn + sn;
                    case "-" -> result += fn - sn;
                    case "*" -> result += fn * sn;
                    default -> result += fn / sn;
                }
                stack.add(result);
            }
        }
        return stack.pop();
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
