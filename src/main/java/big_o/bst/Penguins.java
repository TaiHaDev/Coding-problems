package big_o.bst;

import java.util.Scanner;

public class Penguins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = Integer.parseInt(sc.nextLine().trim());
        int[] counts = new int[3];
        for (int i = 0; i < total; i++) {
            String cur = sc.nextLine().trim();
            if (cur.equals("Emperor Penguin")) {
                counts[0]++;
            } else if (cur.equals("Little Penguin")) {
                counts[1]++;
            } else if (cur.equals("Macaroni Penguin")) {
                counts[2]++;
            }
        }
        if (counts[0] > counts[1] && counts[0] > counts[2]) {
            System.out.println("Emperor Penguin");
        } else if (counts[1] > counts[2] && counts[1] > counts[0]) {
            System.out.println("Little Penguin");
        } else {
            System.out.println("Macaroni Penguin");
        }
    }
}