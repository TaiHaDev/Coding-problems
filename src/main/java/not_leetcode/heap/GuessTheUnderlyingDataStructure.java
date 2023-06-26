package not_leetcode.heap;

import java.util.*;

public class GuessTheUnderlyingDataStructure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            boolean isQueue = true;
            Stack<Integer> stack = new Stack<>();
            boolean isStack = true;
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
            boolean isPQ = true;
            for (int i = 0; i < n; i++) {
                int type = sc.nextInt();
                if (type == 1) {
                    int num = sc.nextInt();
                    queue.add(num);
                    stack.add(num);
                    priorityQueue.add(num);
                } else {
                    int num = sc.nextInt();
                    if (!queue.isEmpty() && queue.poll() != num) isQueue = false;
                    if (!stack.isEmpty() && stack.pop() != num) isStack = false;
                    if (!priorityQueue.isEmpty() && priorityQueue.poll() != num) isPQ = false;
                }
            }
            int count = 0;
            if (isQueue) count++;
            if (isStack) count++;
            if (isPQ) count++;
            if (count > 1) System.out.println("not sure");
            else if (count == 1) {
                if (isQueue) {
                    System.out.println("queue");
                } else if (isStack) {
                    System.out.println("stack");
                } else {
                    System.out.println("priority queue");
                }
            } else {
                System.out.println("impossible");
            }
        }
    }
}
