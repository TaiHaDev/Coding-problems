package big_o.graph.dijkstra;


import java.util.*;

public class TravellingCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        List<List<Pair>> adjList = new ArrayList<>(vertices + 1);
        for (int i = 0; i < 501; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < vertices; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            adjList.get(v1).add(new Pair(v2, weight));
            adjList.get(v2).add(new Pair(v1, weight));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.second()));
        int start = sc.nextInt();
        pq.add(new Pair(start, 0));
        int[] dist = new int[501];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (cur.second() != dist[cur.first()]) continue;
            for (Pair next : adjList.get(cur.first())) {
                if (next.second() + cur.second() < dist[next.first()]) {
                    pq.add(new Pair(next.first(), next.second() + cur.second()));
                    dist[next.first()] = next.second() + cur.second();
                }
            }
        }
        int n = sc.nextInt();
        while (n-- > 0) {
            int result = dist[sc.nextInt()];
            if (result == Integer.MAX_VALUE) {
                System.out.println("NO PATH");
            } else {
                System.out.println(result);
            }
        }
    }
}

class Pair {
    int fs;
    int sn;

    public Pair(int fs, int sn) {
        this.fs = fs;
        this.sn = sn;
    }
    public int first() {
        return fs;
    }
    public int second() {
        return sn;
    }
}