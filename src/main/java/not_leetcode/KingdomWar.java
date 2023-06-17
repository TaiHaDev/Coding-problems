package not_leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KingdomWar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int army = sc.nextInt();
        int vest = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] armySize = new int[army];
        int[] vestSize = new int[vest];
        for (int i = 0; i < army; i++) {
            armySize[i] = sc.nextInt();
        }
        for (int i = 0; i < vest; i++) {
            vestSize[i] = sc.nextInt();
        }

        // logic
        int last = 0;
        int count = 0;
        List<int[]> resultPair = new ArrayList<>();
        for (int i = 0; i < army; i++) {
            for (int j = last; j < vest; j++) {
                if (armySize[i] - x <= vestSize[j] && vestSize[j] <= armySize[i] + y) {
                    last = j + 1;
                    count++;
                    resultPair.add(new int[] {i + 1, j + 1});
                    break;
                }
            }
        }
        System.out.println(count);
        for (int[] pair : resultPair) {
            System.out.println(pair[0] + " " + pair[1]);
        }
    }
}
