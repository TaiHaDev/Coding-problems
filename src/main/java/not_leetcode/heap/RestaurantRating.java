package not_leetcode.heap;

import java.util.*;

public class RestaurantRating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        while (n-- > 0) {
            int type = sc.nextInt();
            if (type == 1) {
                int rating = sc.nextInt();
                queue.add(rating);

            } else {
                int amount = queue.size() / 3;
                List<Integer> toBeAdded = new LinkedList<>();
                for (int i = 0; i < amount - 1; i++) {
                    toBeAdded.add(queue.poll());
                }
                if (amount == 0) System.out.println("No reviews yet");
                else {
                    System.out.println(queue.peek());
                    queue.addAll(toBeAdded);
                }
            }
        }
    }
}
