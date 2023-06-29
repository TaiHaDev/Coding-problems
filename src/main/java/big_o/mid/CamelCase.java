package big_o.mid;

import java.util.Scanner;

public class CamelCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int count = 1;
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
