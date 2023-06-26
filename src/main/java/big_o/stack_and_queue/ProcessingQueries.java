package big_o.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProcessingQueries {

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int capacity = sc.nextInt();
        long[][] tasks = new long[total][3];
        for (int i = 0; i < total; i++) {
            tasks[i] = new long[]{i, sc.nextLong(), sc.nextLong()};
        }
        long[] result = new long[total];
        long[] processingTask = null;
        long curTime = 0;
        Queue<long[]> queue = new LinkedList<>();
        for (int i = 0; i < total; i++) {
            long[] cur = tasks[i];
            if (processingTask == null)
                processingTask = cur;
            else if (queue.size() < capacity) {
                queue.add(cur);
            } else {
                long finishedTime = Math.max(curTime, processingTask[1]) + processingTask[2];
                if (finishedTime <= cur[1]) {
                    result[(int) processingTask[0]] = finishedTime;
                    processingTask = queue.poll();
                    queue.add(cur);
                    curTime = finishedTime;
                } else {
                    result[(int) cur[0]] = -1;
                }
            }
        }
        while (processingTask != null) {
            curTime =  Math.max(curTime, processingTask[1]) + processingTask[2];
            result[(int) processingTask[0]] = curTime;
            if (!queue.isEmpty()) processingTask = queue.poll();
            else processingTask = null;
        }
        for (long num : result) {
            System.out.print(num + " ");
        }
    }
}
