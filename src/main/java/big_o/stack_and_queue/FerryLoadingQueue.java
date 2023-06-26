package big_o.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class FerryLoadingQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int capacity = sc.nextInt();
            int travelTime = sc.nextInt();
            int totalCars = sc.nextInt();

            Queue<Car> leftBank = new LinkedList<>();
            Queue<Car> rightBank = new LinkedList<>();
            int[] results = new int[totalCars];

            for (int i = 0; i < totalCars; i++) {
                int startingTime = sc.nextInt();
                String bank = sc.next();
                if ("left".equals(bank)) {
                    leftBank.add(new Car(startingTime, i));
                } else {
                    rightBank.add(new Car(startingTime, i));
                }
            }

            int currentTime = 0;
            int currentBank = 0; // 0 for left, 1 for right

            while (!leftBank.isEmpty() || !rightBank.isEmpty()) {
                int nextLeft = leftBank.isEmpty() ? Integer.MAX_VALUE : leftBank.peek().startingTime;
                int nextRight = rightBank.isEmpty() ? Integer.MAX_VALUE : rightBank.peek().startingTime;

                currentTime = Math.max(currentTime, Math.min(nextLeft, nextRight));

                Queue<Car> currentQueue = (currentBank == 0) ? leftBank : rightBank;

                for (int i = 0; i < capacity && !currentQueue.isEmpty() && currentQueue.peek().startingTime <= currentTime; i++) {
                    Car car = currentQueue.poll();
                    results[car.index] = currentTime + travelTime;
                }

                currentTime += travelTime;
                currentBank ^= 1;
            }

            for (int result : results) {
                System.out.println(result);
            }

            if (testCases > 0) {
                System.out.println();
            }
        }
    }

}
class Car {
    int startingTime;
    int index;

    Car(int startingTime, int index) {
        this.startingTime = startingTime;
        this.index = index;
    }
}