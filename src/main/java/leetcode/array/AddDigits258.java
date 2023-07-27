package leetcode.array;

public class AddDigits258 {
    public int addDigits(int num) {
        while(num > 9) {
            int temp = 0;
            while(num != 0) {
                temp += num % 10;
                num /= 10;
            }
            num = temp;
        }
        return num;
    }
}
