package heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumScoreFromRemovingStones1753 {
    public static void main(String[] args) {
        System.out.println(new MaximumScoreFromRemovingStones1753().maximumScore(2, 4, 6));
    }
    /*
    using heap to get 2 largest numbers
     */
    public int maximumScore2(int a, int b, int c) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(List.of(a, b, c));
        while (true) {
            int fs = pq.poll();
            int snd = pq.poll();
            if (snd == 0) break;
            result++;
            fs--;
            snd--;
            pq.add(fs);
            pq.add(snd);
        }
        return result;
    }

    /**
     * using intuitive math
     */
    public int maximumScore(int a, int b, int c) {
        if (a > b && a > c) return maximumScore(b, c, a);
        else if (b > a && b > c) return maximumScore(a, c, b);

        if (a + b < c) return a + b;
        return c + (a + b - c) / 2;
    }
}
