package not_leetcode.stack_and_queue;

import java.util.Scanner;
import java.util.Stack;

public class StreetParade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int total = sc.nextInt();
            if (total == 0) break;
            int[] position = new int[total];
            for (int i = 0; i < total; i++) {
                position[i] = sc.nextInt();
            }
            int expect = 1;
            Stack<Integer> stack = new Stack<>();
            for (int num : position) {
                while (!stack.isEmpty() && stack.peek() == expect) {
                    stack.pop();
                    expect++;
                }
                if (num == expect) {
                    expect++;
                } else {
                    stack.push(num);
                }
            }
            while(!stack.isEmpty() && stack.peek() == expect) {
                stack.pop();
                expect++;
            }
            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
