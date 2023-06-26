package big_o.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class AddAll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int total = sc.nextInt();
            if (total == 0) break;
            PriorityQueue<Long> queue = new PriorityQueue<>();
            for (int i = 0; i < total; i++) {
                queue.add(sc.nextLong());
            }
            long result = 0;
            while (queue.size() > 1) {
                long fs = queue.poll();
                long sn = queue.poll();
                long summation = fs + sn;
                result += summation;
                queue.add(summation);
            }
            System.out.println(result);
        }
    }
}
