package big_o.array;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int trial = sc.nextInt();
        sc.nextLine();
        String[] passwords = new String[size];
        for (int i = 0; i < size; i++) {
            passwords[i] = sc.nextLine();
        }
        String correctPassword = sc.nextLine();
        int shorterCount = 0;
        int sameLengthCount = 0;
        for (int i = 0; i < size; i++) {
            String cur = passwords[i];
            if (cur.length() < correctPassword.length()) {
                shorterCount++;
            }
            if (cur.length() == correctPassword.length()) {
                sameLengthCount++;
            }
        }
        int bestResult = shorterCount + shorterCount / trial * 5 + 1;
        int worstResult = sameLengthCount + shorterCount + (sameLengthCount + shorterCount) / trial * 5;
        System.out.print(bestResult + " " + worstResult);

    }
}
