package big_o.topological_sort;

import java.util.*;

public class CompanyHierarchy {
    private int numStudents;
    private List<Integer>[] adjList;

    public CompanyHierarchy(int n) {
        numStudents = n;
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addPreference(int superior, int subordinate) {
        adjList[superior].add(subordinate);
    }

    public List<Integer> topologicalSort() {
        boolean[] visited = new boolean[numStudents];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numStudents; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!stack.isEmpty()) {
            order.add(stack.pop());
        }
        return order;
    }

    private void dfs(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int i : adjList[v]) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }
        stack.push(v);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int I = scanner.nextInt();
        int K = scanner.nextInt();

        CompanyHierarchy hierarchy = new CompanyHierarchy(I);

        for (int k = 0; k < K; k++) {
            int W = scanner.nextInt();
            int superior = k;
            for (int w = 0; w < W; w++) {
                int subordinate = scanner.nextInt() - 1;
                hierarchy.addPreference(superior, subordinate);
            }
        }

        List<Integer> order = hierarchy.topologicalSort();
        int[] bossOf = new int[I];
        int mainBoss = order.get(order.size() - 1);
        for (int i = 0; i < order.size(); i++) {
            int student = order.get(i);
            bossOf[student] = i == order.size() - 1 ? 0 : order.get(i + 1);
        }

        for (int boss : bossOf) {
            System.out.println(boss + 1); // +1 because of 1-based indexing
        }
    }
}
