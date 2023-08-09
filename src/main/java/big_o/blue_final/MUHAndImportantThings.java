package big_o.blue_final;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MUHAndImportantThings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i++) {
            tasks[i] = new int[] {sc.nextInt(), i + 1};
        }
        Arrays.sort(tasks,  (o1, o2) -> Integer.compare(o1[0], o2[0]));
        List<int[][]> result = new ArrayList<>();
        result.add(tasks.clone());
        for (int i = 1; i < tasks.length; i++) {
            if (tasks[i-1][0] == tasks[i][0]) {
                int[] temp = tasks[i-1];
                tasks[i-1] = tasks[i];
                tasks[i] = temp;
                result.add(tasks.clone());
            }
        }
        if (result.size() >= 3) {
            System.out.println("YES");
            for (int i = 0; i < 3; i++) {
                print(result.get(i));
            }
        } else {
            System.out.println("NO");
        }
    }
    private static void print(int[][] tasks) {
        for (int[] task : tasks) {
            System.out.print(task[1] + " ");
        }
        System.out.println();
    }
}
