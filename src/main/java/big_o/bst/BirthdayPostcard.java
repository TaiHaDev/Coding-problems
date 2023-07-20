package big_o.bst;

import java.util.Scanner;

public class BirthdayPostcard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        int[] sFreq = new int[52];
        int[] tFreq = new int[52];

        for (char c : s.toCharArray())
            sFreq[getCharIndex(c)]++;

        for (char c : t.toCharArray())
            tFreq[getCharIndex(c)]++;

        long yay = 0, whoops = 0;

        for (int i = 0; i < 52; i++) {
            int common = Math.min(sFreq[i], tFreq[i]);
            yay += common;
            sFreq[i] -= common;
            tFreq[i] -= common;
        }

        for (int i = 0; i < 26; i++) {
            int common = Math.min(sFreq[i] + sFreq[i + 26], tFreq[i] + tFreq[i + 26]);
            whoops += common;
        }

        System.out.println(yay + " " + whoops);
    }

    private static int getCharIndex(char c) {
        if (Character.isUpperCase(c))
            return c - 'A';
        else
            return c - 'a' + 26;
    }
}
