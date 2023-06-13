package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses22 {
    public static void main(String[] args) {
        System.out.println(new GenerateParentheses22().generateParenthesis(2));
        int n = 0;

    }



    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result, n, "", new Stack<>(), 0);
        return result;

    }

    private void backtrack(List<String> result,int n, String cur, Stack<String> stack, int count) {
        if (count == n && stack.isEmpty()) {
            result.add(cur);
            return;
        }
        if (count > n) return;
        if (count < n) {
            stack.add("(");
            backtrack(result, n, cur + "(", stack, count + 1);
        }
        if (!stack.isEmpty()) {
            stack.pop();
            backtrack(result, n, cur + ")", stack, count);
        }
    }
}
