package big_o.mid;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindTheMedian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int heapSize = total / 2 + 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < total; i++) {
            pq.add(sc.nextInt());
            if (pq.size() > heapSize) pq.poll();
        }
        System.out.println(pq.peek());
    }
}
