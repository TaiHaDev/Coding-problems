package big_o.stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class HospitalQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCount = 1;
        while (true) {
            int n = sc.nextInt();
            int total = sc.nextInt();
            if (n == 0 && total == 0) break;
            System.out.println("Case " + caseCount + ":");
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 1; i <=  Math.min(n, total); i++) {
                deque.addLast(i);
            }
            for (int i = 0; i < total; i++) {
                String type = sc.next();
                if (type.equals("E")) {
                    int name = sc.nextInt();
                    deque.remove(name);
                    deque.addFirst(name);
                } else {
                    int cur = deque.poll();
                    System.out.println(cur);
                    deque.addLast(cur);
                }
            }
            caseCount++;
        }
    }
}
