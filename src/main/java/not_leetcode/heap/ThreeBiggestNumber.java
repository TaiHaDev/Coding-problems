    package not_leetcode.heap;

    import java.util.Comparator;
    import java.util.PriorityQueue;
    import java.util.Scanner;

    public class ThreeBiggestNumber {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int total = sc.nextInt();
            long[] arr = new long[total];
            for (int i = 0; i < total; i++) {
                arr[i] = sc.nextLong();
            }
            PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < total; i++) {
                queue.add(arr[i]);
                if (queue.size() < 3) {
                    System.out.println(-1);
                    continue;
                }
                long fs = queue.poll();
                long sn = queue.poll();
                long tr = queue.poll();
                queue.add(fs);
                queue.add(sn);
                queue.add(tr);
                System.out.println(fs * sn * tr);
            }

        }
    }
