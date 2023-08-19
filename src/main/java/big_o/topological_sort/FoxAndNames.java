package big_o.topological_sort;

import java.util.*;

public class FoxAndNames {
    private static final int ALPHABET_SIZE = 26;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }
        String order = findOrder(names);
        System.out.println(order.isEmpty() ? "Impossible" : order);
    }

    private static String findOrder(String[] names) {
        List<Integer>[] graph = buildGraph(names);
        if (graph == null) {
            return "Impossible";
        }
        return topologicalSort(graph);
    }

    private static List<Integer>[] buildGraph(String[] names) {
        List<Integer>[] graph = new ArrayList[ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < names.length - 1; i++) {
            String name1 = names[i];
            String name2 = names[i + 1];
            for (int j = 0; j < Math.min(name1.length(), name2.length()); j++) {
                if (name1.charAt(j) > name2.charAt(j)) {
                    graph[name2.charAt(j) - 'a'].add(name1.charAt(j) - 'a');
                } else if (name1.charAt(j) < name2.charAt(j)) {
                    graph[name1.charAt(j) - 'a'].add(name2.charAt(j) - 'a');
                }
            }
        }
        return graph;
    }


    private static String topologicalSort(List<Integer>[] graph) {
        int[] inDegree = new int[ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            for (int neighbor : graph[i]) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.append((char) (current + 'a'));
            for (int neighbor : graph[current]) {
                if (--inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (order.length() != ALPHABET_SIZE) {
            return "Impossible";
        }
        return order.toString();
    }
}
