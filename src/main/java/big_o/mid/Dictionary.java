package big_o.mid;

import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        sc.nextLine();
        for (int t = 0; t < testCases; t++) {
            List<String> dictionary = new ArrayList<>();
            String s;
            while (!(s = sc.nextLine()).equals("*")) {
                dictionary.add(s);
            }

            Map<String, List<String>> graph = buildGraph(dictionary);

            while (sc.hasNextLine() && !(s = sc.nextLine()).equals("")) {
                String[] pair = s.split(" ");
                System.out.println(pair[0] + " " + pair[1] + " " + bfs(graph, pair[0], pair[1]));
            }
            if (t < testCases - 1) {
                System.out.println();
            }
        }
    }

    private static Map<String, List<String>> buildGraph(List<String> dictionary) {
        Map<String, List<String>> graph = new HashMap<>();
        for (String word : dictionary) {
            graph.put(word, new ArrayList<>());
            for (String other : dictionary) {
                if (canTransform(word, other)) {
                    graph.get(word).add(other);
                }
            }
        }
        return graph;
    }

    private static boolean canTransform(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) diff++;
        }
        return diff == 1;
    }

    private static int bfs(Map<String, List<String>> graph, String start, String end) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, Integer> distance = new HashMap<>();
        queue.offer(start);
        visited.add(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(end)) {
                return distance.get(current);
            }
            for (String neighbour : graph.get(current)) {
                if (!visited.contains(neighbour)) {
                    queue.offer(neighbour);
                    visited.add(neighbour);
                    distance.put(neighbour, distance.get(current) + 1);
                }
            }
        }
        return -1;
    }
}
