    package big_o.heap;

    import java.util.*;

    public class Promotion {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int days = sc.nextInt();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            Map<Integer, Integer> map = new HashMap<>();
            long result = 0;
            for (int i = 0; i < days; i++) {
                int n = sc.nextInt();
                for (int j = 0; j < n; j++) {
                    int cur = sc.nextInt();
                    maxQueue.add(cur);
                    minQueue.add(cur);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
                while (!maxQueue.isEmpty() && !map.containsKey(maxQueue.peek())) {
                    maxQueue.poll();
                }
                while (!minQueue.isEmpty() && !map.containsKey(minQueue.peek())) {
                    minQueue.poll();
                }
                int maxBill = maxQueue.poll();
                int minBill = minQueue.poll();
                map.put(maxBill, map.get(maxBill) - 1);
                map.put(minBill, map.get(minBill) - 1);
                if (map.get(maxBill) == 0) map.remove(maxBill);
                if (map.get(minBill) == 0) map.remove(minBill);
                result += maxBill - minBill;
            }
            System.out.println(result);
        }
    }
