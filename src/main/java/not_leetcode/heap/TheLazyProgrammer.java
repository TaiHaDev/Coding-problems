package not_leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TheLazyProgrammer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int contractCount = sc.nextInt();
            PriorityQueue<Contract> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(c -> c.deadline));
            for (int i = 0; i < contractCount; i++) {
                priorityQueue.add(new Contract(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            }
            double curTime = 0;
            double result = 0;
            while (!priorityQueue.isEmpty()) {
                Contract cur = priorityQueue.poll();
                if (cur.normSpeed + curTime > cur.deadline) {
                    double exceedTime = cur.normSpeed + curTime - cur.deadline;
                    double payAmount = Math.ceil(exceedTime * 100 / cur.moneySpeed) / 100;
                    result += payAmount;
                    curTime += cur.normSpeed - cur.moneySpeed * payAmount;
                } else {
                    curTime += cur.normSpeed;
                }
            }
            System.out.printf("%.2f\n", result);
        }
    }
}
class Contract {
    int moneySpeed;
    int normSpeed;
    int deadline;

    public Contract(int moneySpeed, int normSpeed, int deadline) {
        this.moneySpeed = moneySpeed;
        this.normSpeed = normSpeed;
        this.deadline = deadline;
    }
}
