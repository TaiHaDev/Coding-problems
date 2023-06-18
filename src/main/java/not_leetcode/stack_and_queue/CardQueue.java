package not_leetcode.stack_and_queue;

import java.util.*;

public class CardQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                queue.add(i);
            }
            List<Integer> discardedCards = new ArrayList<>();
            while(queue.size() > 1) {
                discardedCards.add(queue.poll());
                queue.add(queue.poll());
            }
            String strRepresentation = discardedCards.toString();
            strRepresentation = strRepresentation.substring(1, strRepresentation.length() - 1);
            strRepresentation = strRepresentation.equals("") ? strRepresentation : " " + strRepresentation;
            System.out.println("Discarded cards:" + strRepresentation);
            System.out.println("Remaining card: " + queue.poll());
        }
    }
}
