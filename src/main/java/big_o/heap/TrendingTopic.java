package big_o.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TrendingTopic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        PriorityQueue<Topic> queue = new PriorityQueue<>(Comparator.comparingInt((Topic t) -> -t.changes).thenComparingInt(t -> -t.id));
        for (int i = 0; i < total; i++) {
            int id = sc.nextInt();
            int oldScore = sc.nextInt();
            int newScore = 50 * sc.nextInt() + 5 * sc.nextInt() + 10 * sc.nextInt() + 20 * sc.nextInt();
            queue.add(new Topic(newScore, newScore - oldScore, id));
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.peek().id + " " + queue.poll().newScore);
        }
    }
}
class Topic {
    int newScore;
    int changes;
    int id;

    public Topic(int newScore, int changes, int id) {
        this.newScore = newScore;
        this.changes = changes;
        this.id = id;
    }
}
