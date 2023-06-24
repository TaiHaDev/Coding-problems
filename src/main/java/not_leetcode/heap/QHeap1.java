package not_leetcode.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class QHeap1 {
    public static void main(String[] args) {
        /**
         * The idea is that I remove the element from the set every time the deletion query is called.
         * But we only call the poll only when the element that we deleted b4 is the minimum number (as we can take it out using the poll function)
         *
         */
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < total; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int newNum = sc.nextInt();
                priorityQueue.add(newNum);
                set.add(newNum);
            } else if (type == 2) {
                int newNum = sc.nextInt();
                set.remove(newNum);
                while (!priorityQueue.isEmpty() && !set.contains(priorityQueue.peek())) {
                    priorityQueue.poll();
                }
            } else {
                System.out.println(priorityQueue.peek());
            }
        }
    }
}
