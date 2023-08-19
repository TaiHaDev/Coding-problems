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
        for (int i = 0; i < vertices + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            adjList.get(sc.nextInt()).add(sc.nextInt());
        }
        List<Integer> result = new ArrayList<>();
        if (topologicalSort(adjList, result)) {
            for (int res : result) {
                System.out.println(res + " ");
            }
        } else {
            System.out.print("Sandro fails.");
        }
    }

    private static boolean topologicalSort(List<List<Integer>> adjList, List<Integer> result) {
        int[] inDegree = new int[adjList.size()];
        Queue<Integer> degree0 = new LinkedList<>();
        for (int u = 1; u < adjList.size(); u++) {
            for (int v : adjList.get(u)) {
                inDegree[v]++;
            }
        }
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) degree0.add(i);
        }
        while (!degree0.isEmpty()) {
            int cur = degree0.remove();
            result.add(cur);
            for (int neighbor : adjList.get(cur)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) degree0.add(neighbor);
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
