package big_o.topological_sort;

import java.util.*;

public class TopologicalSorting {
    /**
     * Kahn algorithm can detect cycle
     * Kahn algorithm:
     * indegree
     * find 0 degree
     * add to result
     * detect cycle
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList.get(u).add(v);
        }

        List<Integer> result = new ArrayList<>();

        if (topologicalSort(adjList, result)) {
            for (int res : result) {
                System.out.print(res + " ");
            }
        } else {
            System.out.println("Sandro fails.");
        }
    }

    private static boolean topologicalSort(List<List<Integer>> adjList, List<Integer> result) {
        int[] inDegree = new int[adjList.size()];
        PriorityQueue<Integer> degree0 = new PriorityQueue<>();  // Use a PriorityQueue

        for (int u = 1; u < adjList.size(); u++) {
            for (int v : adjList.get(u)) {
                inDegree[v]++;
            }
        }

        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                degree0.add(i);
            }
        }

        while (!degree0.isEmpty()) {
            int cur = degree0.poll();
            result.add(cur);
            for (int neighbor : adjList.get(cur)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    degree0.add(neighbor);
                }
            }
        }

        for (int degree : inDegree) {
            if (degree != 0) {
                return false;
            }
        }
        return true;
    }


}
