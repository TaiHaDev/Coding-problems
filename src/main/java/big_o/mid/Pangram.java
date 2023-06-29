package big_o.mid;

import java.util.Scanner;

public class Pangram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] record = new boolean[26];
        int count = 0;
        int total = sc.nextInt();
        String str = sc.next();
        for (char c : str.toCharArray()) {
            c = Character.toLowerCase(c);
            int index = c - 97;
            if (!record[index]) {
                count++;
                record[index] = true;
            }
        }
        if (count == 26) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
