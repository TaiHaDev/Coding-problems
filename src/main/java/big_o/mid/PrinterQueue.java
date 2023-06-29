package big_o.mid;

import java.util.*;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int jobs = sc.nextInt();
            int pos = sc.nextInt();
            int time = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            Queue<Integer[]> queue = new LinkedList<>();
            for (int i = 0; i < jobs; i++) {
                int prio = sc.nextInt();
                pq.add(prio);
                queue.add(new Integer[] {prio, i == pos ? 1 : 0});
            }
            while (!queue.isEmpty()) {
                if (queue.peek()[0] < pq.peek()) {
                    queue.add(queue.remove());
                } else {
                    time++;
                    Integer[] print = queue.remove();
                    pq.remove();
                    if (print[1] == 1) break;
                }
            }
            System.out.println(time);
        }
    }
}
