package big_o.array;

import java.util.Scanner;

public class VitalyAndStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        String tmp = solution(s);
        if (!tmp.equals(t)) {
            System.out.println(tmp);
        } else {
            System.out.println("No such string");
        }
    }
    public static String solution(String s) {
        char[] suc = s.toCharArray();
        int carry = 1;
        int index = suc.length - 1;
        while(carry == 1) {
            if (suc[index] == 'z') {
                suc[index] = 'a';
            } else {
                suc[index] = (char) (suc[index] + 1);
                carry = 0;
            }
            index--;
        }
        return new String(suc);
    }
}
