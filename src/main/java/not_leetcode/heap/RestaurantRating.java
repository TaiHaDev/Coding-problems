package not_leetcode.heap;

import java.util.*;

public class RestaurantRating {
    /**
     * complexity: nlogn
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> lowerQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> upperQueue = new PriorityQueue<>();
        int count = 0;
        while (n-- > 0) {
            int type = sc.nextInt();
            if (type == 1) {
                int rating = sc.nextInt();
                count++;
                if (count / 3 > upperQueue.size()) {
                    if (rating < lowerQueue.peek()) {
                        upperQueue.add(lowerQueue.poll());
                        lowerQueue.add(rating);
                    } else {
                        upperQueue.add(rating);
                    }
                } else {
                    if (!lowerQueue.isEmpty() && !upperQueue.isEmpty() && rating > lowerQueue.peek() && rating > upperQueue.peek()) {
                        lowerQueue.add(upperQueue.poll());
                        upperQueue.add(rating);
                    } else {
                        lowerQueue.add(rating);
                    }
                }

            } else {
                if (upperQueue.isEmpty()) {
                    System.out.println("No reviews yet");
                } else {
                    System.out.println(upperQueue.peek());
                }
            }
        }
    }
}
