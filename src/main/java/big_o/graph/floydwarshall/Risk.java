package big_o.graph.floydwarshall;

import java.util.*;

public class Risk {
    static class BoardGame {
        final int MAX = 21;
        int[][] distance = new int[MAX][MAX];

        BoardGame() {
            for (int i = 0; i < MAX; i++)
                Arrays.fill(distance[i], MAX);

            for (int i = 0; i < MAX; i++)
                distance[i][i] = 0;
        }

        void addConnection(int i, int j) {
            distance[i][j] = 1;
            distance[j][i] = 1;
        }

        void floydWarshall() {
            for (int k = 1; k < MAX; k++) {
                for (int i = 1; i < MAX; i++) {
                    for (int j = 1; j < MAX; j++) {
                        if (distance[i][j] > distance[i][k] + distance[k][j]) {
                            distance[i][j] = distance[i][k] + distance[k][j];
                        }
                    }
                }
            }
        }

        int findShortestPath(int start, int destination) {
            return distance[start][destination];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testSet = 1;

        while (scanner.hasNext()) {
            BoardGame game = new BoardGame();

            for (int i = 1; i <= 19; i++) {
                int x = scanner.nextInt();
                for (int j = 0; j < x; j++) {
                    game.addConnection(i, scanner.nextInt());
                }
            }

            game.floydWarshall();

            int pairs = scanner.nextInt();
            System.out.println("Test Set #" + testSet++);
            for (int i = 0; i < pairs; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                int result = game.findShortestPath(start, end);
                System.out.printf("%2d to %2d: %d\n", start, end, result);
            }

            System.out.println();
        }
        scanner.close();
    }
}
