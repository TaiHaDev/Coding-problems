package big_o.array;

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
        int armyIndex = 0, vestIndex = 0;
        int count = 0;
        List<int[]> resultPair = new ArrayList<>();
        while (armyIndex < army && vestIndex < vest) {
            if (armySize[armyIndex] - x <= vestSize[vestIndex] && vestSize[vestIndex] <= armySize[armyIndex] + y) {
                count++;
                resultPair.add(new int[]{armyIndex + 1, vestIndex + 1});
                armyIndex++;
                vestIndex++;
            } else if (vestSize[vestIndex] < armySize[armyIndex] - x) {
                vestIndex++;
            } else {
                armyIndex++;
            }
        }
        System.out.println(count);
        for (int[] pair : resultPair) {
            System.out.println(pair[0] + " " + pair[1]);
        }
    }
}