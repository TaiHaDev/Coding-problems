package big_o.bst;

import java.util.*;

public class IsenbaevsNumber {
    // making adjacency list from the input then performing bfs to find all the shortest
    // path from ISENBAEV to other players.
    private static final String UNDEFINED = "undefined";
    private static final String ISENBAEV = "Isenbaev";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> numbers = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] names = scanner.nextLine().split(" ");
            for (String name : names) {
                if (!graph.containsKey(name)) {
                    graph.put(name, new ArrayList<>());
                }
            }
            graph.get(names[0]).add(names[1]);
            graph.get(names[0]).add(names[2]);
            graph.get(names[1]).add(names[0]);
            graph.get(names[1]).add(names[2]);
            graph.get(names[2]).add(names[0]);
            graph.get(names[2]).add(names[1]);
        }

        if (graph.containsKey(ISENBAEV)) {
            Queue<String> queue = new LinkedList<>();
            queue.add(ISENBAEV);
            numbers.put(ISENBAEV, "0");

            while (!queue.isEmpty()) {
                String current = queue.remove();
                for (String neighbor : graph.get(current)) {
                    if (!numbers.containsKey(neighbor)) {
                        queue.add(neighbor);
                        int newNumber = Integer.parseInt(numbers.get(current)) + 1;
                        numbers.put(neighbor, String.valueOf(newNumber));
                    }
                }
            }
        }

        for (String name : graph.keySet()) {
            if (!numbers.containsKey(name)) {
                numbers.put(name, UNDEFINED);
            }
        }

        for (Map.Entry<String, String> entry : numbers.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
