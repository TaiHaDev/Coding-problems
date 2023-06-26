package big_o.stack_and_queue;

import java.util.Scanner;
import java.util.Stack;

public class MoleculesMass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String formula = sc.next();
        Stack<Integer> stack = new Stack<>();
        for (char c : formula.toCharArray()) {
            switch (c) {
                case 'H' : {
                    stack.push(1);
                    break;
                }
                case 'C' : {
                    stack.push(12);
                    break;
                }
                case 'O' : {
                    stack.push(16);
                    break;
                }
                case '(' : {
                    stack.push(-1);
                    break;
                }
                case ')' : {
                    int add = 0;
                    while(stack.peek() != -1) {
                        add += stack.pop();
                    }
                    stack.pop();
                    stack.push(add);
                    break;
                }
                default : {
                    if (Character.isDigit(c)) {
                        stack.push(stack.pop() * Character.getNumericValue(c));
                    }
                    break;
                }
            }
        }
        int mass = 0;
        while (!stack.isEmpty()) {
            mass += stack.pop();
        }
        System.out.println(mass);
    }
}
