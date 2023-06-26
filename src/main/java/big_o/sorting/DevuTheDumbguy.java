package big_o.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class DevuTheDumbguy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        long studyTime = sc.nextLong();
        Long[] chapters = new Long[total];
        for (int i = 0; i < total; i++) {
            chapters[i] = sc.nextLong();
        }
        Arrays.sort(chapters);
        long totalStudyTime = 0;
        for (int i = 0; i < total; i++) {
            totalStudyTime += chapters[i] * studyTime;
            studyTime = Math.max(1, studyTime - 1);
        }
        System.out.println(totalStudyTime);
    }
}
