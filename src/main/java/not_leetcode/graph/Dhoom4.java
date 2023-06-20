package not_leetcode.graph;

import java.util.*;

public class Dhoom4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int init = sc.nextInt();
        int target = sc.nextInt();
        int total = sc.nextInt();
        int[] keys = new int[total];
        for (int i = 0; i < total; i++) {
            keys[i] = sc.nextInt();
        }
        System.out.println(bfs(keys, target, init));
    }

    private static int bfs(int[] keys, int target, int init) {
        int result = -1;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(init);
        visited.add(init);

        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int key : keys) {
                    int forgedKey = (int)((long)key * cur % 100000);
                    if (forgedKey == target) return result + 1;
                    if (!visited.contains(forgedKey)) {
                        visited.add(forgedKey);
                        queue.add(forgedKey);
                    }
                }
            }
        }
        return -1;
    }
}