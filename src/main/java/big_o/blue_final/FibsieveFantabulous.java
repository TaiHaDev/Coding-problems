package big_o.blue_final;

import java.util.Scanner;

public class FibsieveFantabulous {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = 1;
        while (n-- > 0) {
            int resRow;
            int resCol;
            int time = sc.nextInt();
            int level = (int) Math.ceil(Math.sqrt(time));
            int mid = level * level + (level - 1) * (level -1) + 1;
            mid /= 2;

            if ((level % 2 == 0 && time > mid) || (level % 2 != 0 && time < mid)) {
                resCol = level;
                resRow = level - (mid - time);
            } else {
                resRow = level;
                resCol = level - (time - mid);
            }
            System.out.println("Case " + c++ + ": " + resCol + " " + resRow);
        }
    }
}
