package big_o.bit_manipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatteyMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        while (total-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            List<Integer> positions = new ArrayList<>();
            int pos = 0;
            while(m > 0) {
                if ((m & 1) == 1) {
                    positions.add(pos);
                }
                pos++;
                m >>= 1;
            }
            StringBuilder res = new StringBuilder();
            for (int i = positions.size() - 1; i >= 0; i--) {
                res.append('(').append(n).append("<<").append(positions.get(i)).append(')');
                if (i != 0) {
                    res.append(" + ");
                }
            }
            System.out.println(res);
        }
    }
}
